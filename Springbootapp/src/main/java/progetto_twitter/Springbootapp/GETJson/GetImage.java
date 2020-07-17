package progetto_twitter.Springbootapp.GETJson;
import progetto_twitter.Springbootapp.model.*;
import java.util.Iterator;
import java.util.Vector;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
/**
 * 
 * @author Lorenzo Sopranzetti, Giovanni Recchi, Francesco Pigliapoco 
 * Classe che prende tutti i parametri delle immagini contenute nel JSON
 *
 */
public class GetImage {
	/**
	 * JSONArray utilizzato come appoggio per accedere alle informazioni
	 */
	private static JSONArray Media;
	/**
	 * JSONobject utilizzato come appoggio per accedere alle informazioni
	 */
	private static JSONObject MediaObj;
	/**
	 * JSONobject utilizzato come appoggio per accedere alle informazioni
	 */
	private static JSONObject Sizes;
	/**
	 * JSONobject utilizzato come appoggio per accedere alle informazioni
	 */
	private static JSONObject SizeMedium;
	/**
	 * Vector che contine al suo interno tutte le informazioni sulle immagini del singolo post codificate attraverso un apposito modello
	 */
	private static Vector<ImageModel> Img;
	/**
	 * Metodo che prende le informazioni relative alle immagini contenute in un post inserendole all'interno di un modello che viene aggiunto all'interno di un Vector
	 * @param ImgObj
	 * @return Img
	 */
public static Vector<ImageModel> GetImg(JSONObject ImgObj) {
		 Media = new JSONArray();
		 Media = (JSONArray)ImgObj.get("media");
		 if (Media!=null) {
		 Img = new Vector<ImageModel>();
		 Iterator<?> i = Media.iterator();
	     MediaObj = new JSONObject();
	     Sizes = new JSONObject();
	     SizeMedium = new JSONObject();
	     while(i.hasNext()) {
	    	 MediaObj = (JSONObject)i.next();
	    	 Sizes =(JSONObject)MediaObj.get("sizes");
	    	 SizeMedium =(JSONObject)Sizes.get("medium");
	    	 ImageModel ImgM = new ImageModel((long)SizeMedium.get("w"),(long)SizeMedium.get("h"));
	    	 Img.add(ImgM);
	    	 }
	 	return Img;
	}
	else 
	return null;
}
}

