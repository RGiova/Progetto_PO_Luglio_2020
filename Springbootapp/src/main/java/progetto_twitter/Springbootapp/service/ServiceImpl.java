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
		return ModelList.getMList();
	}
	public static ReadFilter GETFilter(JSONObject obj) {
		ReadFilter Prova = new ReadFilter();
		Prova.Filter(obj);
		return Prova;
		
	}
}
