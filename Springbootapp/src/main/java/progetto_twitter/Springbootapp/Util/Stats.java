package progetto_twitter.Springbootapp.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import progetto_twitter.Springbootapp.model.StandardDeviation;
import progetto_twitter.Springbootapp.model.HashModel;
import progetto_twitter.Springbootapp.model.ImageModel;
import progetto_twitter.Springbootapp.model.JSONModel;
import progetto_twitter.Springbootapp.model.WordModel;

public class Stats {

	private static JSONObject p1 = new JSONObject();

	public  ArrayList<HashModel> HashStats(JSONArray objp){
		Iterator<?> t = objp.iterator();
		ArrayList<HashModel> HashList = new ArrayList<HashModel>(objp.size());
		 while(t.hasNext()) {
		  JSONModel Mdl = new JSONModel();
		  p1 = (JSONObject)t.next();
		ArrayList<String> hash = Mdl.getHashtags();
		boolean found=false;
		int index = 0;
		
		 /*Scorro HashList per constatare se l'hashtag è già stata utilizzata o meno*/
		
		for(int j=0; j<hash.size(); j++) {
			for(int i=0; i<HashList.size(); i++) {
				if(HashList.get(i).getText().equals(hash.get(j))) {
					index=i;
					found=true;
					break;
					}
				}
			}
		
		/*Incremento Occorrenze dell'Hashtag se questa è già in lista, altrimenti la inserisco*/
		
			if(found) {
				HashList.get(index).setOccorrenze(HashList.get(index).getOccorrenze() + 1);
			}
			else {
				HashModel NewHash = new HashModel(hash.get(index));
				HashList.add(NewHash);
			}
				 }
		 return HashList;
	
	}
	
	public ArrayList<WordModel> WordStats(JSONArray objp) {
	
		Iterator<?> t = objp.iterator();
		ArrayList<WordModel> WordList = new ArrayList<WordModel>(objp.size());
		while(t.hasNext()) {
		 JSONModel Mdl = new JSONModel();
		 p1 = (JSONObject)t.next();
		
		 /*Elimino tutti i caratteri speciali (tranne gli spazi) e divido la stringa nelle singole parole che la compongono*/
		 
		 String Phrase = Mdl.getText().replaceAll("[^\\p{L}\\p{Z}]","");
		 ArrayList<String> Words = (ArrayList<String>) Arrays.asList(Phrase.split("\s"));
		 boolean found=false;
		 int index = 0;
		 for(int j=0; j<Words.size(); j++) {
			 String Word=Words.get(j).toLowerCase();
			 
			 /*Controllo la parola per ignorare Tag, Hashtag e URL*/
			 
			 if (Word.charAt(0)=='#'||Word.charAt(0)=='@') break;
			 if(Word.substring(0, 4).equals("http")) break;
			
			 /*Scorro WordList per constatare se la parola è già stata utilizzata o meno*/
			
			 for(int i=0; i<WordList.size(); i++) {
				if(WordList.get(i).getText().equals(Word)) {
					index=i;
					found=true;
					break;
				}
				
				/*Incremento Occorrenze della parola se questa è già in lista, altrimenti la inserisco*/
	
				if(found) {
				WordList.get(index).setOccorrenze(WordList.get(index).getOccorrenze() + 1);
				}
				else {
				Integer length = Words.get(j).length();
				WordModel NewWord = new WordModel(Words.get(index), length);
				WordList.add(NewWord);
				}
	
			 }
	
		}
	
		}
		
		Collections.sort(WordList);
		
		return WordList;
	}
	
	public ArrayList<WordModel> getTopN(ArrayList<WordModel> WordList, int N) {
		int index = 0;
		Iterator<?> t = WordList.iterator();
		ArrayList<WordModel> WordListN = new ArrayList<WordModel>(N-1);
		while(t.hasNext() && index<N) {
			WordListN.get(index).setText(WordList.get(index).getText());
			WordListN.get(index).setLength(WordList.get(index).getLength());
			WordListN.get(index).setOccorrenze(WordList.get(index).getOccorrenze());
			index++;
		}
		return WordListN;
	
	}
	
	public String IminAvgMAX(JSONArray objp){
		int minW = 10000;
		int MAXW = 0;
		int AvgW = 0;
		StandardDeviation SDW = new StandardDeviation();
		int minH = 10000;
		int MAXH = 0;
		int AvgH = 0;
		StandardDeviation SDH = new StandardDeviation();
		int minD = 10000;
		int MAXD = 0;
		int AvgD = 0;
		StandardDeviation SDD = new StandardDeviation();
		int index = 0;
		int pics = 0;
		Iterator<?> t = objp.iterator();
		while(t.hasNext()) {
			JSONObject ImgObj =  ;
			Iterator<?> i = ImgObj.iterator();
			while(i.hasNext()) {
				ImageModel Img = ImgObj.get(pics).getImg(); 
				if(ImgObj.get(pics).getW()> MAXW) MAXW = Img.get(pics).getW();
				if(ImgObj.get(pics).getW()< minW) minW = Img.get(pics).getW();
				AvgW += ImgObj.get(pics).getW();
				SDW = SD((double)Img.get(pics).getW());
				if(ImgObj.get(pics).getH()> MAXH) MAXH = Img.get(pics).getH();
				if(ImgObj.get(pics).getH()< minH) minH = Img.get(pics).getH();
				AvgH += ImgObj.get(pics).getH();
				SDH = SD((double)Img.get(pics).getH());
				if(ImgObj.get(pics).getD()> MAXD) MAXD = Img.get(pics).getD();
				if(ImgObj.get(pics).getD()< minD) minD = Img.get(pics).getD();
				AvgD += ImgObj.get(pics).getD();
				SDD = SD((double)Img.get(pics).getD());
				pics++;
			 } 
			index += pics;
		}
		String Dispersion = String.format("minW = %d MAXW = %d AvgW = %d SDW = %l;\nminH = %d MAXH = %d AvgH = %d SDH = %l;\nminD = %d MAXD = %d AvgW = %d SDD = %l;", minW,MAXW,(AvgW/index),SDW,minH,MAXH,(AvgH/index),SDH,minD,MAXD,(AvgD/index),SDD); 
		return Dispersion;
	}
	
	public String UminAvgMAX(JSONArray objp){
		int min = 10000;
		int MAX = 0;
		int Avg = 0;
		StandardDeviation SD = new StandardDeviation();
		int index = 0;
		int urls = 0;
		Iterator<?> t = objp.iterator();
		while(t.hasNext()) {
			JSONModel URLObj =  ;
			Iterator<?> i = URLObj.iterator();
			while(i.hasNext()) {
				ImageModel Img = URLObj.get(urls).getURL(); 
				if(URLObj.get(urls).getW()> MAX) MAX = UrlObj.get(urls).getURL();
				if(URLObj.get(urls).getW()< min) min = UrlObj.get(urls).getURL();
				Avg += URLObj.get(urls).getURL();
				
				urls++;
			 } 
			SD = SD.SD((double)urls);
			index += urls;
		}
		String Dispersion = String.format("min = %d MAX = %d Avg = %d SD = %l", min,MAX,(Avg/index),SD); 
		return Dispersion;
	}

}

