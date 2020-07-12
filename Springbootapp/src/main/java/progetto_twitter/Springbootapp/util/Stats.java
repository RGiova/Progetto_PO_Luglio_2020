package progetto_twitter.Springbootapp.util;
import java.util.ArrayList;



import progetto_twitter.Springbootapp.model.HashModel;
import progetto_twitter.Springbootapp.model.JSONModel;
import progetto_twitter.Springbootapp.model.WordModel;


public interface Stats {
	public ArrayList<HashModel> HashStats(ArrayList<JSONModel> objp);
	public ArrayList<WordModel> WordStats(ArrayList<JSONModel> objp);
	public ArrayList<WordModel> getTopN(ArrayList<WordModel> WordList, int N);
	public String IMGminAvgMAX(ArrayList<JSONModel> objp);
	public String URLminAvgMAX(ArrayList<JSONModel> objp);
	public String DateminAvgMAX(ArrayList<JSONModel> objp);
	public String HminAvgMAX(ArrayList<HashModel> HashList);
	public String WminAvgMAX(ArrayList<WordModel> WordList);
}
