package progetto_twitter.Springbootapp.model;

public class StatsModel {
private String Name;
private int min;
private int max;
private double average;
private double StdDeviation;


public StatsModel(String name, int min, int max, double average, double stdDeviation) {
	super();
	Name = name;
	this.min = min;
	this.max = max;
	this.average = average;
	StdDeviation = stdDeviation;
}


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
public double getAverage() {
	return average;
}
public void setAverage(double average) {
	this.average = average;
}
public double getStdDeviation() {
	return StdDeviation;
}
public void setStdDeviation(double stdDeviation) {
	StdDeviation = stdDeviation;
}
public String getName() {
	return Name;
}
public void setName(String name) {
	Name = name;
}

}
