/**
 * 
 */
package com.corvustec.facee.files.commons.util;

/**
 * Constantes comunes que se usan en la aplicaci&oacute;n, todas se debe leer de un archivo de propiedades
 * @author wilmerPC
 *
 */
public class Constantes {
	
	/**
	 * Url del archivo con las rutas del archivo donde se encuentran las carpetas de los archivos de cada cliente
	 */
	public static final String URL_ARCHIVO_CLIENTES = MessagesApplication.getInstancia().getString("com.corvustec.facee.files.url.archivo.rutas.clientes");
	
	/**
	 * tiempo cada que se verifica los cambios en la carpeta
	 */
	public static final String TIME_CHECK = MessagesApplication.getInstancia().getString("com.corvustec.facee.files.time.check");
	
	/**
	 * Separador dentro de los archivos
	 */
	public static final String SPLIT_ARCHIVOS = MessagesApplication.getInstancia().getString("com.corvustec.facee.files.split");
	
	/**
	 * Separador igual
	 */
	public static final String SPLIT_IGUAL = MessagesApplication.getInstancia().getString("com.corvustec.facee.files.split.igual");
	
	/**
	 * Formato fecha sri
	 */
	public static final String FORMATO_FECHA_SRI = MessagesApplication.getInstancia().getString("com.corvustec.facee.files.formato.fecha.sri");
	
	/**
	 * Formato fecha clave de acceso
	 */
	public static final String FORMATO_FECHA_CLAVE_ACCESO = MessagesApplication.getInstancia().getString("com.corvustec.facee.files.formato.fecha.claveAcceso");
	
	/**
	 * Ambiente
	 */
	public static final String AMBIENTE = MessagesApplication.getInstancia().getString("com.corvustec.facee.files.ambiente");
	
	/**
	 * Moneda
	 */
	public static final String MONEDA = MessagesApplication.getInstancia().getString("com.corvustec.facee.files.moneda");
	/**
	 * tipoEmision normal
	 */
	public static final String TIPO_EMISION_NORMAL = MessagesApplication.getInstancia().getString("com.corvustec.facee.files.tipo.emision.normal");
	
	/**
	 * tipoEmision contingencia
	 */
	public static final String TIPO_EMISION_CONTINGENCIA = MessagesApplication.getInstancia().getString("com.corvustec.facee.files.tipo.emision.contingencia");

	/**
	 * Atributo del xml id
	 */
	public static final String XML_ATRIBUTO_ID = MessagesApplication.getInstancia().getString("com.corvustec.facce.files.xml.atributo.id"); 
	
	/**
	 * Atributo del xml version
	 */
	public static final String XML_ATRIBUTO_VERSION = MessagesApplication.getInstancia().getString("com.corvustec.facce.files.xml.atributo.version");
	
	
	//////////////////////////////////////////////////////////////////////////////////
	
	/**
	 * url plantilla para procesar la factura
	 */
	public final static String URL_PLANTILLA_FACTURA = MessagesApplication
			.getInstancia().getString("com.corvustec.facee.files.plantilla.factura");
	
	public final static String URL_PLANTILLA_NOTACREDITO = MessagesApplication
			.getInstancia().getString("com.corvustec.facee.files.plantilla.notaCredito");
	
	public final static String URL_PLANTILLA_NOTADEBITO = MessagesApplication
			.getInstancia().getString("com.corvustec.facee.files.plantilla.notaDebito");
	
	public final static String URL_PLANTILLA_GUIAREMISION = MessagesApplication
			.getInstancia().getString("com.corvustec.facee.files.plantilla.guiaRemision");
	
	
	//////////////////////////////////////////////////////////////////////////////////
	/**
	 * xpath infoTributaria plantilla factura
	 */
	public final static String XPATH_INFO_TRIBUTARIA = MessagesApplication
			.getInstancia().getString("com.corvustec.facee.files.xpath.factura.infoTributaria");
	
