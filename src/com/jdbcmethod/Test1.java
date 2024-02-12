package com.jdbcmethod;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Test1 {
	public static void main(String[]args) throws Exception {
		
//		readrecords();
//		insertRecord();
//		insertVar();
//		insertpreparest();
//		delete();
		update();
		
			
	}
//	simple read from db and display results
	
	public static void readrecords() throws Exception{
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
	
//	this is insertquery or record.
	
	public static void insertRecord()throws Exception{
		
	String url="jdbc:mysql://localhost:3306/jdbcdemo";
	String username="root";
	String password="yamu@22";
	String sql="insert into employee values(4,'siddharth',50000),(5,'surya',100000)";
//	establishes to the connection using for drivermanager class and getconnection().
	Connection con=DriverManager.getConnection(url,username,password);
	
//	statement object used for execute query
	Statement st=con.createStatement();
//	its return for the resultset
	int rows =st.executeUpdate(sql);
	System.out.println("number of rows affected:"+rows);
	
	con.close();
	
	}
	
//	insert using variable
	
	public static void insertVar()throws Exception{
		
		String url="jdbc:mysql://localhost:3306/jdbcdemo";
		String username="root";
		String password="yamu@22";
		int  id=6;
		String name="sumathi";
		int salary=60000;
//		"insert into employee values(4,'siddharth',50000),(5,'surya',100000)";
		String sql="insert into employee values("+id+",'"+name+"',"+salary+");";
		Connection con=DriverManager.getConnection(url,username,password);
		Statement st=con.createStatement();
		int rows =st.executeUpdate(sql);
		System.out.println("number of rows affected:"+rows);
		
		con.close();
		
		}
	
//	insert with preparedstatement
	
public static void insertpreparest()throws Exception{
		
		String url="jdbc:mysql://localhost:3306/jdbcdemo";
		String username="root";
		String password="yamu@22";
		int  id=8;
		String name="raja";
		int salary=80000;
//		"insert into employee values(4,'siddharth',50000),(5,'surya',100000)";
		String sql="insert into employee values(?,?,?);";
		Connection con=DriverManager.getConnection(url,username,password);
		PreparedStatement pst=con.prepareStatement(sql);
		pst.setInt(1,id);
		pst.setString(2,name);
		pst.setInt(3, salary);
		int rows =pst.executeUpdate();
		System.out.println("number of rows affected:"+rows);
		
		con.close();
		
		}
//delete the record

public static void delete()throws Exception{
	
	String url="jdbc:mysql://localhost:3306/jdbcdemo";
	String username="root";
	String password="yamu@22";
	int  id=6;
//	delete the  record from id=6;
	String sql="delete from employee where emp_id="+id;
	Connection con=DriverManager.getConnection(url,username,password);
	Statement st=con.createStatement();
	int rows =st.executeUpdate(sql);
	System.out.println("number of rows affected:"+rows);
	
	con.close();
	
	}

// update
public static void update()throws Exception{
	
	String url="jdbc:mysql://localhost:3306/jdbcdemo";
	String username="root";
	String password="yamu@22";
	
	String sql="update employee set salary =150000 where emp_id=1";
	Connection con=DriverManager.getConnection(url,username,password);
	Statement st=con.createStatement();
	int rows =st.executeUpdate(sql);
	System.out.println("number of rows affected:"+rows);
	
	con.close();
	
	}

		

}
