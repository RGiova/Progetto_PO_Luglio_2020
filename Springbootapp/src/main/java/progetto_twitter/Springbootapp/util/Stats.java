package progetto_twitter.Springbootapp.util;
import java.util.ArrayList;


import progetto_twitter.Springbootapp.model.StatsModel;
import progetto_twitter.Springbootapp.model.HashModel;
import progetto_twitter.Springbootapp.model.JSONModel;
import progetto_twitter.Springbootapp.model.WordModel;


public interface Stats {
	public ArrayList<HashModel> HashStats(ArrayList<JSONModel> objp);
	public ArrayList<WordModel> WordStats(ArrayList<JSONModel> objp);
	public ArrayList<WordModel> getTopN(ArrayList<WordModel> WordList, int N);
	public ArrayList<StatsModel> IMGminAvgMAX(ArrayList<JSONModel> objp);
	public ArrayList<StatsModel> URLminAvgMAX(ArrayList<JSONModel> objp);
	public ArrayList<StatsModel> DateminAvgMAX(ArrayList<JSONModel> objp);
	public ArrayList<StatsModel> HminAvgMAX(ArrayList<HashModel> HashList);
	public ArrayList<StatsModel> WminAvgMAX(ArrayList<WordModel> WordList);
}
