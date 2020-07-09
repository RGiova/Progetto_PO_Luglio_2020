package progetto_twitter.Springbootapp.filter;

import java.util.ArrayList;

public interface FilterInterface {
	public abstract void Filter (String fields, ArrayList<String> values, String operator);
}
