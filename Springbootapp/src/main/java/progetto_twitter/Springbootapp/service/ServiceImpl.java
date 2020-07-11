package progetto_twitter.Springbootapp.service;

import java.util.ArrayList;

import org.json.simple.JSONObject;

import progetto_twitter.Springbootapp.filter.ReadFilter;
import progetto_twitter.Springbootapp.model.JSONModel;
import progetto_twitter.Springbootapp.model.MetaDataModel;
import progetto_twitter.Springbootapp.util.*;
import progetto_twitter.Springbootapp.util.Metadata;

public class ServiceImpl {

	public static ArrayList<MetaDataModel> GETMetaData() {
		Metadata.CMetaData();
		return Metadata.getMDArray();
	}
	
	public static ArrayList<JSONModel> GETData(){
		return ListsCreate.Lists.getMList();
	}
	public static void GETFilter(JSONObject obj) {
		ReadFilter Prova = new ReadFilter();
		Prova.FirstFilter(obj);
	}
	public static ArrayList<JSONModel> GETDataFiltered(){
		if (ListsCreate.Lists.getToFilterList()!=null)
		ListsCreate.Lists.getToFilterList().clear();
		if (ListsCreate.Lists.getToFilterList2()!=null)
		ListsCreate.Lists.getToFilterList2().clear();
		return ListsCreate.Lists.getToPushList();
	}
}
