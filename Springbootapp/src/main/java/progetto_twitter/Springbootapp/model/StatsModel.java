package progetto_twitter.Springbootapp.model;

public class StatsModel {
private String Name;
private int min;
private int max;
private long average;
private long StdDeviation;


public int getMin() {
	return min;
}
public void setMin(int min) {
	this.min = min;
}
public int getMax() {
	return max;
}
public void setMax(int max) {
	this.max = max;
}
public long getAverage() {
	return average;
}
public void setAverage(long average) {
	this.average = average;
}
public long getStdDeviation() {
	return StdDeviation;
}
public void setStdDeviation(long stdDeviation) {
	StdDeviation = stdDeviation;
}
public String getName() {
	return Name;
}
public void setName(String name) {
	Name = name;
}

}
