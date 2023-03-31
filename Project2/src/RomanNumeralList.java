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
	 * Retrieves the first logical node of the list
	 * @return The first logical node of the list
	 */
	
	public RomanNumeralListNode getFirstNode() {
		return first.next;
	}
	/**
	 * Checks if there is indeed another logical node in the list
	 * @param node The current node used for checking its state
	 * @return The (true/false) state of the current node's existence
	 */
	
	public boolean hasNextNode(RomanNumeralListNode node) {
		return (node != null);
	}
	/**
	 * Moves to the next node in the list
	 * @param node The current node in the list 
	 * @return The next node that the current node references
	 */
	
	public RomanNumeralListNode nextNode(RomanNumeralListNode node) {
		return node = node.next;
	}
	/**
	 * Retrieves the size of the list
	 * @return The total number of logical nodes in the list
	 */
	
	public int getLength() {
		return length;
	}
	
}
