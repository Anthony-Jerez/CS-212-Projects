/**
 * A class that outlines how a unsorted Roman Numeral list is structured and filled
 * @author Anthony Jerez
 *
 */
public class UnsortedRomanNumeralList extends RomanNumeralList{
	/**
	 * Used to create a unsorted Roman Numeral list based on the default initial structure of a Roman Numeral list
	 */
	
	public UnsortedRomanNumeralList() {
		super();
	}
	/**
	 * Adds a newly created node containing the Roman Numeral data to the end of the unsorted list
	 * to fill it.
	 * @param romanNum The Roman Numeral data (Roman numeral and its Arabic value)
	 */
	
	public void append (RomanNumeral romanNum) {
		RomanNumeralListNode newestNode = new RomanNumeralListNode(romanNum);
		// the current last node is set to reference the new node created
		last.next = newestNode;
		// the last node of the list is now set to be the new node created
		last = newestNode;
		length++;
	}	
}
