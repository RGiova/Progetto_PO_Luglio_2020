package progetto_twitter.Springbootapp.filter;

import java.util.ArrayList;

import progetto_twitter.Springbootapp.exceptions.WrongDateFormatException;
import progetto_twitter.Springbootapp.exceptions.WrongValueException;
import progetto_twitter.Springbootapp.model.JSONModel;
/**
 * 
 * @author Lorenzo Sopranzetti, Giovanni Recchi, Francesco Pigliapoco
 * Interfaccia della classe che filtra i dati in base alla lunghezza del testo, dimensioni delle immagini, data
 */
public interface ImgDateTextFilter {
	/**
	 * Metodo che ritorna true se il singolo dato è da eliminare in base alla lunghezza del testo
	 * @return booleano
	 * @param value
	 * @param obj
	 * @param operator
	 * @param values
	 * @throws WrongValueException
	 * 
	 */
	boolean FilteringofText(String value, JSONModel obj, String operator,ArrayList<String> values) throws WrongValueException;
	/**
	 * Metodo che ritorna true se il singolo dato è da eliminare in base alle dimansioni delle immagini
	 * @return booleano
	 * @param value
	 * @param obj
	 * @param operator
	 * @param values
	 * @param fields
	 * @throws WrongValueException
	 * 
	 */
	boolean FilteringofImages(String fields, JSONModel obj, String value, String operator,ArrayList<String> values) throws WrongValueException;
	/**
	 * Metodo che ritorna true se il singolo dato è da eliminare in base alla data
	 * @return booleano
	 * @param value
	 * @param obj
	 * @param operator
	 * @param values
	 * @throws WrongValueException
	 * 
	 */
	boolean FilteringofDate(JSONModel obj, String value, String operator, ArrayList<String> values) throws WrongDateFormatException;
}
