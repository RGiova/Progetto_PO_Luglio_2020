package progetto_twitter.Springbootapp.filter;

import java.util.ArrayList;

import progetto_twitter.Springbootapp.exceptions.WrongDateFormatException;
import progetto_twitter.Springbootapp.exceptions.WrongValueException;
import progetto_twitter.Springbootapp.model.JSONModel;

public interface ImgDateTextFilter {
	boolean FilteringofText(String value, JSONModel obj, String operator,ArrayList<String> values) throws WrongValueException;
	boolean FilteringofImages(String fields, JSONModel obj, String value, String operator,ArrayList<String> values) throws WrongValueException;
	boolean FilteringofDate(JSONModel obj, String value, String operator, ArrayList<String> values) throws WrongDateFormatException;
}
