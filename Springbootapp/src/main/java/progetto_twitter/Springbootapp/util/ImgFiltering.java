package progetto_twitter.Springbootapp.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;
import progetto_twitter.Springbootapp.filter.*;
import progetto_twitter.Springbootapp.model.ImageModel;
import progetto_twitter.Springbootapp.model.JSONModel;

public class ImgFiltering {
	public static void FilteringofImages(String fields, JSONModel obj, String value, String operator,ArrayList<String> values) {
		if(obj.getImg()==null) {
			obj.setTo_insert(false);
			ListToPush.ListDelete(obj);
			return;
		}
		Long length;
		try {
			length = Long.parseLong(value);
			}
			catch (NumberFormatException e)
		{
		length=(long) 0;
		}
		Vector<ImageModel> ClassImg = obj.getImg();
		Iterator<ImageModel> k = ClassImg.iterator();
		while (k.hasNext()) {
			Object imgObject = (Object) k.next();
			Long field = GetMethods.SearchMethod(fields, imgObject);
			if ((operator.equals("not") || operator.equals("nin"))
					&& GetMethods.SearchMethod(fields, imgObject).equals(value))
				ListToPush.ListDelete(obj);
			else if (operator.equals("$in") && !field.equals(value))
				ListToPush.ListDelete(obj);
			else if (operator.equals("$gt") && field<=length)
				ListToPush.ListDelete(obj);
			else if (operator.equals("$gte") && field<length)
				ListToPush.ListDelete(obj);
			else if (operator.equals("$lt") && field>=length)
				ListToPush.ListDelete(obj);
			else if (operator.equals("$lte") && field>length)
				ListToPush.ListDelete(obj);
			else if (operator.equals("$bt") && (field<Integer.parseInt(values.get(0)) || field>Integer.parseInt(values.get(1))))
				ListToPush.ListDelete(obj);

				
		}

	}
}
