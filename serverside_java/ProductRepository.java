package jquery.datatables.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;


public class ProductRepository {
	
	/// <summary>
    /// Singleton collection of companies
    /// </summary>
    private static List<Product> ProductData = null;

    /// <summary>
    /// Method that returns all products used in this example
    /// </summary>
    /// <returns>List of products</returns>
    public static List<Product> GetProducts()
    {
    	
        if (ProductData == null)
        {
        	try {
        		ProductData = new LinkedList<Product>();
        		String dataSource = "jdbc:mysql://localhost:3306/classicmodels";
    			Class.forName("com.mysql.jdbc.Driver");
    			// com.mysql.jdbc.Driver
    			
    			Connection conn = DriverManager.getConnection(dataSource, "satAD",
    					"test123");
    			Statement st = conn.createStatement();
    			//System.out.println("before query");

    			ResultSet rec = st
    				.executeQuery("select * from products  order by productLine asc");
    		//	.executeQuery("select * from products  where productCode = 'S10_1949'");
    			//System.out.println("after query");
    			while (rec.next()) {
    				Product addProduct = new Product(
    						rec.getString("productCode"),
							rec.getString("productName"),
							rec.getString("productLine"),
							rec.getString("productDescription"),
							rec.getDouble("MSRP"));
					ProductData.add(addProduct); // Add a product 
    			}
         
        	} catch (Exception e) {

    			System.out.println("Error -- DataRepository " + e.toString());
    		}
        }
        return ProductData;
    }

}
