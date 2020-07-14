package progetto_twitter.Springbootapp.model;


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
		Occurrences = 1;
	}
	

}



