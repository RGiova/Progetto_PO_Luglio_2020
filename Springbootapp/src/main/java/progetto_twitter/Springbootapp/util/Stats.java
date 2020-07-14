package progetto_twitter.Springbootapp.util;
import java.util.ArrayList;


import progetto_twitter.Springbootapp.model.StatsModel;
import progetto_twitter.Springbootapp.exceptions.EmptyArgumentsException;
import progetto_twitter.Springbootapp.model.HashModel;
import progetto_twitter.Springbootapp.model.JSONModel;
import progetto_twitter.Springbootapp.model.WordModel;


public interface Stats {
	public ArrayList<HashModel> HashStats(ArrayList<JSONModel> objp) throws EmptyArgumentsException;
	public ArrayList<WordModel> WordStats(ArrayList<JSONModel> objp) throws EmptyArgumentsException;
	public ArrayList<WordModel> getTopN(ArrayList<WordModel> WordList, int N) throws EmptyArgumentsException;
	public ArrayList<StatsModel> IMGminAvgMAX(ArrayList<JSONModel> objp) throws EmptyArgumentsException;
	public ArrayList<StatsModel> URLminAvgMAX(ArrayList<JSONModel> objp) throws EmptyArgumentsException;
	public ArrayList<StatsModel> DateminAvgMAX(ArrayList<JSONModel> objp) throws EmptyArgumentsException;
	public ArrayList<StatsModel> HminAvgMAX(ArrayList<HashModel> HashList) throws EmptyArgumentsException;
	public ArrayList<StatsModel> WminAvgMAX(ArrayList<WordModel> WordList) throws EmptyArgumentsException;
}
