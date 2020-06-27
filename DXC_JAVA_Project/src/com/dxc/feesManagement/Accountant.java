package com.dxc.feesManagement;



import java.io.BufferedReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Accountant 
{
	public void addStudent(BufferedReader buff)
	{
		try
		{
		
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/fees.studentdetails","root", "Prasanna@1409");
				PreparedStatement stmtInsert = con.prepareStatement("insert into studentdetails values(?,?,?,?,?,?,?,?,?,?,?)");
				System.out.println("enter the name");
				stmtInsert.setString(1, buff.readLine());
				System.out.println("enter the email");
				stmtInsert.setString(2, buff.readLine());
				System.out.println("enter the course");
				stmtInsert.setString(3, buff.readLine());
				System.out.println("enter the fee");
				stmtInsert.setString(4, buff.readLine());
				System.out.println("enter the paid");
				stmtInsert.setString(5, buff.readLine());
				System.out.println("enter the due");
				stmtInsert.setString(6, buff.readLine());
				System.out.println("enter the address");
				stmtInsert.setString(7, buff.readLine());
				System.out.println("enter the city");
				stmtInsert.setString(8, buff.readLine());
				System.out.println("enter the state");
				stmtInsert.setString(9, buff.readLine());
				System.out.println("enter the country");
				stmtInsert.setString(10, buff.readLine());
				System.out.println("enter the contactno");
				stmtInsert.setString(11, buff.readLine());

				System.out.println(stmtInsert.executeUpdate() + " No of Records Inserted");
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
				
		
	}
	public void viewStudent() throws SQLException
	{
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/fees.studentdetails","root", "Prasanna@1409");
		Statement stmt=con.createStatement();
		
		ResultSet rs=stmt.executeQuery("select * from studentdetails");
		while(rs.next())
		{
			String stid=rs.getString("StudentID");
		    String stname=rs.getString("StudentName");
		    String stemail=rs.getString("StudentEmail");
		    String stadress=rs.getString("StAdress");
		    int  fees=rs.getInt("StFees");
		    int paid=rs.getInt("StPaid");
		    int stdues=rs.getInt("StDue");
		    System.out.println("\nStudentID:"+stid+"\nStudent Name:"+stname+"\nStudEmail:"+stemail+"\nStAdress:"+stadress+"\nfees:"+fees+"\nPaid:"+paid+"\nStDue"+stdues);
		}
		con.close();
	}
	public void editStudent(BufferedReader buff) throws SQLException
	{
		String query="update fee.StudentDetails set StFees=? where StudentID=?";
		try
		{
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/fees.studendetails","root", "Prasanna@1409");
		Statement stmt=con.createStatement();
		PreparedStatement stmtUpdate = con.prepareStatement(query);
	
			stmtUpdate.setString(1, buff.readLine());
		stmtUpdate.setString(2, buff.readLine());
		stmtUpdate.setString(3, buff.readLine());
		stmtUpdate.setString(4, buff.readLine());
		stmtUpdate.setString(5, buff.readLine());
		stmtUpdate.setString(6, buff.readLine());
		stmtUpdate.setString(7, buff.readLine());
		stmtUpdate.setString(8, buff.readLine());
		stmtUpdate.setString(9, buff.readLine());
		stmtUpdate.setString(10, buff.readLine());
		stmtUpdate.setString(11, buff.readLine());
		}
		catch (SQLException | IOException e) 
		{
			
			e.printStackTrace();
		}
	}
	public void dueFees(BufferedReader buff) throws SQLException
	{
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/fee.StudentDetails","root", "Prasanna@1409");
		Statement stmt=con.createStatement();
		ResultSet rs=stmt.executeQuery("select StDue from StudentDetails");
		while(rs.next())
		{
			String stid=rs.getString("StudentID");
			String stname=rs.getString("StudentName");
			int stdues=rs.getInt("StDue");
			System.out.println("\nStudentID:"+stid+"\nStudent Name:"+stname+"\nStuDues"+stdues);
		}
			
		con.close();
		
	}
}

