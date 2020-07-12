package progetto_twitter.Springbootapp.util;
import java.util.ArrayList;


import org.json.simple.JSONArray;


import model.HashModel;
import model.JSONModel;
import model.WordModel;


public interface Stats {
	public  ArrayList<HashModel> HashStats(ArrayList<JSONModel> objp);
	public ArrayList<WordModel> WordStats(ArrayList<JSONModel> objp);
	public ArrayList<WordModel> getTopN(ArrayList<WordModel> WordList, int N);
	public String IMGminAvgMAX(JSONArray objp);
	public String URLminAvgMAX(JSONArray objp);
	public String DateminAvgMAX(JSONArray objp);
	public String HminAvgMAX(ArrayList<HashModel> HashList);
	public String WminAvgMAX(ArrayList<WordModel> WordList);
}
