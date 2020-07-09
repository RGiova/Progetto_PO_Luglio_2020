package progetto_twitter.Springbootapp.model;

public class ImageModel {
private Long w;
private Long h;
private Long dimension;

public ImageModel(Long w, Long h) {
	super();
	this.w = w;
	this.h = h;
	this.setDimension(w*h);
}
public long getW() {
	return w;
}
public void setW(Long w) {
	this.w = w;
}
public long getH() {
	return h;
}
public void setH(Long h) {
	this.h = h;
}
public long getDimension() {
	return dimension;
}
public void setDimension(Long dimension) {
	this.dimension = dimension;
}
}
