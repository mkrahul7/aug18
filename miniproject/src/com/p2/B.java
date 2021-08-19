package com.p2;

import java.sql.*;

public class B implements C{
private Connection con;
private Statement st;
	@Override
	public void connect() {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/roc","root","test");
			st=con.createStatement();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public boolean verify(String name, String mob) {
		try {
			ResultSet e = st.executeQuery("select * from rocs where nama='"+name+"' and '"+mob+"' ");
			return e.next();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}
