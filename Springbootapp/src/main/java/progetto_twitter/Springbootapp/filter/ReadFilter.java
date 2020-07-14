package progetto_twitter.Springbootapp.filter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;

import progetto_twitter.Springbootapp.exceptions.WrongDateFormatException;
import progetto_twitter.Springbootapp.exceptions.WrongFieldException;
import progetto_twitter.Springbootapp.exceptions.WrongFormatExceptions;
import progetto_twitter.Springbootapp.exceptions.WrongOperatorException;
import progetto_twitter.Springbootapp.exceptions.WrongValueException;
import progetto_twitter.Springbootapp.model.*;
import progetto_twitter.Springbootapp.util.ListsCreate;
import progetto_twitter.Springbootapp.util.ModifyDate;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class ReadFilter extends FilterModel {
	private String fields = "date,text,w,h,dimension";
	private String operators = "$not,$in,$nin,$gt,$gte,$lt,$lte,$bt";
	private HashMap<String, ?> Object = new HashMap<>();
	private int contatore;
	private ArrayList<Object> Array = new ArrayList<Object>();
	private String[] logicalOperators;
	private int size;
	private ArrayList<String> btArray;

	public ReadFilter() {
		super();
	}

	@SuppressWarnings("unchecked")
	public void FirstFilter(JSONObject obj) throws WrongOperatorException, WrongFormatExceptions, WrongFieldException,
			WrongValueException, WrongDateFormatException {
		logicalOperators = new String[2];
		logicalOperators[0] = "$and";
		logicalOperators[1] = "$or";

		if (obj.containsKey(logicalOperators[0])) {
			try {
				Array = (ArrayList<Object>) obj.get(logicalOperators[0]);
			} catch (Exception e) {
				throw new WrongFormatExceptions(logicalOperators[0]);
			}
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
			try {
				Array = (ArrayList<Object>) obj.get(logicalOperators[1]);
			} catch (Exception e) {
				throw new WrongFormatExceptions(logicalOperators[1]);
			}
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
	public void Filter(Object obj, String LogicalOperator) throws WrongOperatorException, WrongFormatExceptions,
			WrongFieldException, WrongValueException, WrongDateFormatException {
		String[] Afields = fields.split(",");
		String[] Aoperators = operators.split(",");
		int i = 0;
		int k = -1;
		try {
			while (i < Afields.length) {
				if (((HashMap<String, ?>) obj).containsKey(Afields[i])) {
					Object = (HashMap<String, ?>) ((HashMap<String, ?>) obj).get(Afields[i]);
					k = i;
				}
				i++;
			}
		} catch (Exception e) {
			throw new WrongFormatExceptions(Afields[i], 1);
		}
		if (k == -1)
			throw new WrongFieldException("Unrecognized field, expected fields are [date,text,w,h,dimension] ");
		setField(Afields[k]);
		Filter(Aoperators, LogicalOperator);
	}

	@SuppressWarnings("unchecked")
	public void Filter(String[] Aoperators, String LogicalOperator)
			throws WrongOperatorException, WrongValueException, WrongDateFormatException, WrongFormatExceptions {
		int j = 0;
		int k = -1;
		while (j < Aoperators.length) {
			if (Object.containsKey(Aoperators[j])) {// aggiungere eccezione
				getValues().clear();
				try {
					if (Aoperators[j].equals("$bt") || Aoperators[j].equals("$in") || Aoperators[j].equals("$nin")) {
						try {
							btArray = new ArrayList<String>();
							btArray = (ArrayList<String>) ((HashMap<String, ?>) Object).get(Aoperators[j]);
						} catch (Exception e) {
							throw new WrongFormatExceptions(Aoperators[j]);
						}
						Iterator<String> i = btArray.iterator();
						while (i.hasNext())
							AddValue((String) i.next());
					} else
						AddValue((String) ((HashMap<String, ?>) Object).get(Aoperators[j]));
				} catch (Exception e) {
					throw new WrongValueException();
				}
				k = j;
			}
			j++;
		}
		if (k == -1)
			throw new WrongOperatorException("Wrong operator");
		if (Aoperators[k].equals("$bt") && getValues().size() > 2)
			throw new WrongFormatExceptions();
		setOperator(Aoperators[k]);
		if (getField().equals("date")) {
			Iterator i = getValues().iterator();
			while (i.hasNext()) {
				ModifyDate.DateVerify((String) i.next());
			}
		}
		FilterImpl obj = new FilterImpl();
		if (LogicalOperator.equals("$and") || LogicalOperator.equals(""))
			obj.AndFilter(getField(), getValues(), getOperator());
		else
			obj.OrFilter(getField(), getValues(), getOperator(), contatore, size);
	}

}
