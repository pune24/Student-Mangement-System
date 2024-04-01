package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.model.student;
import com.utility.DBUtility;

public class StudentDAO {

	public int saveStudent(student student) {
PreparedStatement ps=null;
int val=0;
Connection con=DBUtility.getDBConnection();
String sql="insert into student values(?,?,?)";
try
{
	ps=con.prepareStatement(sql);
	ps.setInt(1,student.getId());
	ps.setString(2,student.getName());
	ps.setDouble(3,student.getMarks());
	 val=ps.executeUpdate();
}catch(Exception e)
{
	System.out.println("Exception in save Student  " + e);
}

return val;

	}
	
public int deleteStudent(student student)
{
	PreparedStatement ps=null;
	 Connection con=DBUtility.getDBConnection();
	 int val=0;
	 String sql="delete from student where id=?";
	 try
		{
			 ps=con.prepareStatement(sql);
			 
			 ps.setInt(1, student.getId());
			
			 val=ps.executeUpdate();
			 
		}
			catch(Exception e)
			{
				System.out.println("Exception occured in deleteStudent  student"+e);
			}
			return val;
	 }


public int UpdateStudent(student student)
{
	 Connection con=DBUtility.getDBConnection();
	 int i=0;
	 String sql="update student set name=? , marks=? where id=?";
	 try
		{
		   PreparedStatement ps=con.prepareStatement(sql);
		   
			ps.setString(1,student.getName()+" ");
			ps.setDouble(2,student.getMarks());
			ps.setInt(3, student.getId());

			 i = ps.executeUpdate();
			

			if (i > 0) {
				System.out.println("Record UPDATE");
			} else {
				System.out.println("Failed To UPDATE");
			}
			 
		}
			catch(Exception e)
			{
				System.out.println("Exception occured in UpdateStudent  student"+e);
			}
			return i;
	
}


public ResultSet selectStudent()
{
	 PreparedStatement ps=null;	
	
		
		Connection con=DBUtility.getDBConnection();
		String sql="select * from student";
		java.sql.ResultSet rs = null;
		try
		{
			ps=con.prepareStatement(sql);
			
			rs=ps.executeQuery();
		}
		catch (Exception e) {
			System.out.println("Exception ocuured in Select Records"+e);
		}
		
		return rs;
}
	 





}
