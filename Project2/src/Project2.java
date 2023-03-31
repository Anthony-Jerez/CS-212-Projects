import java.util.StringTokenizer;
/**
 * 
 * @author Anthony Jerez
 * A program that displays a unsorted and sorted list of Roman numerals/Arabic values using JFrame
 * 
 */
public class Project2 {
	static RomanNumeral romanNumeral;
	/**
	 * Creates and fills an unsorted and sorted list with RomanNumeral data based on the Roman Numerals in
	 * the input.txt file. Once filled, both lists and the original Roman Numerals are displayed using 
	 * a GUI.
	 * @param args Command line arguments 
	 */
	
	public static void main (String[] args) {
		SortedRomanNumeralList sortedList = new SortedRomanNumeralList();
		UnsortedRomanNumeralList unsortedList = new UnsortedRomanNumeralList();
		fillLists(sortedList,unsortedList,"input.txt");
		RomanNumeralGUI myGUI = new RomanNumeralGUI();
		myGUI.fillUnsortedRomanAndArabicText(unsortedList);
		myGUI.fillSortedArabicText(sortedList);
		myGUI.pack();
		myGUI.setVisible(true); 
	}
	/**
	 * Each list is filled with nodes that contain the RomanNumeral data
	 * 
	 * @param sortedList The sorted list of Roman Numerals to be filled
	 * @param unsortedList The unsorted list of Roman Numerals to be filled
	 * @param fileName The txt file containing the Roman numerals used to fill both lists
	 */
	
	public static void fillLists (SortedRomanNumeralList sortedList, UnsortedRomanNumeralList unsortedList, String fileName) {
		StringTokenizer tokens;
		TextFileInput in = new TextFileInput(fileName);
		String line = in.readLine();
		// iterates through each line in the text file until a line is empty
		while (line != null) {
			tokens = new StringTokenizer (line, ",");
			// records the number of Roman numerals in the line 
			int limit = tokens.countTokens();
			// fills each list with nodes that contain Roman Numeral data
			for (int i = 0; i < limit; i++) {
				romanNumeral = new RomanNumeral(tokens.nextToken());
				sortedList.add(romanNumeral);
				unsortedList.append(romanNumeral);
			}
			line = in.readLine();
		}
	}
}
