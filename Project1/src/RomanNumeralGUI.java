import javax.swing.*;
import java.awt.*;

public class RomanNumeralGUI extends JFrame {
	String[] romanNumArray;
	int[] arabicArray;
	int length;
	
	public RomanNumeralGUI (String[] romanNumeralList, int[] arabicList, int size) {
		romanNumArray = romanNumeralList;
		arabicArray = arabicList;
		length = size;
		// initializes the GUI 
		setSize(400,200);
		setLocation(400, 300);
	    setTitle("Roman Numeral to Arabic Converter");
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void displayConversion() {
		Container myContentPane = getContentPane();
	    setLayout(new GridLayout(1,2));
		TextArea myRomanNumeralTextArea = new TextArea();
		TextArea myArabicTextArea = new TextArea();
		myContentPane.add(myRomanNumeralTextArea);
		myContentPane.add(myArabicTextArea);
		// iterates through the values of both arrays to display their values separately 
		// Roman numerals are displayed on the left with each value being in a new line
		// Arabic numerals are displayed on the right with each value being in a new line
		for (int i = 0; i < length; i++) {
			myRomanNumeralTextArea.append(romanNumArray[i] + "\n");
			myArabicTextArea.append(Integer.toString(arabicArray[i]) + "\n");
		}
		setVisible(true);
	}
}