	/**
	 * xpath infoFactura plantilla factura
	 */
	public final static String XPATH_INFO_FACTURA = MessagesApplication
			.getInstancia().getString("com.corvustec.facee.files.xpath.factura.infoFactura");
	
	/**
	 * xpath totalConImpuestos plantilla factura
	 */
	public final static String XPATH_TOTAL_IMPUESTO = MessagesApplication
			.getInstancia().getString("com.corvustec.facee.files.xpath.factura.totalConImpuestos");
	
	
	
	/**
	 * xpath detalle plantilla factura
	 */
	public final static String XPATH_DETALLE = MessagesApplication
			.getInstancia().getString("com.corvustec.facee.files.xpath.factura.detalle");
	
	/**
	 * xpath impuestos plantilla factura
	 */
	public final static String XPATH_IMPUESTOS = MessagesApplication
			.getInstancia().getString("com.corvustec.facee.files.xpath.factura.impuestos");
	
	/**
	 * xpath retenciones plantilla factura
	 */
	public final static String XPATH_RETENCIONES = MessagesApplication
			.getInstancia().getString("com.corvustec.facee.files.xpath.factura.retenciones");
	
	//////////////////////////////////////////////////////////////////////////////////
	/**
	 * indentificador de la linea infoTributaria en el archivo txt de la factura
	 */
	public final static String IDENTIFICADOR_INFO_TRIBUTARIA = MessagesApplication
			.getInstancia().getString("com.corvustec.facee.files.factura.identificador.infoTributaria");
	
	/**
	 * indentificador de la linea infoFactura en el archivo txt de la factura
	 */
	public final static String IDENTIFICADOR_INFO_FACTURA = MessagesApplication
			.getInstancia().getString("com.corvustec.facee.files.factura.identificador.infoFactura");
	
	/**
	 * indentificador de la linea totalConImpuestos en el archivo txt de la factura
	 */
	public final static String IDENTIFICADOR_TOTAL_IMPUESTOS = MessagesApplication
			.getInstancia().getString("com.corvustec.facee.files.factura.identificador.totalConImpuestos");
	
	/**
	 * indentificador de la linea detalle en el archivo txt de la factura
	 */
	public final static String IDENTIFICADOR_DETALLE = MessagesApplication
			.getInstancia().getString("com.corvustec.facee.files.factura.identificador.detalle");
	
	/**
	 * indentificador de la linea impuestos en el archivo txt de la factura
	 */
	public final static String IDENTIFICADOR_IMPUESTOS = MessagesApplication
			.getInstancia().getString("com.corvustec.facee.files.factura.identificador.impuestos");
	
	/**
	 * indentificador de la linea retenciones en el archivo txt de la factura
	 */
	public final static String IDENTIFICADOR_RETENCIONES = MessagesApplication
			.getInstancia().getString("com.corvustec.facee.files.factura.identificador.retenciones");
	
	////////////////////////////////////////////////////////////////////////////////////////////////
	//////////////////////////////////NOTA DE CREDITO///////////////////////////////////////////////////
	
	///////////////
	
	/**
	 * xpath infoTributaria plantilla notaCredito
	 */
	public final static String XPATH_INFO_TRIBUTARIA_NC = MessagesApplication
			.getInstancia().getString("com.corvustec.facee.files.xpath.notaCredito.infoTributaria");
	
	/**
	 * xpath infoFactura plantilla notaCredito
	 */
	public final static String XPATH_INFO_NOTACREDITO = MessagesApplication
			.getInstancia().getString("com.corvustec.facee.files.xpath.notaCredito.infoFactura");
	
	/**
	 * xpath totalConImpuestos plantilla notaCredito
	 */
	public final static String XPATH_TOTAL_IMPUESTO_NC = MessagesApplication
			.getInstancia().getString("com.corvustec.facee.files.xpath.notaCredito.totalConImpuestos");
	
