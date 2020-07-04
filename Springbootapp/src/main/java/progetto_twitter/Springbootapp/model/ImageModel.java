package progetto_twitter.Springbootapp.model;

public class ImageModel {
private long w;
private long h;

public ImageModel(long w, long h) {
	super();
	this.w = w;
	this.h = h;
}
public long getW() {
	return w;
}
public void setW(int w) {
	this.w = w;
}
public long getH() {
	return h;
}
public void setH(int h) {
	this.h = h;
}

}
