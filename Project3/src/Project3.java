/**
 * 
 * @author Anthony Jerez
 * A program that displays a unsorted and sorted list of Roman numerals/Arabic values provided 
 * from the user's selected file. Also, the user is allowed to convert a Roman numeral to its Arabic
 * value. Error checking is provided to ensure valid information is provided by the user.
 * 
 */
public class Project3 {
	/**
	 * Creates a GUI for the user to view and interact with 
	 * The GUI allows them to choose to display information from a selected file and to convert a 
	 * Roman numeral of their choice to its Arabic value
	 * @param args Command line arguments 
	 */
	
	public static void main (String[] args) {
		RomanNumeralGUI myGUI = new RomanNumeralGUI("Roman Numeral to Arabic Unsorted and Sorted Conversion", 1000, 600);
	}
}
