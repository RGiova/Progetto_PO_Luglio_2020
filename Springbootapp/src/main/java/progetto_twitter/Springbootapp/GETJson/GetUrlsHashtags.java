package progetto_twitter.Springbootapp.GETJson;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class GetUrlsHashtags {
	private static ArrayList<String> Hashtags;
	private static Vector<String> Urls;
    private static JSONArray temp = new JSONArray();
    
    
public static ArrayList<String> GetHashtags(JSONObject hashtagsObject) {
	 temp = (JSONArray)hashtagsObject.get("hashtags");
	 if (temp!=null) {
	 Iterator i = temp.iterator();
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
public static Vector<String> GetUrls(JSONObject urlsObject) {
		temp = (JSONArray)urlsObject.get("urls");
		if (temp!=null) {
	    Iterator i = temp.iterator();
	    Urls = new Vector<String>();
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