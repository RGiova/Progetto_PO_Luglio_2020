package progetto_twitter.Springbootapp.filter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Vector;

import progetto_twitter.Springbootapp.model.ImageModel;
import progetto_twitter.Springbootapp.model.JSONModel;
import progetto_twitter.Springbootapp.util.GetMethods;
import java.util.Date;

public class ImgDateTextFilterImpl implements ImgDateTextFilter {

	public boolean FilteringofText(String value, JSONModel obj, String operator, ArrayList<String> values) {
		int length;
		try {
			length = Integer.parseInt(value);
		} catch (NumberFormatException e) {
			length = 0;
		}
		if (operator.equals("not") && (obj.getText().length()) == (length))
			return true;
		else if ((operator.equals("$in") || operator.equals("nin"))) {
			if (operator.equals("$in") && !values.contains(String.valueOf(obj.getText().length())))
				return true;
			if (operator.equals("$nin") && values.contains(String.valueOf(obj.getText().length())))
				return true;
			else
				return false;
		} else if ((operator.equals("$gt") && (obj.getText().length()) <= (length)))
			return true;
		else if ((operator.equals("$gte") && (obj.getText().length()) < (length)))
			return true;
		else if ((operator.equals("$lt") && (obj.getText().length()) >= (length)))
			return true;
		else if ((operator.equals("$lte") && (obj.getText().length()) > (length)))
			return true;
		else if (operator.equals("$bt") && ((obj.getText().length()) < Integer.parseInt(values.get(0))
				|| (obj.getText().length()) > Integer.parseInt(values.get(1))))
			return true;
		else
			return false;

	}

	public boolean FilteringofImages(String fields, JSONModel obj, String value, String operator,
			ArrayList<String> values) {
		if (obj.getImg() == null) {
			obj.setTo_insert(false);
			return true;
		}
		Long length;
		try {
			length = Long.parseLong(value);
		} catch (NumberFormatException e) {
			length = (long) 0;
		}
		Vector<ImageModel> ClassImg = obj.getImg();
		Iterator<ImageModel> k = ClassImg.iterator();
		while (k.hasNext()) {
			Object imgObject = (Object) k.next();
			Long field = GetMethods.SearchMethod(fields, imgObject);
			if (operator.equals("not") && field.equals(value))
				return true;
			else if (operator.equals("$in") || operator.equals("nin")) {
				if (operator.equals("$in") && !values.contains(String.valueOf(field)))
					return true;
				if (operator.equals("$nin") && values.contains(String.valueOf(field)))
					return true;
				else
					return false;
			} else if (operator.equals("$gt") && field <= length)
				return true;
			else if (operator.equals("$gte") && field < length)
				return true;
			else if (operator.equals("$lt") && field >= length)
				return true;
			else if (operator.equals("$lte") && field > length)
				return true;
			else if (operator.equals("$bt")
					&& (field < Integer.parseInt(values.get(0)) || field > Integer.parseInt(values.get(1))))
				return true;
		}
		return false;

	}

	public boolean FilteringofDate(JSONModel obj, String value, String operator, ArrayList<String> values) {
		if ((operator.equals("not") && obj.getDate().equals(value)))
			return true;
		else if (operator.equals("$in") || operator.equals("nin")) {
			if (operator.equals("$in") && !values.contains(obj.getDate()))
				return true;
			if (operator.equals("$nin") && values.contains(obj.getDate()))
				return true;
			else
				return false;
		}

		else if ((operator.equals("$gt") && (Compare(obj, "<=", value))))
			return true;
		else if ((operator.equals("$gte") && (Compare(obj, "<", value))))
			return true;
		else if ((operator.equals("$lt") && (Compare(obj, ">=", value))))
			return true;
		else if ((operator.equals("$lte") && (Compare(obj, ">", value))))
			return true;
		else if (operator.equals("$bt") && (Compare(obj, "<", values.get(0)) || Compare(obj, ">", values.get(1))))
			return true;
		else
			return false;

	}

	interface Operator {
		boolean compare(int a, int b);
	}

	public static boolean Compare(JSONModel obj, String Op, String value) {
		boolean bool = false;
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
		SimpleDateFormat sdformat = new SimpleDateFormat("yyyy-MM-dd");
		Date ValueDate;
		Date ObjDate;
		try {
			ValueDate = sdformat.parse(SplitValue[2] + "-" + SplitValue[1] + "-" + SplitValue[0]);
			ObjDate = sdformat.parse(SplitDate[2] + "-" + SplitDate[1] + "-" + SplitDate[0]);
		} catch (ParseException e) {
			ValueDate = null;
			ObjDate = null; // ECCEZZIONIIII
			e.printStackTrace();
		}

		bool = opMap.get(Op).compare(ObjDate.compareTo(ValueDate), 0);
		return bool;

	}
}
