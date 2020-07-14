package progetto_twitter.Springbootapp.util;

import java.util.ArrayList;
import java.util.Iterator;

import progetto_twitter.Springbootapp.model.JSONModel;

public class ListManagementImpl implements ListManagement {
	private static ArrayList<JSONModel> MList = new ArrayList<JSONModel>(300);
	private static ArrayList<JSONModel> TopushList = new ArrayList<JSONModel>(300);
	private static ArrayList<JSONModel> ToFilterList;
	private static ArrayList<JSONModel> ToFilterList2;

	@Override
	public  ArrayList<JSONModel> getMList() {
		return MList;
	}

	@Override
	public void setMList(ArrayList<JSONModel> mList) {
		MList = mList;
	}

	@Override
	public void MListAdd(JSONModel Mdl) {
		MList.add(Mdl);
	}

	@Override
	public ArrayList<JSONModel> getToPushList() {
		return TopushList;
	}

	@Override
	public void setToPushList(ArrayList<JSONModel> topushList) {
		TopushList = topushList;
	}

	@Override
	public void ToPushListAdd(JSONModel Mdl) {
		TopushList.add(Mdl);
	}

	@Override
	public void ToPushListDelete(JSONModel Mdl) {
		TopushList.remove(Mdl);
	}
	@Override
	public ArrayList<JSONModel> getToFilterList() {
		return ToFilterList;
	}

	@Override
	public void setToFilterList(ArrayList<JSONModel> toFilterList) {
		ToFilterList = toFilterList;
	}

	@Override
	public void ToFilterListAdd(JSONModel Mdl) {
		ToFilterList.add(Mdl);

	}

	@Override
	public void ToFilterListDelete(JSONModel Mdl) {
		ToFilterList.remove(Mdl);

	}
	@Override
	public void ToFilterListCreate() {
		ToFilterList= new ArrayList<JSONModel>();
	}

	public ArrayList<JSONModel> getToFilterList2() {
		return ToFilterList2;
	}

	public void setToFilterList2(ArrayList<JSONModel> toFilterList2) {
		ToFilterList2 = toFilterList2;
	}

	@Override
	public void ToFilterList2Add(JSONModel Mdl) {
		ToFilterList2.add(Mdl);

	}

	@Override
	public void ToFilterList2Delete(JSONModel Mdl) {
		ToFilterList2.remove(Mdl);

	}
	@Override
	public void ToFilterList2Create() {
		ToFilterList2= new ArrayList<JSONModel>();
	}
	
	public void ListCopy(ArrayList<JSONModel> ListToCopy, ArrayList<JSONModel> CopiedList) {
		Iterator<JSONModel> i = ListToCopy.iterator();
		while(i.hasNext()) {
			JSONModel obj = new JSONModel();
			obj = i.next();
			CopiedList.add(obj);
		}
	}



}
