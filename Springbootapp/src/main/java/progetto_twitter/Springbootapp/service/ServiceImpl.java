package progetto_twitter.Springbootapp.service;

import java.util.ArrayList;

import progetto_twitter.Springbootapp.model.JSONModel;
import progetto_twitter.Springbootapp.model.MetaDataModel;
import progetto_twitter.Springbootapp.model.ModelList;
import progetto_twitter.Springbootapp.util.Metadata;

public class ServiceImpl {

	public static ArrayList<MetaDataModel> GETMetaData() {
		Metadata.CMetaData();
		return Metadata.getMDArray();
	}
	
	public static ArrayList<JSONModel> GETData(){
		return ModelList.getMList();
	}
}
