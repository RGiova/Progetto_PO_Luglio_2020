package progetto_twitter.Springbootapp.util;

import java.util.ArrayList;
import java.util.Vector;

import org.json.simple.JSONArray;

import progetto_twitter.Springbootapp.model.JSONModel;
import progetto_twitter.Springbootapp.model.MetaDataModel;

public class Metadata {
	private ArrayList<MetaDataModel> MDArray = new ArrayList<MetaDataModel>();
	private MetaDataModel Mdl = new MetaDataModel();

	public  ArrayList<MetaDataModel> MetaData() {
		for (int i = 0; i < 8; i++) {
			switch (i) {
			case 0:
				Mdl.setAlias("name");
				Mdl.setSourceField("nome del profilo twitter");
				Mdl.setType("String");
				MDArray.add(Mdl);
				break;
			case 1:
				Mdl.setAlias("user_id");
				Mdl.setSourceField("numero identificativo del profilo twitter");
				Mdl.setType("Integer");
				MDArray.add(Mdl);
				break;
			case 2:
				Mdl.setAlias("post_id");
				Mdl.setSourceField("numero identificativo del post");
				Mdl.setType("Integer");
				MDArray.add(Mdl);
				break;
			case 3:
				Mdl.setAlias("text");
				Mdl.setSourceField("testo del post");
				Mdl.setType("String");
				MDArray.add(Mdl);
				break;
			case 4:
				Mdl.setAlias("hashtags");
				Mdl.setSourceField("hashtags in un post");
				Mdl.setType("String");
				MDArray.add(Mdl);
				break;
			case 5:
				Mdl.setAlias("url");
				Mdl.setSourceField("urls contenuti nel testo di un post");
				Mdl.setType("String");
				MDArray.add(Mdl);
				break;
			case 6:
				Mdl.setAlias("date");
				Mdl.setSourceField("data di pubblicazione del post");
				Mdl.setType("String");
				MDArray.add(Mdl);
				break;
			case 7:
				Mdl.setAlias("img");
				Mdl.setSourceField("dimensioni delle immagini contenute in un post");
				Mdl.setType("imagemodel");
				MDArray.add(Mdl);
				break;
			}
		}
		return MDArray;

	}

}
