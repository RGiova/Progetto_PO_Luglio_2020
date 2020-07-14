package progetto_twitter.Springbootapp.exceptions;

public class WrongDateFormatException extends Exception {

	public WrongDateFormatException() {
		super("Wrong date format, expected format is ( gg/mm/yyyy )");

	}

	public WrongDateFormatException(String E) {
		super(E);

	}

}
