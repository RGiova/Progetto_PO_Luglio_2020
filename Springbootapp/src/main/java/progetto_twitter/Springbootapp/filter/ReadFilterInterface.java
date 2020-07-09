package progetto_twitter.Springbootapp.filter;

import org.json.simple.JSONObject;

public interface ReadFilterInterface {
	public abstract void Filter(JSONObject obj);
	public abstract void Filter(Object Obj, String[] Aoperators);
}
