package progetto_twitter.Springbootapp.filter;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;

import progetto_twitter.Springbootapp.model.*;
import progetto_twitter.Springbootapp.util.ImgFiltering;

public class FilterOperators {
	private static JSONModel obj;

	public static void notFilter(String fields, Object values) {
		Iterator<JSONModel> i = ModelList.getMList().iterator();
		while (i.hasNext()) {
			obj = new JSONModel();
			obj = (JSONModel) i.next();
			if (fields.equals("w") || fields.equals("h") || fields.equals("dimension"))
				ImgFiltering.FilteringofImages(fields, obj, values,"not");

			else if (SearchMethod(fields, obj).equals(values))
				obj.setTo_insert(false);
				
			
		}
	}

	public static void inFilter(String fields, Object values) {
		Iterator<JSONModel> i = ModelList.getMList().iterator();
		while (i.hasNext()) {
			Iterator J = ((ArrayList<Object>)values).iterator();
			obj = new JSONModel();
			obj = (JSONModel) i.next();
			while (J.hasNext()) {
				Object Next = J.next();
				if (fields.equals("w") || fields.equals("h") || fields.equals("dimension"))
				ImgFiltering.FilteringofImages(fields, obj, Next,"in");
				else if (!SearchMethod(fields, obj).equals(Next))
					obj.setTo_insert(false);
			}
		}
	}

	public static void ninFilter(String fields, Object values) {
		Iterator<JSONModel> i = ModelList.getMList().iterator();
		while (i.hasNext()) {
			Iterator J = ((ArrayList<Object>) values).iterator();
			obj = new JSONModel();
			obj = (JSONModel) i.next();
			while (J.hasNext()) {
				Object Next = J.next();
				if (fields.equals("w") || fields.equals("h") || fields.equals("dimension"))
					ImgFiltering.FilteringofImages(fields, obj, Next,"nin");
					else if (SearchMethod(fields, obj).equals(Next))
						obj.setTo_insert(false);
			}
		}

	}

	public static void gtFilter(String fields, Object values) {
		Iterator<JSONModel> i = ModelList.getMList().iterator();
		while (i.hasNext()) {
			obj = new JSONModel();
			obj = (JSONModel) i.next();
			if (SearchMethod(fields, obj).equals(values))
				obj.setTo_insert(false);
		}
	}

	public static void gteFilter(String fields, Object values) {
		Iterator<JSONModel> i = ModelList.getMList().iterator();
		while (i.hasNext()) {
			obj = new JSONModel();
			obj = (JSONModel) i.next();
			if (SearchMethod(fields, obj).equals(values))
				obj.setTo_insert(false);
		}
	}

	public static void ltFilter(String fields, Object values) {
		Iterator<JSONModel> i = ModelList.getMList().iterator();
		while (i.hasNext()) {
			obj = new JSONModel();
			obj = (JSONModel) i.next();
			if (SearchMethod(fields, obj).equals(values))
				obj.setTo_insert(false);
		}
	}

	public static void lteFilter(String fields, Object values) {
		Iterator<JSONModel> i = ModelList.getMList().iterator();
		while (i.hasNext()) {
			obj = new JSONModel();
			obj = (JSONModel) i.next();
			if (SearchMethod(fields, obj).equals(values))
				obj.setTo_insert(false);
		}
	}

	public static void btFilter(String fields, Object values) {
		Iterator<JSONModel> i = ModelList.getMList().iterator();
		while (i.hasNext()) {
			obj = new JSONModel();
			obj = (JSONModel) i.next();
			if (SearchMethod(fields, obj).equals(values))
				obj.setTo_insert(false);
		}
	}

	public static Object SearchMethod(String Name, Object Class) {
		Method m = null;
		Object object = null;
		try {
			System.out.println("get" + Name.substring(0, 1).toUpperCase() + Name.substring(1));
			m = Class.getClass().getMethod("get" + Name.substring(0, 1).toUpperCase() + Name.substring(1));
			object = m.invoke(Class);
		} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException
				| InvocationTargetException e) {
			e.printStackTrace();
		}
		return object;

	}
}
