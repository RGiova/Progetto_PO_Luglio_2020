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

public class StatsImpl implements Stats {

	@Override
	public  ArrayList<HashModel> HashStats(ArrayList<JSONModel> objp){
		Iterator<?> t = objp.iterator();
		ArrayList<HashModel> HashList = new ArrayList<HashModel>(objp.size());
		 while(t.hasNext()) {
		  JSONModel p1 = new JSONModel();
		  p1 = (JSONModel)t.next();
		  ArrayList<String> hash = p1.getHashtags();
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
	@Override
	public ArrayList<WordModel> WordStats(ArrayList<JSONModel> objp) {
	
		Iterator<?> t = objp.iterator();
		ArrayList<WordModel> WordList = new ArrayList<WordModel>(objp.size());
		while(t.hasNext()) {
		 JSONModel p1 = new JSONModel();
		 p1 = (JSONModel)t.next();
		
		 /*Elimino tutti i caratteri speciali (tranne gli spazi) e divido la stringa nelle singole parole che la compongono*/
		 
		 String Phrase = p1.getText().replaceAll("[^\\p{L}\\p{Z}]","");
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
	@Override
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
	@Override
	public String IMGminAvgMAX(JSONArray objp){
		int minW = 10000;
		int MAXW = 0;
		int AvgW = 0;
		StandardDeviation sd1 = new StandardDeviation();
		double SDW =0;
		int minH = 10000;
		int MAXH = 0;
		int AvgH = 0;
		StandardDeviation sd2 = new StandardDeviation();
		double SDH =0;
		int minD = 10000;
		int MAXD = 0;
		int AvgD = 0;
		StandardDeviation sd3 = new StandardDeviation();
		double SDD =0;
		int index = 0;
		int pics = 0;
		Iterator<?> t = objp.iterator();
		while(t.hasNext()) {
			JSONObject ImgObj = (ImageModel)t.next();
			Iterator<?> i = ImgObj.iterator();
			while(i.hasNext()) {
				ImageModel Img = ImgObj.getImg(); 
				if(Img.getW()> MAXW) MAXW = Img.getW();
				if(Img.getW()< minW) minW = Img.getW();
				AvgW += Img.getW();
				SDW = SD((double)Img.get(pics).getW());
				if(Img.getH()> MAXH) MAXH = Img.getH();
				if(Img.getH()< minH) minH = Img.getH();
				AvgH += Img.getH();
				SDH = SD((double)Img.get(pics).getH());
				if(Img.getD()> MAXD) MAXD = Img.getD();
				if(Img.getD()< minD) minD = Img.getD();
				AvgD += Img.getD();
				SDD = sd.SD(Img.getD());
				pics++;
			 } 
			index += pics;
		}
		return "minW ="+minW+" MAXW = "+MAXW+" AvgW = "+AvgW+" SDW = "+SDW+";\nminH = "+minH+" MAXH = "+MAXH+" AvgH = "+(AvgH/index)+" SDH = "+SDH+";\nminD = "+minD+" MAXD = "+MAXD+" AvgD = "+AvgD+" SDD = "+SDD+";"; 
	}
	
	@Override
	public String URLminAvgMAX(JSONArray objp){
		int min = 10000;
		int MAX = 0;
		int Avg = 0;
		StandardDeviation sd = new StandardDeviation();
		double SD =0;
		int index = 0;
		int urls = 0;
		Iterator<?> t = objp.iterator();
		while(t.hasNext()) {
			JSONModel URLObj = (JSONModel)t.next();
			urls=URLObj.getURL.size()
			SD = sd.SD(urls);
			index += urls;
		}
		return "minURLS ="+min+" MAXURLS = "+MAX+" AvgURLS = "+AvgW+" SDURLS = "+SD+";";
	}

	@Override
	public String DateminAvgMAX(JSONArray objp){
		SimpleDateFormat sdformat = new SimpleDateFormat("yyyy-MM-dd");
        Date ObjDate;
		int minDay = 10000;
		int MAXDay = 0;
		int AvgDay = 0;
		StandardDeviation sd1 = new StandardDeviation();
		double SDDay =0;
		int minMon = 10000;
		int MAXMon = 0;
		int AvgMon = 0;
		StandardDeviation sd2 = new StandardDeviation();
		double SDMon =0;
		int minYr = 10000;
		int MAXYr = 0;
		int AvgYr = 0;
		StandardDeviation sd3 = new StandardDeviation();
		double SDYr =0;
		Date lastDate = thisDate;
		int DayTotal = 0;
		int DayTweetCount;
		int MonTweetCount;
		int YrTweetCount= 0;
		Iterator<?> t = objp.iterator();
		while(t.hasNext()) {
			JSONModel DateObj = (JSONModel)t.next();
				String[] SplitDate = DateObj.getDate().split("/");
				thisDate = sdformat.parse(SplitDate[2] + "-" + SplitDate[1] + "-" + SplitDate[0]);
				if(thisDate.year.equals(lasatDate.year))
					if(thisDate.month.equals(lasatDate.month))
						if(thisDate.date.equals(lasatDate.date)) DayTweetCount++;
						else DayTweetCount = 1;
							 DayTotal++;
						
						MonTweetCount += DayTweetCount;
					else MonTweetCount = 1;
						 DayTotal++
					YrTweetCount += MonTweetCount;
				else YrTweetCount = 1;
					 DayTotal++;				
				
				if(Img.getW()> MAXW) MAXW = Img.getW();
				if(Img.getW()< minW) minW = Img.getW();
				AvgDay += Img.getW();
				SDW = sd1.SD(Img.getW());
				if(Img.getH()> MAXH) MAXH = Img.getH();
				if(Img.getH()< minH) minH = Img.getH();
				AvgH += Img.getH();
				SDH = sd2.SD(Img.getH());
				if(Img.getD()> MAXD) MAXD = Img.getD();
				if(Img.getD()< minD) minD = Img.getD();
				AvgD += Img.getD();
				SDD = sd3.SD(Img.getD());
				DayTotal++;
			 } 
			index += pics;
		}
		return "minDay ="+minDay+" MAXDay = "+MAXDay+" AvgDay = "+AvgDay/DayTotal+" SDDay = "+SDDay+";\nminMon = "+minMon+" MAXMon = "+MAXMon+" AvgMon = "+AvgMon+" SDMon = "+SDMon+";\nminYr = "+minYr+" MAXYr = "+MAXYr+" AvgYr = "+AvgYr+" SDD = "+SDD+";"; 
	}
	@Override
	public String HminAvgMAX(ArrayList<HashModel> HashList){
		int min = HashList.get(0).getOccorrenze();
		int MAX = HashList.get(0).getOccorrenze();
		int Avg =0;
		int index=0;
		Iterator<?> t = HashList.iterator();
		 while(t.hasNext()) {
			if(HashList.get(index).getOccorrenze()> MAX) MAX = HashList.get(index).getOccorrenze();
			if(HashList.get(index).getOccorrenze()< min) min = HashList.get(index).getOccorrenze();
			Avg += HashList.get(index).getOccorrenze();
		 }
		return  "minH ="+min+" MAXH = "+MAX+" AvgH = "+Avg+";";  
		
	}
	@Override
	public String WminAvgMAX(ArrayList<WordModel> WordList){
		int min = WordList.get(WordList.size() - 1).getOccorrenze();
		int MAX = WordList.get(0).getOccorrenze();
		int Avg =0;
		int index=0;
		Iterator<?> t = WordList.iterator();
		 while(t.hasNext()) {
			if(WordList.get(index).getOccorrenze()> MAX) MAX = WordList.get(index).getOccorrenze();
			if(WordList.get(index).getOccorrenze()< min) min = WordList.get(index).getOccorrenze();
			Avg += WordList.get(index).getOccorrenze();
		}
		return  "minWords ="+min+" MAXWords = "+MAX+" AvgWords = "+Avg+";";   	
	}
}

