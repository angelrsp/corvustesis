package com.corvustec.process.excel.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.MissingResourceException;
import java.util.Properties;

import com.corvustec.process.excel.util.MessagesApplicacion;

public class ConnectionJDBC {

	
	public static Connection getConnection()
	{
		String url = MessagesApplicacion.getString("com.corvustec.connection.url");

		Properties props = new Properties();
		props.setProperty("user",MessagesApplicacion.getString("com.corvustec.connection.user"));
		props.setProperty("password",MessagesApplicacion.getString("com.corvustec.connection.pass"));
		props.setProperty("allowEncodingChanges","true");
				
		
		Connection con = null;
		
		try {		
			if(MessagesApplicacion.getInteger("com.corvustec.connection.database")==1)
			{
				Class.forName(MessagesApplicacion.getString("com.corvustec.connection.class"));
				con=DriverManager.getConnection(url, props);				
			}
		} catch (ClassNotFoundException | MissingResourceException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
	
	public static void executeSql(String sql) throws SQLException
	{
		PreparedStatement preparedStatement;

		preparedStatement = ConnectionJDBC.getConnection().prepareCall(sql);
		preparedStatement.execute();
		preparedStatement.close();
	}	
	
	public static ResultSet executeSelect(String sql) throws SQLException
	{
		ResultSet resultSet=null;
		Statement statement;
		statement = ConnectionJDBC.getConnection().createStatement();
		resultSet= statement.executeQuery(sql);
		//statement.close();
		return resultSet;
	}	
	
}
