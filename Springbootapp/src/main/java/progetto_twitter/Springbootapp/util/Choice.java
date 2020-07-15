package progetto_twitter.Springbootapp.util;

import java.util.ArrayList;

import progetto_twitter.Springbootapp.exceptions.EmptyArgumentsException;
import progetto_twitter.Springbootapp.model.HashModel;
import progetto_twitter.Springbootapp.model.JSONModel;
import progetto_twitter.Springbootapp.model.StatsModel;
import progetto_twitter.Springbootapp.model.WordModel;
/**
 * Classe che identifica la statistica richiesta
 * @author Lorenzo Sopranzetti, Giovanni Recchi, Francesco Pigliapoco 
 *
 */
public class Choice {
/**
 * Metodo che identifica la statistica richiesta e chiama la funzione che effettua la statistica
 * @param stat
 * @param StatObj
 * @param List
 * @param HList
 * @param WList
 * @return null 
 * @throws EmptyArgumentsException 
 */
	public static ArrayList<StatsModel> Stats(String stat,StatsImpl StatObj, ArrayList<JSONModel> List, ArrayList<HashModel> HList, ArrayList<WordModel> WList) throws EmptyArgumentsException{
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
