package progetto_twitter.Springbootapp.filter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;

import progetto_twitter.Springbootapp.model.*;
import progetto_twitter.Springbootapp.util.ListsCreate;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class ReadFilter extends FilterModel {
	private String fields = "date,text,w,h,dimension";
	private String operators = "$not,$in,$nin,$gt,$gte,$lt,$lte,$bt";
	private Object Object = new Object();
	private int contatore;
	private ArrayList<Object> Array = new ArrayList<Object>();
	private String[] logicalOperators;
	private int size;
	private ArrayList<String> btArray;

	public ReadFilter() {
		super();
	}

	@SuppressWarnings("unchecked")
	public void FirstFilter(JSONObject obj) {
		logicalOperators = new String[2];
		logicalOperators[0] = "$and";
		logicalOperators[1] = "$or";

		if (obj.containsKey(logicalOperators[0])) {
			// Aggiungere eccezione
			Array = (ArrayList<Object>) obj.get(logicalOperators[0]);
			Iterator<?> i = Array.iterator();
			size = Array.size();
			while (i.hasNext()) {
				Object Object = new Object();
				Object = i.next();
				Filter(Object, logicalOperators[0]);
			}

		}

		else if (obj.containsKey(logicalOperators[1])) {
			contatore = 0;
			// Aggiungere eccezione
			Array = (ArrayList<Object>) obj.get(logicalOperators[1]);
			Iterator<?> i = Array.iterator();
			size = Array.size();
			while (i.hasNext()) {
				contatore++;
				Object Object = new Object();
				Object = i.next();
				Filter(Object, logicalOperators[1]);
			}
		} else
			Filter(obj, "");
	}

	@SuppressWarnings("unchecked")
	public void Filter(Object obj, String LogicalOperator) {
		String[] Afields = fields.split(",");
		String[] Aoperators = operators.split(",");
		int i = 0;
		int k = 0;
		while (i < Afields.length) {
			if (((HashMap<String, ?>) obj).containsKey(Afields[i])) {
				Object = ((HashMap<String, ?>) obj).get(Afields[i]);
				k = i;
			}
			i++;
		}
		setField(Afields[k]);
		Filter(Object, Aoperators, LogicalOperator);
	}

	@SuppressWarnings("unchecked")
	public void Filter(Object Obj, String[] Aoperators, String LogicalOperator) {
		int j = 0;
		int k = 0;
		while (j < Aoperators.length) {
			if (((HashMap<String, ?>) Object).containsKey(Aoperators[j])) {// aggiungere eccezione
				getValues().clear();
				if (Aoperators[j].equals("$bt")||Aoperators[j].equals("$in")||Aoperators[j].equals("$nin")) {
					btArray = new ArrayList<String>();
					btArray = (ArrayList<String>) ((HashMap<String,?>) Object).get(Aoperators[j]);
					Iterator<String> i = btArray.iterator();
					while(i.hasNext())
					AddValue((String) i.next());
				}
				else
				AddValue((String) ((HashMap<String, ?>) Object).get(Aoperators[j]));
				k = j;
			}
			j++;
		}
		setOperator(Aoperators[k]);
		FilterImpl obj = new FilterImpl();
		if (LogicalOperator.equals("$and") || LogicalOperator.equals(""))
			obj.AndFilter(getField(), getValues(), getOperator());
		else
			obj.OrFilter(getField(), getValues(), getOperator(), contatore, size);
	}

}
