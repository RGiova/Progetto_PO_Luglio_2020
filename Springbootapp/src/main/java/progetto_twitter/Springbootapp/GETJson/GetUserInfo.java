package progetto_twitter.Springbootapp.GETJson;
import org.json.simple.JSONObject;
/**
 * 
 * @author Lorenzo Sopranzetti, Giovanni Recchi, Francesco Pigliapoco 
 * Classe che prende le infromazioni relative all'utente
 *
 */
public class GetUserInfo {
	/**
	 * Metodo che prende il nome dell'utente
	 * @param obj
	 * @return
	 */
public static String GetName(JSONObject obj) {
	if(obj!=null)
	return (String)obj.get("name");
	else return null;
}
/**
 * Metodo che prende l'id dell'utente
 * @param Object
 * @return 
 */
public static long GetId(JSONObject Object) {
	if(Object!=null)
	return (long)Object.get("id");
	else return 0;
}
}
