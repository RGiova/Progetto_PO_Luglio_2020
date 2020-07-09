package progetto_twitter.Springbootapp.GETJson;
import org.json.simple.JSONObject;

public class GetUserInfo {
public static String GetName(JSONObject obj) {
	if(obj!=null)
	return (String)obj.get("name");
	else return null;
}

public static long GetId(JSONObject Object) {
	if(Object!=null)
	return (long)Object.get("id");
	else return 0;
}
}
