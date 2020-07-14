package progetto_twitter.Springbootapp.model;

/** 
 *@author Recchi Giovanni, Sopranzetti Lorenzo, Francesco Pigliapoco
 */

/**
 * Modello per analizzare le hashtag, implementa comparable
 */

public class HashModel implements Comparable<HashModel>  {
	protected String text;
	protected int Occurrences;
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public int getOccurrences() {
		return Occurrences;
	}
	public void setOccurrences(Integer Occurrences) {
		this.Occurrences = Occurrences;
	}
	/**
	 * Costruttore della classe, imposta il testo a quello ricevuto in input
	 * e valorizza ad 1 le occorrenze (in quanto vengono costruiti sempre oggetti
	 * non presenti in lista e quindi nuovi)
	 * 
	 * @param text
	 * */
	public HashModel(String text) {
		this.text = text;
		Occurrences = 1;
	}
	public HashModel() {
	}
	
	/**
	 * Metodo che sovrascrive il normale compareTo per ottenere
	 * un comparator che ordini in maniera decrescente per occorrenze
	 * una collection
	 * 
	 * @param HashCompare
	 * */
	
	@Override
	public int compareTo(HashModel HashCompare) {
    	int compareOcc=((HashModel)HashCompare).getOccurrences();


    	/*In ordine decrescente*/
    	return compareOcc-this.Occurrences;
	}
}
