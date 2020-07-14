package progetto_twitter.Springbootapp.util;

import java.util.ArrayList;
import progetto_twitter.Springbootapp.model.MetaDataModel;
/**
 * Classe che crea i metadata
 * @author Lorenzo Sopranzetti, Giovanni Recchi, Francesco Pigliapoco
 *
 */
public class Metadata {
	/**
	 * Oggetto ArrayList che contiene i metadata
	 */
	private static ArrayList<MetaDataModel> MDArray = new ArrayList<MetaDataModel>();
	public static ArrayList<MetaDataModel> getMDArray() {
		return MDArray;
	}

	public void setMDArray(ArrayList<MetaDataModel> mDArray) {
		MDArray = mDArray;
	}
	/**
	 * Metodo che riempie l'ArrayList di metadata inserendo le informazioni all'interno di modelli prestabiliti
	 */

	public static void CMetaData() {
		for (int i = 0; i < 8; i++) {
			MetaDataModel Mdl = new MetaDataModel();
			switch (i) {
			case 0:
				Mdl.setAlias("name");
				Mdl.setSourceField("nome del profilo twitter");
				Mdl.setType("String");
				AddMetaData(Mdl);
				break;
			case 1:
				Mdl.setAlias("user_id");
				Mdl.setSourceField("numero identificativo del profilo twitter");
				Mdl.setType("Integer");
				AddMetaData(Mdl);
				break;
			case 2:
				Mdl.setAlias("post_id");
				Mdl.setSourceField("numero identificativo del post");
				Mdl.setType("Integer");
				AddMetaData(Mdl);
				break;
			case 3:
				Mdl.setAlias("text");
				Mdl.setSourceField("testo del post");
				Mdl.setType("String");
				AddMetaData(Mdl);
				break;
			case 4:
				Mdl.setAlias("hashtags");
				Mdl.setSourceField("hashtags in un post");
				Mdl.setType("String");
				AddMetaData(Mdl);
				break;
			case 5:
				Mdl.setAlias("url");
				Mdl.setSourceField("urls contenuti nel testo di un post");
				Mdl.setType("String");
				AddMetaData(Mdl);
				break;
			case 6:
				Mdl.setAlias("date");
				Mdl.setSourceField("data di pubblicazione del post");
				Mdl.setType("String");
				AddMetaData(Mdl);
				break;
			case 7:
				Mdl.setAlias("img");
				Mdl.setSourceField("dimensioni delle immagini contenute in un post");
				Mdl.setType("imagemodel");
				AddMetaData(Mdl);
				break;
			}
		}
	}

	public static void AddMetaData(MetaDataModel Mdl) {
		MDArray.add(Mdl);
	}

}
