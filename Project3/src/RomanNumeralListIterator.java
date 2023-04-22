/**
 * 
 * A class that provides a way of iterating through a Roman Numeral list securely
 *
 */
public class RomanNumeralListIterator {
	private RomanNumeralListNode node;
	/**
	 * Used to construct the list iterator starting with the first logical node of the list
	 * @param firstNode The first logical node passed from the list
	 */
	
	public RomanNumeralListIterator(RomanNumeralListNode firstNode) {
		node = firstNode;
	}
	/**
	 * Checks if there is indeed another logical node in the list
	 * @return the (true/false) state of the current node's existence
	 */
	
	public boolean hasNextNode() {
		return (node != null);
	}
	/**
	 * Moves to the next node in the list
	 */
	
	public void nextNode() {
		node = node.next;
	}
	/**
	 * Retrieves the current node's Roman numeral value
	 * @return the current node's Roman numeral 
	 */
	
	public String nextRomanNumeral() {
		return node.data.getRomanNumeral();
	}
	/**
	 * Retrieves the current node's Arabic value
	 * @return the current node's Arabic value
	 */
	
	public int nextArabicValue() {
		return node.data.getArabicValue();
	}
}
