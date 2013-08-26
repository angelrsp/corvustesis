package ec.edu.uce.inventario.util;

public class ReflectionUtil {

	public static Object getValorGet(Object object, String method) {
		StringBuilder sb = null;
		Object value = null;
		try {
			if (object != null && method != null && method.length() > 0) {
				sb = new StringBuilder().append("get")
						.append(String.valueOf(method.charAt(0)).toUpperCase())
						.append(method.substring(1));
				value=object.getClass().getMethod(sb.toString(), new Class[0]).invoke(object, new Object[0]);		
			}
		} catch (Exception e) {

		}
		return value;
	}
}
