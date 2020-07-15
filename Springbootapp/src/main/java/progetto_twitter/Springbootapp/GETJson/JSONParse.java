package progetto_twitter.Springbootapp.GETJson;

import progetto_twitter.Springbootapp.util.*;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import progetto_twitter.Springbootapp.model.*;

/**
 * 
 * @author Lorenzo Sopranzetti, Giovanni Recchi, Francesco Pigliapoco 
 * Classe che effettua il parsing dei JSON inserendo i dati necessari all'interno
 * di un modello prestabilito (JSONModel)
 */
public class JSONParse {
	/**
	 * Attributo utilizzato per scorrere l'array di JSONObject
	 */
	private static JSONObject p1 = new JSONObject();

	/**
	 * Funzione che effettua il parsing dai JSON inserendo le informazioni
	 * desiderate all'interno di un apposito modello. Aggiungendolo poi ad una
	 * lista.
	 * 
	 * @param objp
	 */

	public static void ParseText(JSONArray objp) {
		Iterator<?> i = objp.iterator();
		while (i.hasNext()) {
			JSONModel Mdl = new JSONModel();
			p1 = (JSONObject) i.next();
			Mdl.setDate(ModifyDate.Date((String) p1.get("created_at")));
			Mdl.setText((String) p1.get("full_text"));
			Mdl.setHashtags(GetUrlsHashtags.GetHashtags((JSONObject) p1.get("entities")));
			Mdl.setURL(GetUrlsHashtags.GetUrls((JSONObject) p1.get("entities")));
			Mdl.setImg(GetImage.GetImg((JSONObject) p1.get("entities")));
			Mdl.setPost_id((long) p1.get("id"));
			Mdl.setName(GetUserInfo.GetName((JSONObject) p1.get("user")));
			Mdl.setUser_id(GetUserInfo.GetId((JSONObject) p1.get("user")));
			ListsCreate.Lists.MListAdd(Mdl);
		}
	}

}
