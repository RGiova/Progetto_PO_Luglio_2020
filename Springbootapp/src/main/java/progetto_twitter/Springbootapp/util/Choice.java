package progetto_twitter.Springbootapp.util;

import java.util.ArrayList;

import progetto_twitter.Springbootapp.exceptions.WrongStatisticException;
import progetto_twitter.Springbootapp.model.HashModel;
import progetto_twitter.Springbootapp.model.JSONModel;
import progetto_twitter.Springbootapp.model.StatsModel;
import progetto_twitter.Springbootapp.model.WordModel;

public class Choice {

	public static ArrayList<StatsModel> Stats(String stat,StatsImpl StatObj, ArrayList<JSONModel> List, ArrayList<HashModel> HList, ArrayList<WordModel> WList){
		switch (stat) {
		case "date":		
			return StatObj.DateminAvgMAX(List);
		case "url":
			return StatObj.URLminAvgMAX(List);	
		case "hashtags":
			return StatObj.HminAvgMAX(HList);	
		case "text":
			return StatObj.WminAvgMAX(WList);
		case "image":
			return StatObj.IMGminAvgMAX(List);	
		}
		return null;
	}
}
