package progetto_twitter.Springbootapp.exceptions;

public class EmptyArgumentsException extends Exception{

	public EmptyArgumentsException() {
		super("Error : No tweets found or missing elements for stat calculation");
	}
	

}
