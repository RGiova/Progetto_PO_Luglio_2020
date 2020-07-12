package progetto_twitter.Springbootapp.exceptions;

public class WrongFormatExceptions extends Exception{

public WrongFormatExceptions(String operator) {
		super("After "+operator+" operator square brackets ( :[] ) are expected ");
}
public WrongFormatExceptions(String field, int N) {
	super("After "+field+" field braces (  :{}  )are expected");
}

}
