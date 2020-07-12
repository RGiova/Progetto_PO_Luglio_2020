package progetto_twitter.Springbootapp.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class GetMethods {
	public static Long SearchMethod(String Name, Object Class) {
		Method m = null;
		Object object = null;
		try {
			m = Class.getClass().getMethod("get" + Name.substring(0, 1).toUpperCase() + Name.substring(1));
			object = m.invoke(Class);
		} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException
				| InvocationTargetException e) {
			e.printStackTrace();
		}
		return (Long)object;

	}
}
