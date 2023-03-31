// Must import the JOptionPane class
import javax.swing.JOptionPane;
public class Project0{
    public static void main(String[] args){
        // Program runs until while loop breaks
        while (true){
            String sentence = JOptionPane.showInputDialog(null, "Please enter a sentence.");
            // Progam ends if the user inputs "stop" as its whole sentence without being case-sensitive
            if (sentence.equalsIgnoreCase("Stop")) break;
            int lowerCaseEs = 0, upperCaseEs = 0;
            // Iterates over each character in the sentence the user inputs
            for (int i = 0; i < sentence.length(); i++){
                // If a character in the user's sentence is 'e', the counter for 'e' increments by 1
                if (sentence.charAt(i) == 'e') {
                    lowerCaseEs++;
                }
                // If a character in the user's sentence is 'E', the counter for 'E' increments by 1
                else if (sentence.charAt(i) == 'E') {
                    upperCaseEs++;
                }
            }
            // Displays the count of letters 'e' and 'E' in seperate lines
            JOptionPane.showMessageDialog(null, "Number of lower case e's: " + lowerCaseEs + "\nNumber of upper case e's: " + upperCaseEs);
        }
    }
}