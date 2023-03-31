/**
 * A class that outlines how a sorted Roman Numeral List is structured and filled
 * @author Anthony Jerez
 *
 */
public class SortedRomanNumeralList extends RomanNumeralList {
	/**
	 * Used to create a sorted Roman Numeral list based on the default initial structure of a Roman Numeral list
	 */
	
	public SortedRomanNumeralList() {
		super();
	}
	/**
	 * Sorts and adds another node to the sorted list based on the Arabic value of the Roman Numeral data passed in
	 * The nodes are sorted based on those that contain the smaller Arabic values to those that
	 * contain the larger Arabic values with the first logical node containing the smallest Arabic value 
	 * and the last logical node containing the largest Arabic value.
	 * @param romanNum The Roman Numeral data (Roman numeral and its Arabic value)
	 */
	
	public void add (RomanNumeral romanNum) {
		RomanNumeralListNode currentNode = first;
		// iterates through the references of each node until a node references nothing and as long as 
		// the current node's contained Arabic value is smaller than the Roman Numeral's Arabic value that was passed in
		while (currentNode.next != null && currentNode.next.data.getArabicValue() < romanNum.getArabicValue()) {
			currentNode = currentNode.next;
		}
		// once the loop ends, a new list node is created that references what the current node is referencing
		RomanNumeralListNode newestNode = new RomanNumeralListNode(romanNum, currentNode.next);
		// if the new node created references nothing, then the new node is actually the last node
		if (newestNode.next == null) last = newestNode;
		// the current node's reference is now changed to reference the new list node created
		currentNode.next = newestNode;
		length++;
	}
}
