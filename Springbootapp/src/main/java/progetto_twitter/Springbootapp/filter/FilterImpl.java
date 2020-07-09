package progetto_twitter.Springbootapp.filter;

import java.util.ArrayList;
import java.util.Iterator;

import progetto_twitter.Springbootapp.model.JSONModel;
import progetto_twitter.Springbootapp.util.DateFiltering;
import progetto_twitter.Springbootapp.util.ImgFiltering;
import progetto_twitter.Springbootapp.util.ModelList;
import progetto_twitter.Springbootapp.util.TextFiltering;

public class FilterImpl implements FilterInterface {
	private JSONModel obj;
	
	
	public void Filter(String fields, ArrayList<String> values, String operator) {
		Iterator<JSONModel> i = ModelList.getMList().iterator();
		while (i.hasNext()) {
			Iterator<String> J = values.iterator();
			obj = new JSONModel();
			obj = (JSONModel) i.next();
			while (J.hasNext()) {
				String Next = J.next();
				if (fields.equals("w") || fields.equals("h") || fields.equals("dimension"))
				ImgFiltering.FilteringofImages(fields, obj, Next, operator, values);
				else if (fields.equals("text"))
					TextFiltering.FilteringofText(Next,obj,operator, values);
				else if (fields.equals("date"))
					DateFiltering.FilteringofDate(obj,Next,operator, values);
			}
		}
	}

}
