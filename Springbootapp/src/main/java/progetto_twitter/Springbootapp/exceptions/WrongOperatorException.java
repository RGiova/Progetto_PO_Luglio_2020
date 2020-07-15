package progetto_twitter.Springbootapp.exceptions;
/**
 * 
 * @author Lorenzo Sopranzetti, Giovanni Recchi, Francesco Pigliapoco
 * Eccezione in caso si abbia un operatore errato
 *
 */
public class WrongOperatorException extends Exception {

	public WrongOperatorException(String E) {
		super(E + " expected operators are [$not,$in,$nin,$gt,$gte,$lt,$lte,$bt]");

	}

}
