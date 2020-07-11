package progetto_twitter.Springbootapp.model;

import java.util.ArrayList;
import java.util.Iterator;

public class HashModel implements Comparable<HashModel>  {
	protected String text;
	protected int Occorrenze;
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public int getOccorrenze() {
		return Occorrenze;
	}
	public void setOccorrenze(Integer occorrenze) {
		Occorrenze = occorrenze;
	}
	public HashModel(String text) {
		this.text = text;
		Occorrenze = 1;
	}
	public HashModel() {
	}
	@Override
	public int compareTo(HashModel HashCompare) {
    	int compareOcc=((HashModel)HashCompare).getOccorrenze();


    	/*In ordine decrescente*/
    	return compareOcc-this.Occorrenze;
	}

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
		String Dispersion = String.format("min = %d MAX = %d Avg = %d", min,MAX,(Avg/index)); 
		return Dispersion;
		
	}

}
