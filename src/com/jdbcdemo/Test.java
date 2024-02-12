package com.jdbcdemo;

import java.sql.*;
import java.sql.DriverManager;

public class Test {
	public static void main(String[]args)throws Exception {
		
		String url="jdbc:mysql://localhost:3306/jdbcdemo";
		String username="root";
		String password="yamu@22";
		String sql="select*from employee";
//		establishes to the connection using for drivermanager class and getconnection().
		Connection con=DriverManager.getConnection(url,username,password);
		
//		statement object used for execute query
		Statement st=con.createStatement();
//		its return for the resultset
		ResultSet rs =st.executeQuery(sql);
		
//		rs.next() means move to the next step
		while(rs.next()) {
		System.out.println("id is:"+rs.getInt(1));
		System.out.println("name is:"+rs.getString(2));
		System.out.println("salary is:"+rs.getInt(3));
		}
		con.close();
		
		
		
		
		
		
	}

}
