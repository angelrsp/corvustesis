package com.corvustec.rtoqab.process.util;

public class Const {

	
	public static final String CODIGO_AGENCIA = ReadConfiguration.readValue("com.corvustec.rtoqab.codigo.agencia");
	
	public static final String PATH_RECOLECTOR = ReadConfiguration.readValue("com.corvustec.rtoqab.path.in");
	
	public static final String PATH_PROCESADO = ReadConfiguration.readValue("com.corvustec.rtoqab.path.process");
	
	public static final String PATH_FINAL = ReadConfiguration.readValue("com.corvustec.rtoqab.path.out");
	
	public static final String BALIZA1 = ReadConfiguration.readValue("com.corvustec.rtoqab.baliza1");
	
	public static final String BALIZA2 = ReadConfiguration.readValue("com.corvustec.rtoqab.baliza2");
	
	public static final String BALIZA3 = ReadConfiguration.readValue("com.corvustec.rtoqab.baliza3");
	
	public static final String BALIZA4 = ReadConfiguration.readValue("com.corvustec.rtoqab.baliza4");
	
	public static final String PATH_EJECUTABLE = ReadConfiguration.readValue("com.corvustec.rtoqab.path.exe");
	
	public static final String MINUTO_COMPROBACION = ReadConfiguration.readValue("com.corvustec.rtoqab.minuto.comprobacion");
	
	public static final String FACTOR_AJUSTE = ReadConfiguration.readValue("com.corvustec.rtoqab.factor.ajuste");
	
	public static final String FACTOR_MAXIMO = ReadConfiguration.readValue("com.corvustec.rtoqab.factor.maximo");
	
	public static final String FACTOR_PROMEDIO_DIA = ReadConfiguration.readValue("com.corvustec.rtoqab.factor.promedio.dia");
	
	public static final String FACTOR_INTERVALO3 = ReadConfiguration.readValue("com.corvustec.rtoqab.factor.intervalo.3");
}
