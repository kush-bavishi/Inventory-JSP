package com.kush.model.dao;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDAO
{
	public Connection doConnect()
	{
		Connection conn=null;
		try
		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			File file = new File("D:\\Java\\J2EE Project.accdb");
			String db = "JDBC:ODBC:Driver=Microsoft Access Driver (*.mdb, *.accdb); DBQ=" + file.getAbsolutePath();
			conn=DriverManager.getConnection(db);
		} catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		catch(SQLException se)
		{
			se.printStackTrace();
		}
		return conn;
	}
}
