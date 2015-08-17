package com.corvustec.notas.common.util;

public class StringUtil {

	public static String obtenerDocumentoModificado(String codDoc)
	  {
	    if ("01".equals(codDoc)) {
	      return "FACTURA";
	    }
	    if ("04".equals(codDoc)) {
	      return "NOTA DE CR�DITO";
	    }
	    if ("05".equals(codDoc)) {
	      return "NOTA DE D�BITO";
	    }
	    if ("06".equals(codDoc)) {
	      return "GU�A REMISI�N";
	    }
	    if ("07".equals(codDoc)) {
	      return "COMPROBANTE DE RETENCI�N";
	    }
	    return null;
	  }
	
}
