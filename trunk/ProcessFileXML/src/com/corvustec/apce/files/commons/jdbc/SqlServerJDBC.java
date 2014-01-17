package com.corvustec.apce.files.commons.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SqlServerJDBC {

	
	private final static Logger logger = LoggerFactory.getLogger(SqlServerJDBC.class);
	
	private static Connection conn;
	
	private static SqlServerJDBC instance;
	
	public SqlServerJDBC() {
	    try {
	    	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	        String connectionUrl = "jdbc:sqlserver://localhost;databaseName=electronic";//user=sa;password=desarrollo123,.;";    	
			conn = DriverManager.getConnection(connectionUrl,"sa","desarrollo123,.");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			logger.info("Error SQLException {}",e.toString());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			logger.info("Error ClassNotFoundException {}",e.toString());
		}

	}
	
	
	public static SqlServerJDBC getInstance()
	{
		if(instance==null)
			instance=new SqlServerJDBC();
		return instance;
	}
	
	public void execute(String sql)
	{
		PreparedStatement preparedStatement;
		try {
			preparedStatement = conn.prepareCall(sql);
			preparedStatement.execute();
			preparedStatement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			logger.info("Error SQLException {}",e.toString());
		}
		
		
	}
	
}
