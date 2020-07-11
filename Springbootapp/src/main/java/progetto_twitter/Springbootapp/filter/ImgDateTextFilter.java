package progetto_twitter.Springbootapp.filter;

import java.util.ArrayList;

import progetto_twitter.Springbootapp.model.JSONModel;

public interface ImgDateTextFilter {
	boolean FilteringofText(String value, JSONModel obj, String operator,ArrayList<String> values);
	boolean FilteringofImages(String fields, JSONModel obj, String value, String operator,ArrayList<String> values);
	boolean FilteringofDate(JSONModel obj, String value, String operator, ArrayList<String> values);
}
