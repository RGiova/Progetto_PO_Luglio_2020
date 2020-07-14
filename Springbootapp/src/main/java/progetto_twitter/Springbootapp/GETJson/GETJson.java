package progetto_twitter.Springbootapp.GETJson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.ParseException;
/**
 * 
 * @author Lorenzo Sopranzetti, Giovanni Recchi, Francesco Pigliapoco
 * Classe che prende i JSON dalla timeline di twitter
 */
public class GETJson {
	/**
	 * Metodo che apre uno stream con le API di twitter e scarica i JSON
	 */
	public static void GETJ() {
		JSONArray obj = null;
		String url = "https://wd4hfxnxxa.execute-api.us-east-2.amazonaws.com/dev/user/1.1/statuses/user_timeline.json?user_id=2890854922&tweet_mode=extended&count=200";
		try {

			URLConnection openConnection = new URL(url).openConnection();
			InputStream in = openConnection.getInputStream();

			String data = "";
			String line = "";
			try {
				InputStreamReader inR = new InputStreamReader(in);
				BufferedReader buf = new BufferedReader(inR);

				while ((line = buf.readLine()) != null) {
					data += line + "\n";
				}
			} finally {
				in.close();
			}
			System.out.println(data);
			obj = new JSONArray();
			obj = (JSONArray) JSONValue.parseWithException(data); // parse JSON Array
		} catch (IOException | ParseException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		JSONParse.ParseText(obj);
	
	}
}
