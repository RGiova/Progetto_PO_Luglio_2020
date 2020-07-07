package progetto_twitter.Springbootapp.util;

import java.util.ArrayList;

import progetto_twitter.Springbootapp.model.JSONModel;
import progetto_twitter.Springbootapp.model.ModelList;

public class Data extends ModelList{
public static ArrayList<JSONModel> GETData (){
	return getMList();	
}
}
