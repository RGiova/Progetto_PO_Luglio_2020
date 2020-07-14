package progetto_twitter.Springbootapp.model;

public class HashModel implements Comparable<HashModel>  {
	protected String text;
	protected int Occurrences;
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public int getOccurrences() {
		return Occurrences;
	}
	public void setOccurrences(Integer Occurrences) {
		this.Occurrences = Occurrences;
	}
	public HashModel(String text) {
		this.text = text;
		Occurrences = 1;
	}
	public HashModel() {
	}
	@Override
	public int compareTo(HashModel HashCompare) {
    	int compareOcc=((HashModel)HashCompare).getOccurrences();


    	/*In ordine decrescente*/
    	return compareOcc-this.Occurrences;
	}
}
