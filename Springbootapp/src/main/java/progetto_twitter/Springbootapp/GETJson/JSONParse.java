package progetto_twitter.Springbootapp.GETJson;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.ParseException;
import progetto_twitter.Springbootapp.model.*;
public class JSONParse {
	private static JSONObject p1 = new JSONObject();
public static void ParseText (JSONArray objp) {
      Iterator i = objp.iterator();
	  while(i.hasNext()) {
	  JSONModel Mdl = new JSONModel();
      p1 = (JSONObject)i.next();
      Mdl.setDate ((String)p1.get("created_at"));
      Mdl.setText ((String)p1.get("full_text"));
      Mdl.setHashtags(GetUrlsHashtags.GetHashtags((JSONObject)p1.get("entities")));
      Mdl.setURL(GetUrlsHashtags.GetUrls((JSONObject)p1.get("entities")));
      Mdl.setImg(GetImage.GetImg((JSONObject)p1.get("entities")));
      Mdl.setPost_id((long)p1.get("id"));
      Mdl.setName(GetUserInfo.GetName((JSONObject)p1.get("user")));
      Mdl.setUser_id(GetUserInfo.GetId((JSONObject)p1.get("user")));
      ModelList.ListAdd(Mdl);
	}
}

}
