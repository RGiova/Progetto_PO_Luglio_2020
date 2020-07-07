package progetto_twitter.Springbootapp.filter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Vector;

import progetto_twitter.Springbootapp.model.*;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class ReadFilter {
	private String field;
	private String operator;
	private String fields = "date,text,hashtags,Url,Img";// includere and e or
	private String operators = "$not,$in,$nin,$gt,$gte,$lt,$lte,$bt";
	private HashMap<String, String> Object = new HashMap<String, String>();
	private Object AObject = new Object();

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	@SuppressWarnings("unchecked")
	public void Filter(JSONObject obj) {
		String[] Afields = fields.split(",");
		System.out.println(fields.split(","));
		for (String a : fields.split(","))
			System.out.println(a);
		String[] Aoperators = operators.split(",");
		int i = 0;
		int j = 0;
		int k = 0;
		while (i < Afields.length) {
			if (obj.containsKey(Afields[i])) {
				Object = (HashMap<String, String>) obj.get(Afields[i]);
				k = i;
			}
			i++;
		}
		setField(Afields[k]);
		while (j < Aoperators.length) {
			if (Object.containsKey(Aoperators[j])) {
				AObject = Object.get(Aoperators[j]);
				k=j;
			}
			j++;
		}
		setOperator(Aoperators[k]);

	}
}
