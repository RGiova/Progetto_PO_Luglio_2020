package progetto_twitter.Springbootapp.filter;

import progetto_twitter.Springbootapp.model.FilterModel;

public class FilterStudy  {
public static void Filtered(String fields, String operator, Object values) {
	if(fields!=null) {
		switch(operator) {
			case "$not":
				FilterOperators.notFilter(fields,values);
				break;
			case "$in":
				FilterOperators.inFilter(fields,values);
				break;
			case "$nin":
				FilterOperators.ninFilter(fields,values);
				break;
			case "$gt":
				FilterOperators.gtFilter(fields,values);
			    break;
			case "$gte":
				FilterOperators.gteFilter(fields,values);
				break;
			case "$lt":
				FilterOperators.ltFilter(fields,values);
				break;
			case "$lte":
				FilterOperators.lteFilter(fields,values);
				break;
			case "$bt":
				FilterOperators.btFilter(fields,values);
				break;
				default:
					//mandare eccezione
			
	}
		//if (operator.equals("$or"))
			//return orFilter(values);
		//else if(operator.equals("$and"))
			//return andFilter(values);
		//else lanciare eccezione
}
}
}
