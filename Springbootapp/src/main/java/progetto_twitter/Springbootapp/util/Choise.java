package progetto_twitter.Springbootapp.util;

import progetto_twitter.Springbootapp.exceptions.WrongStatisticException;

public class Choise  {


	public static void Stats (String stat, String N ) throws WrongStatisticException {
		int n;
		try {
			n = Integer.parseInt(N);
		} catch (NumberFormatException e) {
			throw new WrongStatisticException("Error : number of words must be a number");
		}
		switch (stat) {
		case "day":
			
			break;
		case "month":
			
			break;
		case "year":
			
			break;
		case "url":
			
			break;
		case "hashtags":
			
			break;
		case "text":
			
			break;
		case "image":
			
			break;
		}
	}
}
