package progetto_twitter.Springbootapp.filter;

import java.util.ArrayList;
import java.util.Iterator;

import progetto_twitter.Springbootapp.exceptions.WrongDateFormatException;
import progetto_twitter.Springbootapp.exceptions.WrongValueException;
import progetto_twitter.Springbootapp.model.JSONModel;
import progetto_twitter.Springbootapp.util.ListsCreate;
import progetto_twitter.Springbootapp.util.ModifyDate;

public class FilterImpl {
	private JSONModel obj;
	private ImgDateTextFilterImpl Object = new ImgDateTextFilterImpl();;
	private boolean ToRemove;

	public void AndFilter(String fields, ArrayList<String> values, String operator) throws WrongDateFormatException, WrongValueException {
		Iterator<JSONModel> i = ListsCreate.Lists.getMList().iterator();
		while (i.hasNext()) {
			obj = new JSONModel();
			obj = (JSONModel) i.next();
			ToRemove = FilterUtil(fields, values, operator);
			if (ToRemove) {
				ListsCreate.Lists.ToPushListDelete(obj);
			}

		}
	}

	public void OrFilter(String fields, ArrayList<String> values, String operator, int contatore, int size)
			throws WrongDateFormatException, WrongValueException {
		Iterator<?> i;
		if (contatore == 1) {
			i = ListsCreate.Lists.getToPushList().iterator();
			ListsCreate.Lists.ToFilterListCreate();
			ListsCreate.Lists.ToFilterList2Create();
		} else {
			i = ListsCreate.Lists.getToFilterList().iterator();
		}
		while (i.hasNext()) {
			obj = new JSONModel();
			obj = (JSONModel) i.next();
			ToRemove = FilterUtil(fields, values, operator);
			if (ToRemove && contatore == 1)
				ListsCreate.Lists.ToFilterListAdd(obj);
			else if (ToRemove && contatore > 1) {
				ListsCreate.Lists.ToFilterList2Add(obj);

			}

		}
		if (size != 1 && contatore != 1 && ListsCreate.Lists.getToFilterList().size() > 0) {
			ListsCreate.Lists.getToFilterList().clear();
			ListsCreate.Lists.getToFilterList().addAll(ListsCreate.Lists.getToFilterList2());
			ListsCreate.Lists.getToFilterList2().clear();
		}
		if (contatore == size)
			ListsCreate.Lists.getToPushList().removeAll(ListsCreate.Lists.getToFilterList());
	}

	public boolean FilterUtil(String fields, ArrayList<String> values, String operator)
			throws WrongDateFormatException, WrongValueException {
		Iterator<String> J = values.iterator();
		while (J.hasNext()) {
			String Next = J.next();
			if (fields.equals("w") || fields.equals("h") || fields.equals("dimension"))
				ToRemove = Object.FilteringofImages(fields, obj, Next, operator, values);
			else if (fields.equals("text"))
				ToRemove = Object.FilteringofText(Next, obj, operator, values);
			else if (fields.equals("date"))
				ToRemove = Object.FilteringofDate(obj, Next, operator, values);
		}
		return ToRemove;

	}

}
