package progetto_twitter.Springbootapp.exceptions;
/**
 * 
 * @author Lorenzo Sopranzetti, Giovanni Recchi, Francesco Pigliapoco
 * Eccezione in caso si abbia un formato errato per la data
 *
 */
public class WrongDateFormatException extends Exception {

	public WrongDateFormatException() {
		super("Wrong date format, expected format is ( gg/mm/yyyy )");

	}

	public WrongDateFormatException(String E) {
		super(E);

	}

}
