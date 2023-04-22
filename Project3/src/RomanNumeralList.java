/**
 * A class that outlines how the sorted and unsorted Roman Numeral lists are structured.
 * @author Anthony Jerez
 *
 */
public abstract class RomanNumeralList {
	protected RomanNumeralListNode first;
	protected RomanNumeralListNode last;
	protected int length;
	/**
	 * Creates an empty dummy node every time a list is created to help in navigating
	 * around the logical nodes of the list. Initially, variables first and last are set to
	 * refer to the dummy node and are eventually updated as the list is filled. Length is also initialized 
	 * to 0 indicating that the dummy node is not counted as a logical node. 
	 */
	
	public RomanNumeralList() {
		RomanNumeralListNode ln = new RomanNumeralListNode();
		first = ln;
		last = ln;
		length = 0;
	}
	/**
	 * Retrieves the size of the list
	 * @return The total number of logical nodes in the list
	 */
	
	public int getLength() {
		return length;
	}
	/**
	 * Retrieves the list iterator to be used for the specified Roman numeral list
	 * @return the list iterator to be used to iterator through the specified Roman numeral list
	 */
	
	public RomanNumeralListIterator reset() {
		return new RomanNumeralListIterator(first.next);
	}
	
}
