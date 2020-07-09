package progetto_twitter.Springbootapp.filter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import progetto_twitter.Springbootapp.model.*;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class ReadFilter extends FilterModel implements ReadFilterInterface {
	private String fields = "date,text,w,h,dimension";
	private String operators = "$not,$in,$nin,$gt,$gte,$lt,$lte,$bt";
	private Object Object = new Object();

	public ReadFilter() {
		super();
	}

	public void Filter(JSONObject obj) {
		String[] Afields = fields.split(",");
		String[] Aoperators = operators.split(",");
		int i = 0;
		int k = 0;
		while (i < Afields.length) {
			if (obj.containsKey(Afields[i])) {
				Object = obj.get(Afields[i]);
				k = i;
			}
			i++;
		}
		setField(Afields[k]);
	    Filter(Object, Aoperators);
	}

	@SuppressWarnings("unchecked")
	public void Filter(Object Obj, String[] Aoperators) {
		int j = 0;
		int k = 0;
		while (j < Aoperators.length) {
			if (((HashMap<String, String>) Object).containsKey(Aoperators[j])) {
				System.out.println(((HashMap<String, String>) Object).get(Aoperators[j]));
				AddValue(((HashMap<String, String>) Object).get(Aoperators[j]));
				k = j;
			}
			j++;
		}
		setOperator(Aoperators[k]);
		FilterImpl obj = new FilterImpl();
		obj.Filter(getField(),  getValues(), getOperator());
	}

}
