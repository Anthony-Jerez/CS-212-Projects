import java.util.StringTokenizer;

public class Project1 {  	
	static int size; 
	
	public static void main(String[] args) {
		// declares an array that will contain the Roman numerals from the txt file
		String[] romanNumeralList = new String[8];
		// passes the txt file and the romanNumeralList array into a method that fills the contents of the array
		fillRomanNumeralArray("input.txt", romanNumeralList);
		// declares an array that will contain the converted Roman numeral values
		int[] arabicList = new int[size];
		// passes the romanNumeralList array and the empty arabicList array into a method that fills the contents of the empty array
		fillArabicArray(romanNumeralList, arabicList);
		RomanNumeralGUI myGUI = new RomanNumeralGUI(romanNumeralList, arabicList, size);
		// displays both the Roman numerals and Arabic numerals 
		myGUI.displayConversion();
	}
	
	public static void fillRomanNumeralArray(String fileName, String[] array) {
		TextFileInput in = new TextFileInput(fileName);
		String line = in.readLine();
		StringTokenizer tokens;
		// iterates through each line in the txt file until the line read is empty
		while (line != null) {
			// for each line that's read, separate each Roman numeral using the presence of a comma
			tokens = new StringTokenizer(line, ",");
			// records the count of Roman numerals read in the line
			int limit = tokens.countTokens();
			// Chronologically, fills each index of the romanNumeralList array with each Roman numeral read from the line
			for (int i = 0; i < limit; i++) {
				array[size++] = tokens.nextToken();
			}
			line = in.readLine();
		}
		in.close();	
	}
	
	public static void fillArabicArray(String[] romanNumeralArray, int[] arabicArray) {
		// iterates through each index of the arabicArray and fills it with the converted Roman numeral value
		for (int i = 0; i < size; i++) {
			arabicArray[i] = convertValue(romanNumeralArray, i);
		}
	}
	
	public static int convertValue(String[] array, int index) { 
		int num = 0;
		int length = array[index].length();
		// iterates through each character of the Roman numeral passed into this method to calculate its converted value
		// the Roman numeral value examined is based on the current index of the romanNumeralList array that's passed
		for (int j = 0; j < length; j++) {
			// if a character in the Roman numeral is 'I', examine two more conditions
			if (array[index].charAt(j) == 'I') {
				// if going to the next character number doesn't go out of bounds and the next character is 'V',
				// then add the value of 'IV' to num and skip the next character ('V')
				if ((j+1 < length) && (array[index].charAt(j+1) == 'V')) {
					num += (5 - 1);
					j++;
				}
				// if going to the next character number doesn't go out of bounds and the next character is 'X',
				// then add the value of 'IX' to num and skip the next character ('X')
				else if ((j+1 < length) && (array[index].charAt(j+1) == 'X')) {
					num += (10 - 1);
					j++;
				}
				else num++; // if the the last two conditions aren't met, then add 1 to num allowing 'I' to be represented as 1
			}
			// if a character in the Roman numeral is 'V', then add 5 to num allowing 'V' to be represented as 5
			else if (array[index].charAt(j) == 'V') num += 5;
			// if a character in the Roman numeral is 'X', examine two more conditions
			else if (array[index].charAt(j) == 'X') {
				// if going to the next character number doesn't go out of bounds and the next character is 'L',
				// then add the value of 'XL' to num and skip the next character ('L')
				if ((j+1 < length) && (array[index].charAt(j+1) == 'L')) {
					num += (50 - 10);
					j++;
				}
				// if going to the next character number doesn't go out of bounds and the next character is 'C',
				// then add the value of 'XC' to num and skip the next character ('C')
				else if ((j+1 < length) && (array[index].charAt(j+1) == 'C')) {
					num += (100 - 10);
					j++;
				}
				else num += 10; // if the the last two conditions aren't met, then add 10 to num allowing 'X' to be represented as 10
			}
			// if a character in the Roman numeral is 'L', then add 50 to num allowing 'L' to be represented as 50
			else if (array[index].charAt(j) == 'L') num += 50; 
			// if a character in the Roman numeral is 'C', examine two more conditions
			else if (array[index].charAt(j) == 'C') {
				// if going to the next character number doesn't go out of bounds and the next character is 'D',
				// then add the value of 'CD' to num and skip the next character ('D')
				if ((j+1 < length) && (array[index].charAt(j+1) == 'D')) {
					num += (500 - 100);
					j++;
				}
				// if going to the next character number doesn't go out of bounds and the next character is 'M',
				// then add the value of 'CM' to num and skip the next character ('M')
				else if ((j+1 < length) && (array[index].charAt(j+1) == 'M')) {
					num += (1000 - 100);
					j++;
				}
				else num += 100; // if the the last two conditions aren't met, then add 100 to num allowing 'C' to be represented as 100
			}
			// if a character in the Roman numeral is 'D', then add 500 to num allowing 'D' to be represented as 500
			else if (array[index].charAt(j) == 'D') num += 500;
			// if a character in the Roman numeral is 'M', then add 1000 to num allowing 'M' to be represented as 1000
			else if (array[index].charAt(j) == 'M') num += 1000;
		}
		return num;
	}
}