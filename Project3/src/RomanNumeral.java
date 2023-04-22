/**
 * A class that calculates and records the Roman numerals and their converted Arabic values.
 * It also provides toString, equals, and compareTo methods for RomanNumeral objects 
 * @author Anthony Jerez
 *
 */
public class RomanNumeral {
	private String romanNumeral;
	private int arabicValue;
	/**
	 * Roman Numeral is passed in and checked for its validity 
	 * Roman Numerals with invalid Roman numeral characters are rejected
	 * Converts the valid Roman numeral into its Arabic value and stores it.
	 * @param romanNumeral The Roman numeral passed in
	 */
	
	public RomanNumeral(String romanNumeral) {
		// iterates through each character checking to see if they're all indeed valid Roman numeral characters
		for (int i = 0; i < romanNumeral.length(); i++) {
			if ((romanNumeral.charAt(i) != 'I') && (romanNumeral.charAt(i) != 'V') && (romanNumeral.charAt(i) != 'X') && (romanNumeral.charAt(i) != 'L') && (romanNumeral.charAt(i) != 'C') && (romanNumeral.charAt(i) != 'D') && (romanNumeral.charAt(i) != 'M')) {
				throw new IllegalRomanNumeralException("Invalid Roman Numeral: " + romanNumeral);
			}
		}
		this.romanNumeral = romanNumeral;
		arabicValue = convertToArabicValue();
	}
	/**
	 * Sets the current Roman numeral to be the Roman numeral passed in.
	 * Converts to its Arabic Value once the Roman numeral is changed. 
	 * @param romanNum The Roman Numeral used to replace the current Roman numeral
	 */
	
	public void setRomanNumeral(String romanNum) {
		romanNumeral = romanNum;
		arabicValue = convertToArabicValue();
	}
	/**
	 * Converts the Roman numeral into its Arabic value 
	 * @return The converted Arabic value 
	 */
	
	private int convertToArabicValue() {
		int num = 0;
		// Iterates through each character in the current Roman numeral to provide its corresponding 
		// Arabic value. Adds and records the total of each Roman numeral's Arabic value in a variable named num 
		// to represent the Arabic value of the whole Roman numeral. Also, checks and provides unique values for special cases. 
		for (int i = 0; i < romanNumeral.length(); i++) {
			if (romanNumeral.charAt(i) == 'I') {
				if (i+1 < romanNumeral.length() && romanNumeral.charAt(i+1) == 'V') {
					num += 4;
					i++;
				}
				else if (i+1 < romanNumeral.length() && romanNumeral.charAt(i+1) == 'X') {
					num += 9;
					i++;
				}
				else num++;
			}
			else if (romanNumeral.charAt(i) == 'X') {
				if (i+1 < romanNumeral.length() && romanNumeral.charAt(i+1) == 'L') {
					num += 40;
					i++;
				}
				else if (i+1 < romanNumeral.length() && romanNumeral.charAt(i+1) == 'C') {
					num += 90;	
					i++;
				}
				else num += 10;
			}
			else if (romanNumeral.charAt(i) == 'C') {
				if (i+1 < romanNumeral.length() && romanNumeral.charAt(i+1) == 'D') {
					num += 400;
					i++;
				}
				else if (i+1 < romanNumeral.length() && romanNumeral.charAt(i+1) == 'M') {
					num += 900;
					i++;
				}
				else num += 100;
			}
			else if (romanNumeral.charAt(i) == 'V') num += 5;
			else if (romanNumeral.charAt(i) == 'L') num += 50;
			else if (romanNumeral.charAt(i) == 'D') num += 500;
			else if (romanNumeral.charAt(i) == 'M') num += 1000;		
		}
		return num;
	}
	/**
	 * Retrieves the current Roman numeral
	 * @return The current Roman numeral
	 */
	
	public String getRomanNumeral() {
		return romanNumeral;
	}
	/**
	 * Retrieves the Arabic value for the current Roman numeral
	 * @return The Arabic value for the current Roman numeral
	 */
	
	public int getArabicValue() {
		return arabicValue;
	}
	/**
	 * Displays a Roman Numeral object with its Roman numeral and Arabic value
	 */
	
	public String toString() {
		return "Roman Numeral: " + romanNumeral + "\tArabic Value: " + arabicValue;
	}
	
	/**
	 * Checks if the current Roman Numeral object is equal to another object
	 * @param other The object that the current object is being checked with
	 * @return The (true/false) state of whether both objects are equal 
	 */
	
	public boolean equals(Object other) {
		return (other != null 
				&& getClass() == other.getClass()
				&& romanNumeral.equals(((RomanNumeral) other).romanNumeral)	
				);
	}
	/**
	 * Compares the current Roman Numeral object's Roman numeral with another Roman Numeral object's Roman numeral
	 * to see which is greater (or equal) based on the Unicode value of each character in both Roman numerals
	 * @param other The Roman Numeral object that the current Roman Numeral object is being compared to
	 * @return The state of whether the current Roman Numeral object is greater than, less than, or equal to the other Roman Numeral object
	 */
	
	public int compareTo(RomanNumeral other) {
		return romanNumeral.compareTo(other.romanNumeral);
	}
}
