import javax.swing.*;
import java.awt.event.*;
/**
 * A class that handles the event of someone selecting an item from the convert menu
 */

public class ConvertMenuHandler implements ActionListener {
	JFrame jframe;
	
	/**
	 * Used to construct an object of this class to serve as the event handler for the convert menu
	 * @param jf The JFrame that the convert menu is in
	 * 
	 */
	public ConvertMenuHandler(JFrame jf) {
		jframe = jf;
	}
	
	/**
	 * Handles the event of someone choosing to convert a Roman numeral to its Arabic value. 
	 * Error checking is provided to ensure the user's input (Roman numeral) is valid. 
	 * @param event The event registered with this method 
	 */
	public void actionPerformed(ActionEvent event) {
		// retrieves the name of the menu item that the user selected
		String menuName = event.getActionCommand();
		// If the menu item selected was "Roman to Arabic" then allow the user input in a Roman Numeral
		// to convert. The user's input is checked to ensure a valid Roman numeral is provided. If the 
		// input contains invalid characters then the input's error message is printed along with a message box
		// for the user notifying them of its invalidity. However, if the input contains valid characters then
		// the a message box appears with the Roman numeral's Arabic value.
		if (menuName.equals("Roman to Arabic")) {
			try {
				String input = JOptionPane.showInputDialog(null, "Enter a Roman Numeral:");
				RomanNumeral romanNum = new RomanNumeral(input);
				JOptionPane.showMessageDialog(null, "The Arabic value of " + romanNum.getRomanNumeral() + " is: " + romanNum.getArabicValue());
			}
			catch (IllegalRomanNumeralException irne) {
				JOptionPane.showMessageDialog(null, "Invalid Roman Numeral");
				irne.printStackTrace();
			}
			catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Invalid Roman Numeral");
				e.printStackTrace();
			}
		}
	}
}
