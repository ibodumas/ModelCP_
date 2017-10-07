package jquery.datatables.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

public class EmployeeRepository 
{
	private static List<Employee> EmployeesData = null;

	//private static CustomersDetails CustomersDetailsData = null;
	public static List<Employee> GetEmployees() 
	{
		try
		{
			EmployeesData = new LinkedList<Employee>();
			String dataSource = "jdbc:mysql://localhost:3306/classicmodels";
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(dataSource, "satAD", "test123");
			Statement st = conn.createStatement();
			ResultSet rec = st.executeQuery("select * from Employees order by employeeNumber asc");
			while (rec.next()) 
			{
				Employee addEmployees = new Employee(rec.getInt("employeeNumber"), 
														rec.getString("lastName"),
														rec.getString("firstName"),
														rec.getString("extension"),
														rec.getString("email"),
														rec.getString("officeCode"),
														rec.getInt("reportsTo"),
														rec.getString("jobTitle"));
				
				EmployeesData.add(addEmployees); // Add an Employee member
			}
		} 
		catch (Exception e) 
		{
			System.out.println("Error -- EmployeesRepository " + e.toString());
		}
		
		return EmployeesData;
	}

	public static Employee GetEmployeeDetails(int key) 
	{
		Employee EmployeesDetailsData = null;

		try 
		{
			String dataSource = "jdbc:mysql://localhost:3306/classicmodels";
			Class.forName("com.mysql.jdbc.Driver"); // com.mysql.jdbc.Driver
			Connection conn = DriverManager.getConnection(dataSource, "satAD", "test123");
			Statement st = conn.createStatement();
			System.out.println("before query");

			ResultSet rec = st.executeQuery("select * from employees where employeeNumber= " + key);
			System.out.println("after query");
			
			if (rec.next()) 
			{
				EmployeesDetailsData = new Employee(rec.getInt("employeeNumber"),
													rec.getString("lastName"), rec.getString("firstName"),
													rec.getString("extension"), rec.getString("email"),
													rec.getString("officeCode"), rec.getInt("reportsTo"),
													rec.getString("jobTitle"));
			} 
			else 
			{
				EmployeesDetailsData = new Employee(key, "", "Employee number not found", "", "", "", 0, "");
			}
		} 
		catch (Exception e) 
		{
			System.out.println("Error -- EmployeesRepository " + e.toString());
		}
		
		return EmployeesDetailsData;
	}
}

