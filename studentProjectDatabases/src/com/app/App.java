package com.app;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.dao.StudentDAO;
import com.model.student;

public class App {

	public static void main(String[] args){
		Scanner ob1=new Scanner(System.in);
		int val=0;
		do {
		System.out.println("1.Add Record");
		System.out.println("2.delete Record");
		System.out.println("3.Update Record");
		System.out.println("4. Read All Record");
		
		System.out.println("enter the Your choice");
		int choice=ob1.nextInt();
		
		
		
	 
	  
StudentDAO dao=new StudentDAO();
	
		switch(choice)
		{
		case 1:
			System.out.println("Enter the id");
			int id=ob1.nextInt();
			
		System.out.println("Enter the name");
		 ob1.nextLine();
		String name=ob1.nextLine();
	 
		
		System.out.println("Enter the Marks");
		double marks=ob1.nextDouble();
		
		student s1=new student(id,name,marks);
		int i=dao.saveStudent(s1);
		if(i>0)
			System.out.println("insert Record complted");
		else System.out.println("fail the insert Record");
			break;
			
		case 2:
			System.out.println("Enter the student id");
			int d1=ob1.nextInt();
			student s2=new student();
			s2.setId(d1);
			int dRecord=dao.deleteStudent(s2);
			if(dRecord>0)
				System.out.println("Record Delete");
			else System.out.println("Record not deleted");
			break;
			
			
			
		case 3:
			System.out.println("Enter the id");
			int idD=ob1.nextInt();
			
		System.out.println("Enter the name");
		 ob1.nextLine();
		String nameD=ob1.nextLine();
	 
		
		System.out.println("Enter the Marks");
		double marksD=ob1.nextDouble();
		
		student sU=new student();
		sU.setId(idD);
		sU.setMarks(marksD);
		sU.setName(nameD);
		dao.UpdateStudent(sU);
		
		break;
			
		
			
		case 4:
			ResultSet rs=dao.selectStudent();
			
		System.out.println("ID  Name  Marks");
		System.out.println("____________________");
		try {
		while(rs.next())
		{
			System.out.print(rs.getInt(1)+"  ");
			System.out.print(rs.getString(2)+"  ");
			System.out.println(rs.getDouble(3)+"  ");	
			
		}
		}catch (Exception e) {
			System.out.println(" Exception Ocuurces in Read All Record"+e);
		}
		break;
			
			
	default:
	System.out.println("please correct choice inputn");
    break;
		}
		System.out.println("Do You Want to Continue Press 1");
		val=ob1.nextInt(); 
		}while(val==1);
		
			
	

	}

}
