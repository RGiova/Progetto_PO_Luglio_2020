package progetto_twitter.Springbootapp.util;
import java.util.ArrayList;

import progetto_twitter.Springbootapp.model.JSONModel;

public class Data{
public static ArrayList<JSONModel> GETData (){
	return ListsCreate.Lists.getMList();	
}
}
