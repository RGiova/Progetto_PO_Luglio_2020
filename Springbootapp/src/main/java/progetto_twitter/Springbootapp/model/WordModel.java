package progetto_twitter.Springbootapp.model;


public class WordModel implements Comparable<WordModel> {
	private String text;
	private  Integer Occorrenze;
	private Integer length;
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public Integer getOccorrenze() {
		return Occorrenze;
	}
	public void setOccorrenze(Integer occorrenze) {
		Occorrenze = occorrenze;
	}
	public Integer getLength() {
		return length;
	}
	public void setLength(Integer length) {
		this.length = length;
	}
	public WordModel(String text, Integer length) {
		super();
		this.text = text;
		this.length = length;
		Occorrenze = 1;
	}
	

@Override
public int compareTo(WordModel WordCompare) {
    int compareOcc=((WordModel)WordCompare).getOccorrenze();


    // In ordine decrescente 
    return compareOcc-this.Occorrenze;
}



}
