package progetto_twitter.Springbootapp.model;

public class FilterModel {
	private String field;
	private String operator;
	private Object values = new Object();

	public FilterModel() {
		super();
		this.field = null;
		this.operator = null;
		this.values = null;
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

	public Object getValues() {
		return values;
	}

	public void setValues(Object values) {
		this.values = values;
	}

}
