package progetto_twitter.Springbootapp.filter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import progetto_twitter.Springbootapp.model.*;

import org.json.simple.JSONObject;

public class ReadFilter extends FilterModel {
	private String fields = "date,text,hashtags,Url,Img,$or,$and";// includere and e or
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
		if (getField().equals("$or") || getField().equals("$and"))
			Filter(Object);
		else
			Filter(Object, Aoperators);
	}

	@SuppressWarnings("unchecked")
	public void Filter(Object Obj, String[] Aoperators) {
		int j = 0;
		int k = 0;
		while (j < Aoperators.length) {
			if (((HashMap<String, String>) Object).containsKey(Aoperators[j])) {
				setValues(((HashMap<String, String>) Object).get(Aoperators[j]));
				k = j;
			}
			j++;
		}
		setOperator(Aoperators[k]);
		FilterStudy.Filtered(getField(),getOperator(),getValues());
	}

	public void Filter(Object Obj) {
		setOperator(getField());
		setField(null);	
		setValues(Obj);
	}


}
