package com.dxc.feesManagement;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Admin 
{
	public void login(BufferedReader buff) throws SQLException 
	{
		String query1="Select AdminID from fees.AdminLogin where AdminID=?";
		String query2="Select password from fees.AdminLogin where password=?";
		try 
		{
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/fees.adminlogin","root","Prasanna@1409");
			PreparedStatement ps1=con.prepareStatement(query1);
		   System.out.println("enter AdminId");
			String adminID=buff.readLine();
			ps1.setString(1, adminID);
			ResultSet rs1=ps1.executeQuery();
			if(rs1.next())
			{
				PreparedStatement ps2=con.prepareStatement(query2);
				System.out.println("enter password");
				String pswrd=buff.readLine();
				ps2.setString(1, pswrd);
				ResultSet rs2=ps2.executeQuery();
				if(rs2.next())
				{
					System.out.println("Succesfully loggedin");
				}
				else
				{
					System.out.println("invalid password");
				}
			}
				else
				{
					System.out.println("invalid id");
				}
				
			
		}
		catch (IOException e) 
		{
			
			e.printStackTrace();
		}
	}
	public void addAccountant(BufferedReader buff)
	{
		try
		{
			
		
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/fees.accountantdetails","root", "Prasanna@1409");
			
			PreparedStatement stmtInsert = con.prepareStatement("insert into accountant values(?,?,?,?)");
			System.out.println("enter the name");
			stmtInsert.setString(1, buff.readLine());
			System.out.println("enter the password");
			stmtInsert.setString(2, buff.readLine());
			System.out.println("enter the email");
			stmtInsert.setString(3, buff.readLine());
			System.out.println("enter the contact_number");
			stmtInsert.setString(4, buff.readLine());

			System.out.println(stmtInsert.executeUpdate() + " No of Records Inserted");

		
		}
		catch(Exception e)
		{
			System.out.println("exception is:"+e);
		}
		
	}
	public void viewAccountant() throws SQLException
	{
      Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/fees.accountantdetails", "root", "Prasanna@1409");
		
		Statement stmt=con.createStatement();
		ResultSet rs=stmt.executeQuery("select * from accountant");
		while(rs.next())
			System.out.println(rs.getString(1)+ " " +rs.getString(2)+ " " +rs.getString(3)+ " "+rs.getString(4));
		con.close();
		
	}
	public void logout(BufferedReader buff) throws IOException
	{
		String continueChoice;
		boolean transaction=true;
		System.out.println("Do you Want to logout\nYes \nNo");
		continueChoice =buff.readLine();
		if(continueChoice.equalsIgnoreCase("Yes"))
			transaction=false;
	}
	

}

