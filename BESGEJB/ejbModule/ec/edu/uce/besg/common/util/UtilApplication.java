/**
 * 
 */
package ec.edu.uce.besg.common.util;



public final class UtilApplication {
	
	/**
	 * M&eacute;todo para concatenar varios StringBuilder
	 * @param values
	 * @return StringBuilder
	 */
	public static StringBuilder appendStringBuilder(Object... values) {
			
		StringBuilder builder = new StringBuilder();
		
		for (Object value : values) {
			if (value == null) {
				builder.append(String.valueOf(value));
			}
			builder.append(value);
		}
		return builder;
	}
	
	
	
	
}
