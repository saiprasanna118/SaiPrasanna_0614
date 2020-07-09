package com.dxc.jdbc;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ViewEmployee
 */
@WebServlet("/ViewEmployee")
public class ViewEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewEmployee() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		List<Employee> mList=new ArrayList<Employee>();
		try 
		{
			mList =EmployeeDAO.getAllEmployees();
			PrintWriter pw=response.getWriter();
			
			pw.println("<html><body>>table><tr>");
			pw.print("<th>ID</th><th>Name</th><th>Email</th><th>Password</th><th>Country</th>");
			
			for(Employee mEmployee: mList)
			{
				pw.print("<tr>");
				pw.println("<td>"+mEmployee.getName()+"</td>");
			}
			pw.print("</table></body></html>");
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
