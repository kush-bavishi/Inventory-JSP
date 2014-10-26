package com.kush.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.kush.model.entity.User;

public class LoginCRUD {
	
	private PreparedStatement logStmt = null;
	private PreparedStatement regStmt = null;
	Connection conn = null;

	public LoginCRUD() {
		conn = new ConnectionDAO().doConnect();
		if (conn != null) {
			try {
				logStmt = conn
						.prepareStatement("select Role from Users where Email=? and Password=?");
				regStmt = conn.prepareStatement("insert into Users values(?,?,?,?,?)");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public String checkLogin(String user, String password) {
		String role = null;
		if (logStmt != null) {
			try {
				logStmt.setString(1, user);
				logStmt.setString(2, password);
				ResultSet rows = logStmt.executeQuery();
				while (rows.next())
					role = rows.getString(1);

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return role;
	}
	
	public int registerUser(User user) throws SQLException
	{
		int result = 0;
		if(regStmt != null)
		{
			try
			{
				//System.out.println("Etnered try");
				regStmt.setString(1, user.getEmail());
				//System.out.println("email");
				regStmt.setString(2, user.getPass());
				//System.out.println("pass");
				regStmt.setString(3, user.getRole());
				//System.out.println("role");
				regStmt.setString(4, user.getPhone());
				//System.out.println("phone");
				regStmt.setString(5, user.getAddr());
				//System.out.println("addr");
				result = regStmt.executeUpdate();
				//System.out.println("executeupdate");
				conn.commit();
				regStmt.close();
				conn.close();
			}
			catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				conn.rollback();
				conn.close();
			}
		}
		return result;
	}

}