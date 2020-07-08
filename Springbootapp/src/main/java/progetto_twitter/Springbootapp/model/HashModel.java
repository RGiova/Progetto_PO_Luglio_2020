package progetto_twitter.Springbootapp.model;

public class HashModel {
	private String text;
	private Integer Occorrenze;
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
	public HashModel(String text) {
		this.text = text;
		Occorrenze = 1;
	}
	


}