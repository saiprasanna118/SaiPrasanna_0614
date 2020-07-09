package com.dxc.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO 
{
	
	public static Connection getConnection() throws Exception
	{   
		Connection con = null;
		Class.forName("com.mysql.jdbc.Driver");
		
			if(con==null)
			
				return con=DriverManager.getConnection("jdbc:mysql://localhost:3306/emp","root","Prasanna@1409");
			else
				return con;
		
	}
	public static int saveEmployee(Employee mEmp) throws Exception
	{
		int status=0;
		Connection con=EmployeeDAO.getConnection();
		PreparedStatement ps=con.prepareStatement("insert into employee values(?,?,?,?)");
		ps.setString(1,mEmp.getName());
		ps.setString(3, mEmp.getPassword());
		ps.setString(4,mEmp.getCountry());
		ps.setString(2,mEmp.getEmail());	
		status=ps.executeUpdate();
		System.out.println("Successfully inserted");
		ps.close();
		return status;
		
	}
	
	public static List<Employee> getAllEmployees() throws Exception 
	{
		List<Employee> mList = new ArrayList<Employee>();
		Connection con = EmployeeDAO.getConnection();
		
		return mList;
	}
	
}