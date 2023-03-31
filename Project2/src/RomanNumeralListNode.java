/**
 * A class that outlines the structure of each node in the list
 * @author Anthony Jerez
 *
 */
public class RomanNumeralListNode {
	RomanNumeral data;
	RomanNumeralListNode next;
	/**
	 * Used to create an empty list node that contains and references nothing
	 */
	
	public RomanNumeralListNode () {
		this.data = null;
		this.next = null;
	}
	/**
	 * Used to create a list node that contains the RomanNumeral data that is passed in but
	 * references nothing
	 * @param data The Roman Numeral data (Roman numeral and its Arabic value)
	 */
	
	public RomanNumeralListNode (RomanNumeral data) {
		this.data = data;
		this.next = null;
	}
	/**
	 * Used to create a list node that contains RomanNumeral data and references 
	 * the next node that is passed in 
	 * @param data The Roman Numeral data (Roman numeral and its Arabic value)
	 * @param next The next node that the created node is going to be referencing
	 */
	
	public RomanNumeralListNode (RomanNumeral data, RomanNumeralListNode next) {
		this.data = data;
		this.next = next;
	}
}
