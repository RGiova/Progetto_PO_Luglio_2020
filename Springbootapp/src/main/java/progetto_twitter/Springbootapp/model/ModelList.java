package progetto_twitter.Springbootapp.model;
import java.util.*;
public class ModelList {
	private static ArrayList<JSONModel> MList = new ArrayList<JSONModel>();
	
public static ArrayList<JSONModel> getMList() {
		return MList;
	}

	public static void setMList(ArrayList<JSONModel> mList) {
		MList = mList;
	}

public static void ListAdd(JSONModel Mdl) {
	MList.add(Mdl);
	} 
}

