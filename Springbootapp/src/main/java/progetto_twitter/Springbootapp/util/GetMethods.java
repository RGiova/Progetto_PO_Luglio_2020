package progetto_twitter.Springbootapp.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
/**
 *
 * @author Lorenzo Sopranzetti, Giovanni Recchi, Francesco Pigliapoco
 * Classe che identifica il metodo richiesto
 */
public class GetMethods {
	/**
	 * Metodo che identifica il metodo da invocare e restituisce il risutato derivante dall'invocazione di quel metodo
	 * @param Name
	 * @param Class
	 * @return (long)object che identifica il risultato del metodo
	 */
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
