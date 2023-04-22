import javax.swing.*;
/**
 * A class that allows the original Roman numerals, unsorted Arabic values, sorted Arabic values to be
 * displayed with a GUI.
 * @author Anthony Jerez
 *
 */

public class RomanNumeralGUI extends JFrame {
	JMenuBar menuBar = new JMenuBar(); // creates a menu bar
	JMenuItem item;
	/**
	 * Initializes the GUI and creates two menus for the user to interact with
	 * @param title the title of the GUI
	 * @param height the height of the GUI used to create its size
	 * @param width the width of the GUI used to create its size
	 */
	
	public RomanNumeralGUI(String title, int height, int width) {
		setTitle(title);
		setSize(height,width);
		setLocation(300,100);
		createFileMenu(); // creates a menu named File and add it to the menu bar
		createConvertMenu(); // creates a menu named Convert and add it to the menu bar
		setJMenuBar(menuBar); // sets the GUI's menu bar to the new one we had created
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);	
	}
	/**
	 * Creates a menu named "File" and the items associated with it.
	 * Event handling is provided to allow for user interaction.
	 */
	
	private void createFileMenu() {
		JMenu fileMenu = new JMenu("File"); // creates a new menu labeled "File"
		FileMenuHandler fmh = new FileMenuHandler(this); 
		item = new JMenuItem("Open"); // creates a new item labeled "Open" 
		item.addActionListener(fmh); // registers it with the actionPerformed method from the file menu's event handler
		fileMenu.add(item); // make this item belong to the File menu
		item = new JMenuItem("Quit"); // creates a new item labeled "Quit"
		item.addActionListener(fmh); // registers it with the actionPerfromed method from the handler 
		fileMenu.add(item); // make this item belong to the File menu
		menuBar.add(fileMenu); // File menu becomes a new menu within the menu bar
	}
	/**
	 * Creates a menu named "Convert" and the items associated with it.
	 * Event handling is provided to allow for user interaction with the items
	 * within the Convert menu created
	 */
	
	private void createConvertMenu() {
		JMenu convertMenu = new JMenu("Convert"); // creates a new menu labeled "Convert"
		ConvertMenuHandler cmh = new ConvertMenuHandler(this); 
		item = new JMenuItem("Roman to Arabic"); // creates a new item labeled "Roman to Arabic"
		item.addActionListener(cmh); // registers it with the actionPerformed method from the convert menu's event handler
		convertMenu.add(item); // makes this item belong to the Convert menu
		menuBar.add(convertMenu); // Convert menu becomes a new menu within the menu bar
	}
}
