package progetto_twitter.Springbootapp.model;

import java.util.ArrayList;

public class FilterModel {
	private String field;
	private String operator;
	private ArrayList<String> values = new ArrayList<String>();

	public FilterModel() {
		super();
		this.field = null;
		this.operator = null;
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public ArrayList<String> getValues() {
		return values;
	}

	public void setValues(ArrayList<String> values) {
		this.values = values;
	}
	public void AddValue(String pippo) {
		String[] ToAddValue = pippo.split(",");
		for (int i = 0; i<ToAddValue.length;i++) 
		values.add(ToAddValue[i]);
		}
	

}
