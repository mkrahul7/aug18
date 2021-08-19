package com.p1;

import java.sql.*;

public class E implements F {
	private Connection con;
	private Statement st;
	@Override
	public void dconnection() {
		try {
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/rah","root","test");
			st=con.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void statement(String name, String city, String mobile) {
		try {
			st.executeUpdate(" insert into mani values(null,'"+name+"','"+city+"','"+mobile+"')");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}}


