package progetto_twitter.Springbootapp.util;

import java.util.ArrayList;

import progetto_twitter.Springbootapp.model.JSONModel;

public interface ListManagement {
	
	ArrayList<JSONModel> getMList(); 
	void setMList(ArrayList<JSONModel> mList);
	void MListAdd(JSONModel Mdl);
	ArrayList<JSONModel> getToPushList();
	void setToPushList(ArrayList<JSONModel> topushList);
	void ToPushListAdd(JSONModel Mdl);
	void ToPushListDelete(JSONModel Mdl);
	ArrayList<JSONModel> getToFilterList();
	void setToFilterList(ArrayList<JSONModel> ToFilterList);
	void ToFilterListAdd(JSONModel Mdl);
	void ToFilterListDelete(JSONModel Mdl);
	void ToFilterListCreate();
	void ToFilterList2Delete(JSONModel Mdl);
	void ToFilterList2Add(JSONModel Mdl);
	void ToFilterList2Create();
	
	
}
