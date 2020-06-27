package com.dxc.feesManagement;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

class MyStudentClass<T> 
{
	
	T obj;

	void create(T obj) 
	{ 
		this.obj = obj;
	}

	T getInstance() 
	{ 
		return obj;
	}
}

public class FeesReport 
{
	InputStreamReader isr = null;
	BufferedReader buff = null;
	
	Admin mAdmin = null;
	Accountant mAccountant = null;
	
	boolean data=true;
	 String userchoice;
	
	public static void main(String[] args) throws IOException, SQLException 
	
	{
		try
		{
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/fees","root","Prasanna@1409");
			
		FeesReport mObject=new FeesReport();
		
		mObject.isr=new InputStreamReader(System.in);
		mObject.buff = new BufferedReader(mObject.isr);

		do {
			
			System.out.println("Welcome to FeesManagement\n");
			System.out.println("\n1. Admin\n2. Accountant");
			String mBankChoice = mObject.buff.readLine();
			
			String mOperationChoice, continueChoice;
			boolean opening = true;

			switch (Integer.parseInt(mBankChoice)) 
			{
			case 1:
				MyStudentClass<Admin> obj = new MyStudentClass<Admin>();
				obj.create(new Admin());
				mObject.mAdmin = obj.getInstance();
				
				
				mObject.mAdmin.login(mObject.buff);
				do {
					System.out.println("select your Operation:\n1.Add Account \n2.ViewAccount");
					mOperationChoice = mObject.buff.readLine();
					switch (Integer.parseInt(mOperationChoice)) 
					{
					case 1:
						mObject.mAdmin.addAccountant(mObject.buff);
						break;
					case 2:
						mObject.mAdmin.viewAccountant();
						break;

					case 3: mObject.mAdmin.logout(mObject.buff);
					break;
					default:
						System.out.println("task is not performed");
					
					}
					System.out.println("Do you Want to Continue\nYes\nNo");
					continueChoice = mObject.buff.readLine();
					
					if (continueChoice.equalsIgnoreCase("No"))
						opening = false;
					}while(opening);
					break;
			case 2:
				MyStudentClass<Accountant> obj1 = new MyStudentClass<Accountant>();
				obj1.create(new Accountant());
				mObject.mAccountant = obj1.getInstance();
				do {
					System.out.println("select your Operation:\n1.AddStudent \n2.View student \n3.Edit Student \n4.DueFees");
					mOperationChoice = mObject.buff.readLine();
					switch (Integer.parseInt(mOperationChoice)) 
					{
					case 1:
						mObject.mAccountant.addStudent(mObject.buff);
						break;
					case 2:
						mObject.mAccountant.viewStudent();
						break;
					case 3:
							mObject.mAccountant.editStudent(mObject.buff);
							break;
					case 4:
							mObject.mAccountant.dueFees(mObject.buff);
							break;
					default: System.out.println("task not completed");
				}
					System.out.println("Do you Want to Continue\nYes\nNo");
				continueChoice = mObject.buff.readLine();
				if (continueChoice.equalsIgnoreCase("No"))
					opening = false;
				}while(opening);
				break;
			default: System.out.println("select atleast one task\n");
			}System.out.println("Do you Want to End feemanagement\nYes\nNo");
			 mObject.userchoice = mObject.buff.readLine();
			if (mObject.userchoice.equalsIgnoreCase("yes"))
				opening = false;
		
	}while(mObject.data);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	
}
}

