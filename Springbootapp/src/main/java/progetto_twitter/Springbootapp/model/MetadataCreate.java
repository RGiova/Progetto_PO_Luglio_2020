package progetto_twitter.Springbootapp.model;

import java.util.Iterator;
import java.util.Vector;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;;
public class MetadataCreate{

private Vector<MetaDataModel> MArray = new Vector<MetaDataModel>();

public void AddMetaData(MetaDataModel Mdl) {
	MArray.add(Mdl);
}
public ObjectMapper ParseMetadata (Vector<MetaDataModel> Array) {
	  Iterator i = Array.iterator();
      ObjectMapper obj = new ObjectMapper();
      while(i.hasNext()) {
      try {
		obj.writeValueAsString(i.next());
	} catch (JsonProcessingException e) {
		e.printStackTrace();
	}
      }
	
	return obj;
}
}
