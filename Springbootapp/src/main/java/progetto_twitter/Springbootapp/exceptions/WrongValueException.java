package progetto_twitter.Springbootapp.exceptions;

public class WrongValueException extends Exception {

	public WrongValueException() {
		super("All values should be strings. Expected format: ( \"value\" )");
	}
	public WrongValueException(String E) {
		super(E+" numerical string are expected. Such has: (\"100\")");
	}
	

}
