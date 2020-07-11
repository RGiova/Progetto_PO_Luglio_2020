package progetto_twitter.Springbootapp.model;

import java.util.ArrayList;
import java.util.Iterator;

public class WordModel extends HashModel {
	private int length;
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	public WordModel(String text, int length) {
		this.text= text;
		this.length = length;
		Occorrenze = 1;
	}
	

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
		String Dispersion = String.format("min = %d MAX = %d Avg = %d", min,MAX,(Avg/index)); 
		return Dispersion;
		
	}
}



