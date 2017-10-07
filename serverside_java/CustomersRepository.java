package jquery.datatables.model;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import java.util.LinkedList;
import java.util.List;

public class CustomersRepository {

	private static List<Customers> CustomersData = null;

//	private static CustomersDetails CustomersDetailsData = null;

	public static List<Customers> GetCustomers() {
		if (CustomersData == null) {
			try {
				CustomersData = new LinkedList<Customers>();
				String dataSource = "jdbc:mysql://localhost:3306/clasicmmodels";
				Class.forName("com.mysql.jdbc.Driver");
				Connection conn = DriverManager.getConnection(dataSource,
						"satAD", "test123");
				Statement st = conn.createStatement();
				ResultSet rec = st
						.executeQuery("select * from Customers order by customerNumber asc");
				while (rec.next()) {
					Customers addCustomers = new Customers(
							rec.getInt("customerNumber"), 
							rec.getString("customerName"),
							rec.getString("contactLastName"),
							rec.getString("contactFirstName"),
							rec.getString("phone"),
							rec.getString("addressLine1"),

							rec.getString("addressLine2"),
							rec.getString("city"),
							rec.getString("state"),
							rec.getString("postalCode"),
							rec.getString("country"),
							rec.getInt("salesRepEmployeeNumber"), 
							rec.getDouble("creditLimit"));
					CustomersData.add(addCustomers); // Add a Customer member
				}
			} catch (Exception e) {
				System.out.println("Error -- PatientsRepository "
						+ e.toString());
			}
		}
		return CustomersData;
	}

	public static CustomersDetails GetCustomersDetails(int key) {

		 CustomersDetails CustomersDetailsData = null;

		try {
		
			String dataSource = "jdbc:mysql://localhost:3306/classicmodels";

			Class.forName("com.mysql.jdbc.Driver"); // com.mysql.jdbc.Driver

			Connection conn = DriverManager.getConnection(dataSource, "satAD",
					"test123");
			Statement st = conn.createStatement();
			System.out.println("before query");

			ResultSet rec = st
					.executeQuery("select * from customers a left outer join employees As b on a.salesRepEmployeeNumber =b.employeeNumber" +
" left outer join offices As c on b.officeCode = c.officeCode where a.customerNumber= " + key);


			System.out.println("after query");
			if (rec.next()) {
				CustomersDetailsData = new CustomersDetails(
						rec.getInt("customerNumber"), 
						rec.getString("customerName"),
						rec.getString("contactLastName"),
						rec.getString("contactFirstName"),
						rec.getString("phone"),
						rec.getString("addressLine1"),

						rec.getString("addressLine2"),
						rec.getString("city"),
						rec.getString("state"),
						rec.getString("postalCode"),
						rec.getString("country"),
						rec.getInt("salesRepEmployeeNumber"), 
						rec.getDouble("creditLimit"),
			         	rec.getString("lastName"),
			         	rec.getString("firstName"),
			         	rec.getString("email"),
			         	rec.getString("officeCode"),
			         	rec.getString("city"),
			         	rec.getString("state"),
			         	rec.getString("c.phone"));
			         	
			         	
						
						
						
				
			}
			else{
			        	CustomersDetailsData = new CustomersDetails(
					    	 key,
					    	"Customer number not found",
					    	"",
					    	"",
					    	"",
					    	"",
					    	"",
					    	"",
					    	"",
					    	"",
					    	"",
					    	0,
					    	0,
					    	"",
					    	"",
					    	"",
					    	"",
					    	"",
					    	"",
					    	"");
					    	
				
			}
		} catch (Exception e) {

			System.out.println("Error -- PatientsRepository " + e.toString());
		} // }
		return CustomersDetailsData;
	}

	
	
}

