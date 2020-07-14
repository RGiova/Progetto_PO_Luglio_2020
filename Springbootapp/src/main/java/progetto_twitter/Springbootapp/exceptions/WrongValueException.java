package progetto_twitter.Springbootapp.exceptions;

public class WrongValueException extends Exception {

	public WrongValueException() {
		super("All values should be strings: expected format: ( \"value\" ). Or braces (  :{}  )are expected");
	}
	public WrongValueException(String E) {
		super(E+" numerical string are expected. Such has: (\"100\")");
	}
	

}
