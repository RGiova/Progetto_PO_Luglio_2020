package progetto_twitter.Springbootapp.util;

import java.util.Iterator;
import java.util.Vector;
import progetto_twitter.Springbootapp.filter.*;
import progetto_twitter.Springbootapp.model.ImageModel;
import progetto_twitter.Springbootapp.model.JSONModel;

public class ImgFiltering {
	public static void FilteringofImages(String fields, JSONModel obj, Object values, String operator) {
		if(obj.getImg()==null) {
			obj.setTo_insert(false);
			return;
		}
		Vector<ImageModel> ClassImg = obj.getImg();
		Iterator<ImageModel> k = ClassImg.iterator();
		while (k.hasNext()) {
			Object imgObject = (Object) k.next();
			if ((operator.equals("not") || operator.equals("nin"))
					&& FilterOperators.SearchMethod(fields, imgObject).equals(values))
				obj.setTo_insert(false);
			else if (operator.equals("in") && !FilterOperators.SearchMethod(fields, imgObject).equals(values))
				obj.setTo_insert(false);
		}

	}
}
