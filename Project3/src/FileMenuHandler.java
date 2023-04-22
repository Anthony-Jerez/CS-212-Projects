import javax.swing.*;
import java.util.StringTokenizer;
import java.awt.event.*;
import java.awt.*;
import java.io.*;

/**
 * A class that handles the event of someone selecting an item from the file menu
 */
public class FileMenuHandler implements ActionListener {
	JFrame jframe;
	Container myContentPane;
	JTextArea originalRomanTextArea;
	JTextArea unsortedArabicTextArea;
	JTextArea sortedArabicTextArea;
	UnsortedRomanNumeralList unsortedList;
	SortedRomanNumeralList sortedList;
	RomanNumeralListIterator rnli;
	/**
	 * Used to construct an object of this class to serve as the event handler for the file menu
	 * @param jf The jframe that the file menu is in
	 */
	
	public FileMenuHandler (JFrame jf) {
		jframe = jf;
	}
	/**
	 * Handles the event of someone choosing to either open a file or exit the window
	 * Error checking is provided to ensure that the information from the opened file are valid Roman numerals
	 */
	
	public void actionPerformed(ActionEvent event) {
		// retrieves the name of the menu item that the user selected
		String menuName = event.getActionCommand();
		// if the menu item selected was "Open", then the user is allowed to select a file to open and display information
		if (menuName.equals("Open")) {
			openFile();
		}
		// Otherwise, if the menu item selected was "Quit", then the window closes, allowing the user to exit the program
		else if (menuName.equals("Quit")) {
			System.exit(0);
		}
	}
	/**
	 * Used to open the file selected by the user while verifying the information and then displaying it for the user to view
	 */
	
	private void openFile() {
		// chooser allows the user to view and access their files
		JFileChooser chooser = new JFileChooser();
		chooser.showOpenDialog(null);
		// creates an unsorted and sorted Roman numeral list to be filled
		unsortedList = new UnsortedRomanNumeralList();
		sortedList = new SortedRomanNumeralList();
		readSource(chooser.getSelectedFile()); // reads the information from the file
		displaySource(); // displays the information for the user to see
	}
	/**
	 * Used to read the information from the file selected by the user
	 * Each list is filled with nodes that contain the Roman Numeral data
	 * @param chosenFile The file that the user selected to display
	 */
	
	private void readSource(File chosenFile) {
		String fileName = chosenFile.getAbsolutePath();
		TextFileInput in = new TextFileInput(fileName);
		StringTokenizer tokens;
		RomanNumeral romanNum;
		String line = in.readLine();
		// iterates through each line in the text file until a line is empty
		while (line != null) {
			tokens = new StringTokenizer(line, ",");
			// records the number of Roman numerals in the line 
			int limit = tokens.countTokens();
			// fills each list with nodes that contain Roman Numeral data
			// error checking is provided to ensure that the data provided are valid Roman Numerals
			// invalid Roman numerals are not stored in the lists and not displayed to the GUI. 
			// an error message is displayed to the console for invalid Roman numerals
			for (int i = 1; i <= limit; i++) {
				try {
					romanNum = new RomanNumeral(tokens.nextToken());
					unsortedList.append(romanNum);
					sortedList.add(romanNum);
				}
				catch (IllegalRomanNumeralException irne) {
					irne.printStackTrace();
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
			line = in.readLine();
		}
	}
	/**
	 * Displays the information provided by the selected file that was stored in the 
	 * unsorted and sorted Roman numeral list 
	 */
	
	private void displaySource() {
		myContentPane = jframe.getContentPane();
		myContentPane.removeAll();
		// creates three text areas to display the original Roman numerals, unsorted Arabic values, and sorted Arabic values
		myContentPane.setLayout(new GridLayout(1,3));
		originalRomanTextArea = new JTextArea("Original Roman Numerals:\n\n");
		unsortedArabicTextArea = new JTextArea("Unsorted Arabic Values:\n\n");
		sortedArabicTextArea = new JTextArea("Sorted Arabic Values:\n\n");
		myContentPane.add(originalRomanTextArea);
		myContentPane.add(unsortedArabicTextArea);
		myContentPane.add(sortedArabicTextArea);
		// fills the text areas with the appropriate Roman numeral data
		fillUnsortedRomanAndArabicText(); 
		fillSortedArabicText();
	}
	/**
	 * Fills the originalRomanTextArea with the unsorted list's Roman numerals.
	 * Fills the unsortedArabicTextArea with the unsorted list's Arabic values.
	 */
	
	private void fillUnsortedRomanAndArabicText() {
		// sets the list iterator to iterate through the unsorted Roman numeral list
		rnli = unsortedList.reset();
		// checks if there is indeed a node which if found true, both text areas are filled with their
		// respective data in separate lines
		while (rnli.hasNextNode()) {
			originalRomanTextArea.append(rnli.nextRomanNumeral()+ "\n");
			unsortedArabicTextArea.append(rnli.nextArabicValue() + "\n");
			// moves to the next node in the unsorted list using the list iterator 
			rnli.nextNode();
		}
	}
	
	private void fillSortedArabicText() {
		// sets the list iterator to iterate through the sorted Roman numeral list
		rnli = sortedList.reset();
		// checks if there is indeed a node which if found true, the sortedArabicTextArea is filled 
		// with the sorted Arabic values in separate lines
		while (rnli.hasNextNode()) {
			sortedArabicTextArea.append(rnli.nextArabicValue() + "\n");
			// moves to the next node in the sorted list using the list iterator
			rnli.nextNode();
		}
	}
}
