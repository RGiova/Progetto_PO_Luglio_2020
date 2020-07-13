package progetto_twitter.Springbootapp.util;

import java.util.ArrayList;

import progetto_twitter.Springbootapp.exceptions.WrongStatisticException;
import progetto_twitter.Springbootapp.model.JSONModel;
import progetto_twitter.Springbootapp.model.StatsModel;

public class Choice {

	public static ArrayList<StatsModel> Stats(String stat,StatsImpl StatObj, ArrayList<JSONModel> List) throws WrongStatisticException {
		switch (stat) {
		case "date":		
			return StatObj.DateminAvgMAX(List);
			break;
		case "url":
			return StatObj.URLminAvgMAX(List);	
			break;
		case "hashtags":
			return StatObj.HminAvgMAX(List);	
			break;
		case "text":
			return StatObj.WminAvgMAX(List);
			break;
		case "image":
			return StatObj.IMGminAvgMAX(List);	
			break;
		}
	}
}