	/**
	 * xpath detalle plantilla notaCredito
	 */
	public final static String XPATH_DETALLE_NC = MessagesApplication
			.getInstancia().getString("com.corvustec.facee.files.xpath.notaCredito.detalle");
	
	/**
	 * xpath impuestos plantilla notaCredito
	 */
	public final static String XPATH_IMPUESTOS_NC = MessagesApplication
			.getInstancia().getString("com.corvustec.facee.files.xpath.notaCredito.impuestos");
	
	
	//////////////////////////////nota credito/////////////////////
	
	/**
	 * indentificador de la linea infoTributaria en el archivo txt de la factura
	 */
	public final static String IDENTIFICADOR_INFO_TRIBUTARIA_NC = MessagesApplication
			.getInstancia().getString("com.corvustec.facee.files.notaCredito.identificador.infoTributaria");
	
	/**
	 * indentificador de la linea infoFactura en el archivo txt de la factura
	 */
	public final static String IDENTIFICADOR_INFO_NOTACREDITO= MessagesApplication
			.getInstancia().getString("com.corvustec.facee.files.notaCredito.identificador.infoNotaCredito");
	
	/**
	 * indentificador de la linea totalConImpuestos en el archivo txt de la factura
	 */
	public final static String IDENTIFICADOR_TOTAL_IMPUESTOS_NC = MessagesApplication
			.getInstancia().getString("com.corvustec.facee.files.notaCredito.identificador.totalConImpuestos");
	
	/**
	 * indentificador de la linea detalle en el archivo txt de la factura
	 */
	public final static String IDENTIFICADOR_DETALLE_NC = MessagesApplication
			.getInstancia().getString("com.corvustec.facee.files.notaCredito.identificador.detalle");
	
	/**
	 * indentificador de la linea impuestos en el archivo txt de la factura
	 */
	public final static String IDENTIFICADOR_IMPUESTOS_NC = MessagesApplication
			.getInstancia().getString("com.corvustec.facee.files.notaCredito.identificador.impuestos");
	

////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////NOTA DE DEBITO///////////////////////////////////////////////////

///////////////

	/**
	 * xpath infoTributaria plantilla notaDebito
	 */
	public final static String XPATH_INFO_TRIBUTARIA_ND = MessagesApplication
			.getInstancia().getString(
					"com.corvustec.facee.files.xpath.notaDebito.infoTributaria");

	/**
	* xpath infoNotaDebito plantilla notaDebito
	*/
	public final static String XPATH_INFO_NOTADEBITO= MessagesApplication
	.getInstancia().getString("com.corvustec.facee.files.xpath.notaDebito.infoNotaDebito");
	
	/**
	* xpath impuesto plantilla notaDebito
	*/
	public final static String XPATH_IMPUESTO_ND = MessagesApplication
	.getInstancia().getString("com.corvustec.facee.files.xpath.notaDebito.impuesto");

	/**
	* xpath motivos plantilla notaDebito
	*/
	public final static String XPATH_MOTIVOS = MessagesApplication
	.getInstancia().getString("com.corvustec.facee.files.xpath.notaDebito.motivos");
	
	
	
	//////////////////////////////Nota Debito/////////////////////
	
	/**
	* indentificador de la linea infoTributaria en el archivo txt de la notaDebito
	*/
	public final static String IDENTIFICADOR_INFO_TRIBUTARIA_ND = MessagesApplication
	.getInstancia().getString("com.corvustec.facee.files.notaDebito.identificador.infoTributaria");
	
	/**
	* indentificador de la linea infoNotaDebito en el archivo txt de la notaDebito
	*/
	public final static String IDENTIFICADOR_INFO_NOTADEBITO= MessagesApplication
	.getInstancia().getString("com.corvustec.facee.files.notaDebito.identificador.infoNotaDebito");
	
