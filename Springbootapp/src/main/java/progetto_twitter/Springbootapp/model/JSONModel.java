package progetto_twitter.Springbootapp.model;

import java.util.Vector;

public class JSONModel {
private String date;
private String text;
private Vector<String> hashtags;
private Vector<String> URL;
private Vector<ImageModel> Img;


public String getDate() {
	return date;
}
public void setDate(String date) {
	this.date = date;
}
public String getText() {
	return text;
}
public void setText(String text) {
	this.text = text;
}
public Vector<String> getHashtags() {
	return hashtags;
}
public void setHashtags(Vector<String> hashtags) {
	this.hashtags = hashtags;
}
public Vector<String> getURL() {
	return URL;
}
public void setURL(Vector<String> uRL) {
	URL = uRL;
}
public Vector<ImageModel> getImg() {
	return Img;
}
public void setImg(Vector<ImageModel> img) {
	Img = img;
}



}
