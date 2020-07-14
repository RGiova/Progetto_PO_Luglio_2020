package progetto_twitter.Springbootapp.exceptions;
/**
 * 
 * @author Lorenzo Sopranzetti, Giovanni Recchi, Francesco Pigliapoco
 * Eccezione in caso si fornisca un campo errato
 *
 */
public class WrongFieldException extends Exception {
	public WrongFieldException(String E) {
		super(E);

	}

}
