package progetto_twitter.Springbootapp.model;
import java.util.*;
public class ModelList {
	static List<JSONModel> MList = new ArrayList<JSONModel>();
public static void ListAdd(JSONModel Mdl) {
	MList.add(Mdl);
	JSONModel Appoggio = new JSONModel();
	for(int i=0;i<MList.size();i++){
		Appoggio = MList.get(i);
		System.out.println(Appoggio.getURL());
	} 
}
}
