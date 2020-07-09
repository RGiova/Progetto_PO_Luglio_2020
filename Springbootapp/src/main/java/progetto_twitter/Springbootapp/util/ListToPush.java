package progetto_twitter.Springbootapp.util;

import java.util.ArrayList;

import progetto_twitter.Springbootapp.model.JSONModel;
import java.util.*;
public class ListToPush {
	private static ArrayList<JSONModel> TopushList = new ArrayList<JSONModel>();


	public static ArrayList<JSONModel> getTopushList() {
		return TopushList;
	}

	public static void setTopushList(ArrayList<JSONModel> topushList) {
		TopushList = topushList;
	}

	public static void ListAdd(JSONModel Mdl) {
		TopushList.add(Mdl);
	}
	public static void ListDelete(JSONModel Mdl) {
		TopushList.remove(Mdl);
	}
}
