package progetto_twitter.Springbootapp.GETJson;

import java.util.ArrayList;
import java.util.Iterator;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
/**
 * 
 * @author Lorenzo Sopranzetti, Giovanni Recchi, Francesco Pigliapoco 
 * Classe che prende gli urls e gli hastags presenti all'interno di un JSON
 *
 */
public class GetUrlsHashtags {
	/**
	 * Oggetto utilizzato per contenere gli hashtags presenti
	 */
	private static ArrayList<String> Hashtags;
	/**
	 * Oggeto utilizzato per contenere gli urls presenti
	 */
	private static ArrayList<String> Urls;
	/**
	 * Vettore di appoggio per estrarre hashtags e urls da un JSON 
	 */
    private static JSONArray temp = new JSONArray();
    /**
     * Metodo che prende tutti gli hastags e li inserisce all'interno di un ArrayList  
     * @param hashtagsObject
     * @return
     */
    
public static ArrayList<String> GetHashtags(JSONObject hashtagsObject) {
	 temp = (JSONArray)hashtagsObject.get("hashtags");
	 if (temp!=null) {
	 Iterator<?> i = temp.iterator();
     Hashtags = new ArrayList<String>();
     JSONObject obj = new JSONObject();
	 while (i.hasNext()){
	      obj = (JSONObject)i.next();
	      Hashtags.add((String)obj.get("text"));

	 }
		return Hashtags;
	}
	else {
		return null;
	}
}
/**
 * Metodo che prende tutti gli urls e li inserisce all'interno di un ArrayList
 * @param urlsObject
 * @return
 */
public static ArrayList<String> GetUrls(JSONObject urlsObject) {
		temp = (JSONArray)urlsObject.get("urls");
		if (temp!=null) {
	    Iterator<?> i = temp.iterator();
	    Urls = new ArrayList<String>();
		JSONObject obj = new JSONObject();
		 while (i.hasNext()){
			obj = (JSONObject)i.next();
			Urls.add((String)obj.get("url"));

		 }
			return Urls;
		}
		else {
			return null;
		}
}
}