package com.utility;

import java.sql.Connection;
import java.sql.DriverManager;


public class DBUtility {
	
public static Connection getDBConnection()
{
	Connection con=null;
	try
	{
Class.forName("com.mysql.cj.jdbc.Driver");
  con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc","root","Pass@123");
	}catch (Exception e) {
System.out.println("Exception Occured in DBUitity"+e);
	}
	
	return con;
}


	}

