package progetto_twitter.Springbootapp.exceptions;
/**
 * 
 * @author Lorenzo Sopranzetti, Giovanni Recchi, Francesco Pigliapoco
 * Eccezione in caso si fornisca un filtro con formato errato
 *
 */
public class WrongFormatExceptions extends Exception{

public WrongFormatExceptions(String operator) {
		super("After "+operator+" operator square brackets ( :[] ) are expected ");
}
public WrongFormatExceptions(String field, int N) {
	super("After "+field+" field braces (  :{}  )are expected");
}
public WrongFormatExceptions() {
	super("After $bt operator only two elements are expected");
}

}
