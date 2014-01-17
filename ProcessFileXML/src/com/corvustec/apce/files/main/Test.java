package com.corvustec.apce.files.main;

import com.corvustec.apce.files.commons.jdbc.SqlServerJDBC;

public class Test {

	
	public static void main(String[] args)
	{
		SqlServerJDBC sqlServer=SqlServerJDBC.getInstance();
		sqlServer.execute("insert into flujo (archivo,clave,recibido,autorizado) values('<a></a>','1111',1)");
	}
	
}
