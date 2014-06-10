package com.corvustec.rtoqab.process.jdbc;



public class ConnectionJDBC {

//	private static Connection con;
//	
//	public static void init()
//	{
//		con=getConnection();
//	}
//
//	public static void close()
//	{
//		try {
//			con.close();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//
//
//	public static Connection getConnection()
//	{
//		String url = ReadConfiguration.readValue("com.corvustec.rtoqab.jdbc.connection.url");
//
//		Properties props = new Properties();
//		props.setProperty("user",ReadConfiguration.readValue("com.corvustec.rtoqab.jdbc.connection.user"));
//		props.setProperty("password",ReadConfiguration.readValue("com.corvustec.rtoqab.jdbc.connection.pass"));
//		//props.setProperty("allowEncodingChanges","true");
//				
//		Connection con = null;
//		
//		try {		
//			if(ReadConfiguration.readValue("com.corvustec.rtoqab.jdbc.database").equals("1"))
//			{
//				Class.forName(ReadConfiguration.readValue("com.corvustec.rtoqab.jdbc.connection.class"));
//				con=DriverManager.getConnection(url, props);				
//			}
//		} catch (ClassNotFoundException | MissingResourceException e) {
//			e.printStackTrace();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return con;
//	}
//	
//	public static void executeSql(String sql) throws SQLException
//	{
//		PreparedStatement preparedStatement;
//
//		preparedStatement = con.prepareCall(sql);
//		preparedStatement.execute();
//		preparedStatement.close();
//	}	
//	
//	public static ResultSet executeSelect(String sql) throws SQLException
//	{
//		ResultSet resultSet=null;
//		Statement statement;
//		statement = ConnectionJDBC.getConnection().createStatement();
//		resultSet= statement.executeQuery(sql);
//		//statement.close();
//		return resultSet;
//	}	
	
}
