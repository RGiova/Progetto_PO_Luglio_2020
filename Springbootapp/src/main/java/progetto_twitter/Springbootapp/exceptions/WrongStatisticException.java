package progetto_twitter.Springbootapp.exceptions;
/**
 * 
 * @author Lorenzo Sopranzetti, Giovanni Recchi, Francesco Pigliapoco
 * Eccezione in caso si richieda una statistica errata
 *
 */
public class WrongStatisticException extends Exception {

	public WrongStatisticException(String E) {
		super(E);
	}
}
