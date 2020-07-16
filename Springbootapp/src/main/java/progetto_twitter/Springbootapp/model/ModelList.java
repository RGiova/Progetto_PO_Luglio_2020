package progetto_twitter.Springbootapp.model;
import java.util.*;

/** 
 *@author Recchi Giovanni, Sopranzetti Lorenzo, Francesco Pigliapoco
 */

/**
 * Classe per la costruzione di ArrayList di JSONModel
 */

public class ModelList {
	

	static List<JSONModel> MList = new ArrayList<JSONModel>();
	
	/**
	 * Metodo per aggiungere modelli alla lista
	 * @param Mdl
	 */
	
public static void ListAdd(JSONModel Mdl) {
	MList.add(Mdl);
	JSONModel Appoggio = new JSONModel();
	for(int i=0;i<MList.size();i++){
		Appoggio = MList.get(i);
		System.out.println(Appoggio.getURL());
	} 
}
}
