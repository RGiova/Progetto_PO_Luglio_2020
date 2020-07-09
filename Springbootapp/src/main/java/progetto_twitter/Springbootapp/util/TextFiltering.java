package progetto_twitter.Springbootapp.util;

import java.util.ArrayList;

import progetto_twitter.Springbootapp.model.JSONModel;

public class TextFiltering {
	public static void FilteringofText(String value, JSONModel obj, String operator,ArrayList<String> values) {
		int length;
		try {
			length = Integer.parseInt(value);
		} catch (NumberFormatException e) {
			length = 0;
		}
		if ((operator.equals("not") || operator.equals("nin")) && (obj.getText().length()) == (length)) 
			ListToPush.ListDelete(obj);
		else if ((operator.equals("$in") && (obj.getText().length()) != (length)))
			ListToPush.ListDelete(obj);
		else if ((operator.equals("$gt") && (obj.getText().length()) <= (length)))
			ListToPush.ListDelete(obj);
		else if ((operator.equals("$gte") && (obj.getText().length()) < (length)))
			ListToPush.ListDelete(obj);
		else if ((operator.equals("$lt") && (obj.getText().length()) >= (length)))
			ListToPush.ListDelete(obj);
		else if ((operator.equals("$lte") && (obj.getText().length()) > (length)))
			ListToPush.ListDelete(obj);
		else if (operator.equals("$bt") && ((obj.getText().length())<Integer.parseInt(values.get(0)) || (obj.getText().length())>Integer.parseInt(values.get(1))))
			ListToPush.ListDelete(obj);

	}

}
