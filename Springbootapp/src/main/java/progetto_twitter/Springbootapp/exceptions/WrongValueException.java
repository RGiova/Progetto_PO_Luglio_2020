package progetto_twitter.Springbootapp.exceptions;
/**
 * 
 * @author Lorenzo Sopranzetti, Giovanni Recchi, Francesco Pigliapoco
 * Eccezione in caso si fornisca un valore in formato errato
 *
 */
public class WrongValueException extends Exception {

	public WrongValueException() {
		super("All values should be strings: expected format: ( \"value\" ). Or braces (  :{}  )are expected");
	}
	public WrongValueException(String E) {
		super(E+" numerical string are expected. Such has: (\"100\")");
	}
	

}
