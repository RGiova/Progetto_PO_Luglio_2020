package progetto_twitter.Springbootapp.exceptions;

public class WrongOperatorException extends Exception {

	public WrongOperatorException(String E) {
		super(E + " expected operators are [$not,$in,$nin,$gt,$gte,$lt,$lte,$bt]");

	}

}
