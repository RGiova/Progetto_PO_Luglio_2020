package progetto_twitter.Springbootapp.filter;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;

import progetto_twitter.Springbootapp.model.*;

public class FilterOperators {
	private static JSONModel obj;

	public static void notFilter(String fields, Object values) {
		Iterator i = ModelList.getMList().iterator();
		while (i.hasNext()) {
			obj=(JSONModel) i.next();
			if(SearchMethod(fields, obj).equals(values))
			obj.setTo_insert(false);
			int k = 0;
		}
	}

	public static void inFilter(String fields, Object values) {
		Iterator i = ModelList.getMList().iterator();
		Iterator J = ((ArrayList<JSONModel>) values).iterator();
		while (i.hasNext()) {
			obj=(JSONModel) i.next();
			while(J.hasNext()) {
			if(!SearchMethod(fields, obj).equals(values));
			obj.setTo_insert(false);
			}
		}
	}

	public static void ninFilter(String fields, Object values) {
		Iterator i = ModelList.getMList().iterator();
		Iterator J = ((ArrayList<JSONModel>) values).iterator();
		while (i.hasNext()) {
			obj=(JSONModel) i.next();
			while(J.hasNext()) {
			if(SearchMethod(fields, obj).equals(values));
			obj.setTo_insert(false);
			}
		}

	}

	public static void gtFilter(String fields, Object values) {
		Iterator i = ModelList.getMList().iterator();
		while (i.hasNext()) {
			obj=(JSONModel) i.next();
			if(SearchMethod(fields, obj).equals(values));
			obj.setTo_insert(false);
		}
	}

	public static void gteFilter(String fields, Object values) {
		Iterator i = ModelList.getMList().iterator();
		while (i.hasNext()) {
			obj=(JSONModel) i.next();
			if(SearchMethod(fields, obj).equals(values));
			obj.setTo_insert(false);
		}
	}

	public static void ltFilter(String fields, Object values) {
		Iterator i = ModelList.getMList().iterator();
		while (i.hasNext()) {
			obj=(JSONModel) i.next();
			if(SearchMethod(fields, obj).equals(values));
			obj.setTo_insert(false);
		}
	}

	public static void lteFilter(String fields, Object values) {
		Iterator i = ModelList.getMList().iterator();
		while (i.hasNext()) {
			obj=(JSONModel) i.next();
			if(SearchMethod(fields, obj).equals(values));
			obj.setTo_insert(false);
		}
	}

	public static void btFilter(String fields, Object values) {
		Iterator i = ModelList.getMList().iterator();
		while (i.hasNext()) {
			obj=(JSONModel) i.next();
			if(SearchMethod(fields, obj).equals(values));
			obj.setTo_insert(false);
		}
	}

	public static Object SearchMethod(String Name, Object Class) {
		Method m = null;
		Object obj = null ;
		try {
			System.out.println("get" + Name.substring(0, 1).toUpperCase()+Name.substring(1));
			m = Class.getClass().getMethod("get" + Name.substring(0, 1).toUpperCase()+Name.substring(1));
			obj = m.invoke(Class);
			int k= 0;
		} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		}

		return obj;
	}
}
