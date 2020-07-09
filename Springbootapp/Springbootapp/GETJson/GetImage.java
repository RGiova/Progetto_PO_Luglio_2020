package progetto_twitter.Springbootapp.GETJson;
import progetto_twitter.Springbootapp.model.*;
import java.util.Iterator;
import java.util.Vector;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.ParseException;
import progetto_twitter.Springbootapp.model.*;

public class GetImage {
	private static JSONArray Media;
	private static JSONObject MediaObj;
	private static JSONObject Sizes;
	private static JSONObject SizeMedium;
	private static Vector<ImageModel> Img;
public static Vector<ImageModel> GetImg(JSONObject ImgObj) {
		 Media = new JSONArray();
		 Media = (JSONArray)ImgObj.get("media");
		 if (Media!=null) {
		 Img = new Vector<ImageModel>();
		 Iterator i = Media.iterator();
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

