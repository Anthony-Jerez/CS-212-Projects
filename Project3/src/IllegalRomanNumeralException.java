/**
 * 
 * A class that outlines how a IllegalRomanNumeralException is constructed
 *
 */
public class IllegalRomanNumeralException extends IllegalArgumentException {
	
	/**
	 * Used to construct a IllegalRomanNumeralException with a message describing the mistake
	 * @param message The message displayed that accompanies this exception
	 */
	public IllegalRomanNumeralException(String message) {
		super(message);
	}
	/**
	 * Used to construct a IllegalRomanNumeralException with a messaging describing the mistake and
	 * the exception type that caused this exception to occur 
	 * @param message The message displayed that accompanies the exception
	 * @param cause The exception type that caused this created exception to occur
	 */
	
	public IllegalRomanNumeralException(String message, Throwable cause) {
		super(message,cause);
	}
}
