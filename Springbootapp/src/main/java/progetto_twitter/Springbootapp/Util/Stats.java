package progetto_twitter.Springbootapp.Util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

import progetto_twitter.Springbootapp.model.Predicate;
import progetto_twitter.Springbootapp.model.HashModel;
import progetto_twitter.Springbootapp.model.ImageModel;
import progetto_twitter.Springbootapp.model.JSONModel;
import progetto_twitter.Springbootapp.model.WordModel;
public class Stats {

	

public  ArrayList<HashModel> HashStats(JSONModel Mdl){
	ArrayList<HashModel> HashList = new ArrayList<HashModel>();
	ArrayList<String> hash = Mdl.getHashtags();
	boolean evaluate;
	for(int i = 0; i < hash.size(); i++){
		find(HashList, new Predicate<HashModel> {
				    public boolean evaluate(HashModel f) {  ;}
				};
				
		if(!evaluate) {
		HashModel NewHash = new HashModel(hash.get(i);
		HashList.add(NewHash);
		}
		else {}
	}
	return HashList;
}
//Serve numero di oggetti in esami per fare for di inserimento in vettore (da ordinare)
public ArrayList<WordModel> WordStats(JSONModel Mdl) {

	ArrayList WordList = new ArrayList<WordModel>();
	//for
	String text = Mdl.getText();
	Object Word = null;
	while(Word==null){
	int count = 0;
	if (WordList.contains(Word))
	for(int i = 0; i < text.length(); i++) {    
        if(text.charAt(i) != ' ')    
            count++;    
    }    
}
	   Collections.sort(WordList);
	
	return WordList;
}
//public Vector<ImageModel>;
}

