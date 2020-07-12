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
}
