package progetto_twitter.Springbootapp.filter;

import java.util.ArrayList;
import java.util.Iterator;

import progetto_twitter.Springbootapp.exceptions.WrongDateFormatException;
import progetto_twitter.Springbootapp.exceptions.WrongValueException;
import progetto_twitter.Springbootapp.model.JSONModel;
import progetto_twitter.Springbootapp.util.ListsCreate;


/**
 * 
 * @author Lorenzo Sopranzetti, Giovanni Recchi, Francesco Pigliapoco 
 * Classe che gestisce il filtraggio dei dati
 *        
 *
 */
public class FilterImpl {
	/**
	 * Oggetto utilizzato per scansionare la lista dei dati
	 */
	private JSONModel obj;
	/**
	 * Oggetto che contiene metodi per filtrare i dati rispetto a immagini, testo e
	 * data
	 */
	private ImgDateTextFilterImpl Object = new ImgDateTextFilterImpl();
	/**
	 * Attributo booleano utilizzato per individuare i dati da rimuovere. È true se lo specifico elemento della lista è da rimuovere
	 */
	private boolean ToRemove;

	/**
	 * Metodo che gestisce i filtri contenenti l'operatore logico $and o non contenenti operatori logici.
	 * Chiama la funzione FilterUtil che restituisce true se l'elemento della lista è da rimuovere. In quel caso 
	 * questo metodo lo elimina dalla lista.
	 * 
	 * 
	 * @param fields
	 * @param values
	 * @param operator
	 * @throws WrongDateFormatException
	 * @throws WrongValueException
	 */
	public void AndFilter(String fields, ArrayList<String> values, String operator)
			throws WrongDateFormatException, WrongValueException {
		Iterator<JSONModel> i = ListsCreate.Lists.getMList().iterator();
		while (i.hasNext()) {
			obj = new JSONModel();
			obj = (JSONModel) i.next();
			ToRemove = FilterUtil(fields, values, operator);
			if (ToRemove) {
				ListsCreate.Lists.ToPushListDelete(obj);
			}

		}
	}
	/**
	 * Metodo che gestisce i filtri contenenti l'operatore $or
	 * Chiama la funzione FilterUtil che restituisce true se l'elemento della lista è da rimuovere. In quel caso 
	 * questo metodo utilizza due liste d'appoggio, per gestire la logica OR, nelle quali inserisce i dati da rimuovere.
	 * Finiti i filtri tutti i dati da eliminare vengono tolti dalla lista finale (ToPushList). 
	 * @param fields
	 * @param values
	 * @param operator
	 * @param contatore
	 * @param size
	 * @throws WrongDateFormatException
	 * @throws WrongValueException
	 */

	public void OrFilter(String fields, ArrayList<String> values, String operator, int contatore, int size)
			throws WrongDateFormatException, WrongValueException {
		Iterator<?> i;
		if (contatore == 1) {
			i = ListsCreate.Lists.getToPushList().iterator();
			ListsCreate.Lists.ToFilterListCreate();
			ListsCreate.Lists.ToFilterList2Create();
		} else {
			i = ListsCreate.Lists.getToFilterList().iterator();
		}
		while (i.hasNext()) {
			obj = new JSONModel();
			obj = (JSONModel) i.next();
			ToRemove = FilterUtil(fields, values, operator);
			if (ToRemove && contatore == 1)
				ListsCreate.Lists.ToFilterListAdd(obj);
			else if (ToRemove && contatore > 1) {
				ListsCreate.Lists.ToFilterList2Add(obj);

			}

		}
		if (size != 1 && contatore != 1 && ListsCreate.Lists.getToFilterList().size() > 0) {
			ListsCreate.Lists.getToFilterList().clear();
			ListsCreate.Lists.getToFilterList().addAll(ListsCreate.Lists.getToFilterList2());
			ListsCreate.Lists.getToFilterList2().clear();
		}
		if (contatore == size)
			ListsCreate.Lists.getToPushList().removeAll(ListsCreate.Lists.getToFilterList());
	}
	/**
	 * Metodo che identifica il campo del quale è richiesto il filtro e chiama le funzioni per fitlrare i dati.
	 * @param fields
	 * @param values
	 * @param operator
	 * @return ToRemove
	 * @throws WrongDateFormatException
	 * @throws WrongValueException
	 */

	public boolean FilterUtil(String fields, ArrayList<String> values, String operator)
			throws WrongDateFormatException, WrongValueException {
		Iterator<String> J = values.iterator();
		while (J.hasNext()) {
			String Next = J.next();
			if (fields.equals("w") || fields.equals("h") || fields.equals("dimension"))
				ToRemove = Object.FilteringofImages(fields, obj, Next, operator, values);
			else if (fields.equals("text"))
				ToRemove = Object.FilteringofText(Next, obj, operator, values);
			else if (fields.equals("date"))
				ToRemove = Object.FilteringofDate(obj, Next, operator, values);
		}
		return ToRemove;

	}

}