	/**
	* indentificador de la linea impuesto en el archivo txt de la notaDebito
	*/
	public final static String IDENTIFICADOR_IMPUESTO_ND = MessagesApplication
	.getInstancia().getString("com.corvustec.facee.files.notaDebito.identificador.impuesto");
	
	/**
	* indentificador de la linea motivos en el archivo txt de la notaDebito
	*/
	public final static String IDENTIFICADOR_MOTIVOS = MessagesApplication
	.getInstancia().getString("com.corvustec.facee.files.notaDebito.identificador.motivos");
	
	
	/////////////////////////////////////////////////////////////////////////////////////
	//////////////////////////////////////////GUIA REMISION///////////////////////
	
	
	
	/**
	* xpath infoTributaria plantilla guiaRemision
	*/
	public final static String XPATH_INFO_TRIBUTARIA_GR = MessagesApplication
	.getInstancia().getString("com.corvustec.facee.files.xpath.guiaRemision.infoTributaria");
	
	/*
	* xpath infoNotaDebito plantilla notaDebito
	*/
	public final static String XPATH_INFO_GUIAREMISION= MessagesApplication
	.getInstancia().getString("com.corvustec.facee.files.xpath.guiaRemision.infoGuiaRemision");
	
	/**
	* xpath impuesto plantilla guiaRemision
	*/
	public final static String XPATH_DESTINATARIOS = MessagesApplication
	.getInstancia().getString("com.corvustec.facee.files.xpath.guiaRemision.destinatarios");
	
	
	public final static String XPATH_DETALLE_GUIA = MessagesApplication
	.getInstancia().getString("com.corvustec.facee.files.xpath.guiaRemision.detalleGuia");
	/**
	* xpath motivos plantilla guiaRemision
	*/
	//public final static String XPATH_INFOADICIONAL= MessagesApplication
	//.getInstancia().getString("com.corvustec.facee.files.xpath.guiaRemision.infoAdicional");
	
	
	
	//////////////////////////////Guia Remision/////////////////////
	
	/**
	* indentificador de la linea infoTributaria en el archivo txt de la guiaRemision
	*/
	public final static String IDENTIFICADOR_INFO_TRIBUTARIA_GR = MessagesApplication
	.getInstancia().getString("com.corvustec.facee.files.guiaRemision.identificador.infoTributaria");
	
	/**
	* indentificador de la linea infoGuiaRemision en el archivo txt de la guiaRemision
	*/
	public final static String IDENTIFICADOR_INFO_GUIAREMISION= MessagesApplication
	.getInstancia().getString("com.corvustec.facee.files.guiaRemision.identificador.infoGuiaRemision");
	
	/**
	* indentificador de la linea destinatarios en el archivo txt de la guiaRemision
	*/
	public final static String IDENTIFICADOR_DESTINATARIOS= MessagesApplication
	.getInstancia().getString("com.corvustec.facee.files.guiaRemision.identificador.destinatarios");
	
	
	public final static String IDENTIFICADOR_DETALLE_GUIA= MessagesApplication
	.getInstancia().getString("com.corvustec.facee.files.guiaRemision.identificador.detalleGuia");
	/**
	* indentificador de la linea infoAdicional en el archivo txt de la guiaRemision
	*/
	//public final static String IDENTIFICADOR_INFOADICIONAL = MessagesApplication
	//.getInstancia().getString("com.corvustec.facee.files.guiaRemision.identificador.infoAdicional");
	
		
	
	public final static String carpetaPorProcesar = MessagesApplication.getInstancia().getString("com.corvustec.facee.files.nombreCarpeta.porProcesar");
	public final static String carpetaProcesados = MessagesApplication.getInstancia().getString("com.corvustec.facee.files.nombreCarpeta.procesados");
	public final static String capertaPendientes = MessagesApplication.getInstancia().getString("com.corvustec.facee.files.nombreCarpeta.pendientes");
	public final static String carpertaXml = MessagesApplication.getInstancia().getString("com.corvustec.facee.files.nombreCarpeta.xml");
	
}
