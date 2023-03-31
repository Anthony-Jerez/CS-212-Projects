import javax.swing.*;
import java.awt.*;
/**
 * A class that allows the original Roman numerals, unsorted Arabic values, sorted Arabic values to be
 * displayed with a JFrame.
 * @author Anthony Jerez
 *
 */

public class RomanNumeralGUI extends JFrame {
	Container myContentPane;
	TextArea originalRomanTextArea;
	TextArea unsortedArabicTextArea;
	TextArea sortedArabicTextArea;
	/**
	 * Initializes the GUI and creates three text areas to be filled with the data of the unsorted and
	 * sorted lists of Roman Numerals. The text areas are displayed in separate columns.
	 */
	
	public RomanNumeralGUI() {
		setLocation(400,300);
		setTitle("Roman Numeral to Arabic Unsorted and Sorted Conversion");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		myContentPane = getContentPane();
		myContentPane.setLayout(new GridLayout(1,3));
		originalRomanTextArea = new TextArea();
		unsortedArabicTextArea = new TextArea();
		sortedArabicTextArea = new TextArea();
		myContentPane.add(originalRomanTextArea);
		myContentPane.add(unsortedArabicTextArea);
		myContentPane.add(sortedArabicTextArea);
	}
	/**
	 * Fills the originalRomanTextArea with the unsorted list's Roman numerals.
	 * Fills the unsortedArabicTextArea with the unsorted list's Arabic values.
	 * @param unsortedList The unsorted list of Roman Numerals
	 */

	public void fillUnsortedRomanAndArabicText(UnsortedRomanNumeralList unsortedList) {
		// retrieves the unsorted list's first logical node containing its Roman Numeral
		RomanNumeralListNode node = unsortedList.getFirstNode();
		// checks if there is indeed a node which if found true, both text areas are filled with their 
		// respective data in separate lines
		while (unsortedList.hasNextNode(node)) {
			originalRomanTextArea.append(node.data.getRomanNumeral() + "\n");
			unsortedArabicTextArea.append(Integer.toString(node.data.getArabicValue()) + "\n");
			// moves to the next node in the unsorted list 
			node = unsortedList.nextNode(node);
		}
	}
	/**
	 * Fills the sortedArabicTextArea with the sorted list's Arabic values
	 * @param sortedList The sorted list of Roman Numerals
	 */
	
	public void fillSortedArabicText(SortedRomanNumeralList sortedList) {
		// retrieves the sorted list's first logical node containing its Roman Numeral
		RomanNumeralListNode node = sortedList.getFirstNode();
		// checks if there is indeed a node which if found true, the sortedArabicTextArea is filled 
		// with the sorted Arabic values in separate lines
		while (sortedList.hasNextNode(node)) {
			sortedArabicTextArea.append(Integer.toString(node.data.getArabicValue()) + "\n");
			// moves to the next node in the sorted list
			node = sortedList.nextNode(node);
		}
	} 
}
