package progetto_twitter.Springbootapp.model;

import java.util.ArrayList;
import java.util.Vector;

public class JSONModel {
private long post_id;
private String date;
private String text;
private ArrayList<String> hashtags;
private ArrayList<String> Url;
private Vector<ImageModel> Img;
private String name;
private long user_id;

public long getPost_id() {
	return post_id;
}
public void setPost_id(long l) {
	this.post_id = l;
}
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
public ArrayList<String> getHashtags() {
	return hashtags;
}
public void setHashtags(ArrayList<String> hashtags) {
	this.hashtags = hashtags;
}
public ArrayList<String> getURL() {
	return Url;
}
public void setURL(ArrayList<String> uRL) {
	Url = uRL;
}
public Vector<ImageModel> getImg() {
	return Img;
}
public void setImg(Vector<ImageModel> vector) {
	Img = vector;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public long getUser_id() {
	return user_id;
}
public void setUser_id(long l) {
	this.user_id = l;

}
}
