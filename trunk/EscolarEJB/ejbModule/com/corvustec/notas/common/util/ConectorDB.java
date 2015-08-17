package com.corvustec.notas.common.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;


public class ConectorDB {

	
	private static Connection conn;
	
	private static ConectorDB instance;
	
	
	public ConectorDB() {
	    //try {
	    	//Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//	    	Class.forName(conectorDTO.getClassName());
//	        String connectionUrl = conectorDTO.getUrlDb();//user=sa;password=desarrollo123,.;";   
		
//			System.out.println("Base de Datos Conectado");
//		} catch (SQLException e) {
//			System.out.println("Error DBException " +e.toString());
//		} catch (ClassNotFoundException e) {
//			System.out.println("Error ClassNotFoundException "+e.toString());
//		}

	}
	
	
	public static ConectorDB getInstance()
	{
		if(instance==null)
			instance=new ConectorDB();
		return instance;
	}
	
	public void execute(String sql)
	{
		Statement stmt;
		Context initialContext;
		try {
			initialContext = new InitialContext();
			DataSource datasource = (DataSource)initialContext.lookup("java:/mySQLConsolidadorDS");
			conn = datasource.getConnection();			
		    stmt = conn.createStatement() ;
		    stmt.execute(sql) ;
			System.out.println("Query Executado");
		} catch (SQLException e) {
			System.out.println("Error SQLException "+e.toString());
			System.out.println("Query "+sql);
		} catch (NamingException e) {
			System.out.println("Error NamingException "+e.toString());
			System.out.println("Query "+sql);
		}
	}
	
	public Boolean exists(String sql)
	{
		Statement statement=null;
		Boolean flag = null;
		try {
			statement=conn.createStatement();
			ResultSet rs=statement.executeQuery(sql);

			flag = rs.isBeforeFirst();
		} catch (SQLException e) {
			System.out.println("Error SQLException "+e.toString());
			System.out.println("Query "+sql);
		}
		return flag;
	}
	
	public ResultSet executeQuery(String sql)
	{
		Statement statement=null;
		ResultSet rs = null;
		try {
			statement=conn.createStatement();
			rs=statement.executeQuery(sql);
		} catch (SQLException e) {
			System.out.println("Error SQLException "+e.toString());
			System.out.println("Query "+sql);
		}
		return rs;
	}
	
}
