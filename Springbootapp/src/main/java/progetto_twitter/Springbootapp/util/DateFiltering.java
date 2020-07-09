package progetto_twitter.Springbootapp.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import progetto_twitter.Springbootapp.model.JSONModel;

public class DateFiltering {
	public static void FilteringofDate(JSONModel obj, String value, String operator, ArrayList<String> values) {
		if ((operator.equals("not") || operator.equals("nin")) && obj.getDate().equals(value)) 
			ListToPush.ListDelete(obj);
		else if ((operator.equals("$in") && !obj.getDate().equals(value)))
			ListToPush.ListDelete(obj);
		else if ((operator.equals("$gt") && (Compare(obj, "<=", value))))
			ListToPush.ListDelete(obj);
		else if ((operator.equals("$gte") && (Compare(obj, "<", value))))
			ListToPush.ListDelete(obj);
		else if ((operator.equals("$lt") && (Compare(obj, ">=", value))))
			ListToPush.ListDelete(obj);
		else if ((operator.equals("$lte") && (Compare(obj, ">", value))))
			ListToPush.ListDelete(obj);
		else if (operator.equals("$bt") && (Compare(obj,"<",values.get(0)) || Compare(obj,">",values.get(1))))
			ListToPush.ListDelete(obj);

	}

	interface Operator {
		boolean compare(int a, int b);
	}

	public static boolean Compare(JSONModel obj, String Op, String value) {
		boolean bool = true;
		Map<String, Operator> opMap = new HashMap<String, Operator>();
		opMap.put(">", new Operator() {
			@Override
			public boolean compare(int a, int b) {
				return a > b;
			}
		});
		opMap.put("<", new Operator() {
			@Override
			public boolean compare(int a, int b) {
				return a < b;
			}
		});
		opMap.put("==", new Operator() {
			@Override
			public boolean compare(int a, int b) {
				return a == b;
			}
		});
		opMap.put("<=", new Operator() {
			@Override
			public boolean compare(int a, int b) {
				return a <= b;
			}
		});
		opMap.put(">=", new Operator() {
			@Override
			public boolean compare(int a, int b) {
				return a >= b;
			}
		});
		String[] SplitDate = obj.getDate().split("/");
		String[] SplitValue = value.split("/");
		for (int i = 2; i >= 0; i--) {
			int Value;
			int Date;
			try {
				Value = Integer.parseInt(SplitValue[i]);
				Date = Integer.parseInt(SplitDate[i]);
			} catch (NumberFormatException e) {
				Value = 0;
				Date = -1;
			}
			bool = opMap.get(Op).compare(Date, Value) && bool;
		}
		return bool;

	}
}
