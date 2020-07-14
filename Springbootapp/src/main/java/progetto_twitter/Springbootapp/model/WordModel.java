package progetto_twitter.Springbootapp.model;

/** 
 *@author Recchi Giovanni, Sopranzetti Lorenzo, Francesco Pigliapoco
 */

/**
 * Estensione di HashModel che introduce la lunghezza come paramentro,
 * necessario per le statistiche sulle parole ma non per quelle degli hashtag
 */

public class WordModel extends HashModel {
	private int length;
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	/**
	 * Costruttore della classe, imposta il testo e lunghezza a quelli ricevuti come parametri
	 * e valorizza ad 1 le occorrenze (in quanto vengono costruiti sempre oggetti
	 * non presenti in lista e quindi nuovi)
	 * 
	 * @param text
	 * */
	public WordModel(String text, int length) {
		this.text= text;
		this.length = length;
		Occurrences = 1;
	}
	

}



