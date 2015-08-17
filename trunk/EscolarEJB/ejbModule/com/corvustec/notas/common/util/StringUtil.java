package com.corvustec.notas.common.util;

public class StringUtil {

	public static String obtenerDocumentoModificado(String codDoc)
	  {
	    if ("01".equals(codDoc)) {
	      return "FACTURA";
	    }
	    if ("04".equals(codDoc)) {
	      return "NOTA DE CRÉDITO";
	    }
	    if ("05".equals(codDoc)) {
	      return "NOTA DE DÉBITO";
	    }
	    if ("06".equals(codDoc)) {
	      return "GUÍA REMISIÓN";
	    }
	    if ("07".equals(codDoc)) {
	      return "COMPROBANTE DE RETENCIÓN";
	    }
	    return null;
	  }
	
}
