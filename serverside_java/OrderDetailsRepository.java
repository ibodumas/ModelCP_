package jquery.datatables.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;


public class OrderDetailsRepository {
	
	/// <summary>
    /// Singleton collection of orders details
    /// </summary>
    private static List<OrderDetails> OrderDetailsData = null;

    /// <summary>
    /// Method that returns order Details 
    /// </summary>
    /// <returns>List of products</returns>
    public static List<OrderDetails> GetOrderDetails(String parm)
    {
    	
       // if (OrderData == null)
       // {
        	ResultSet rec = null;
      
        	try {
        		
        		OrderDetailsData = new LinkedList<OrderDetails>();
        		String dataSource = "jdbc:mysql://localhost:3306/classicmodels";
    			Class.forName("com.mysql.jdbc.Driver");
    			// com.mysql.jdbc.Driver
    			Connection conn = DriverManager.getConnection(dataSource, "satAD",
    					"test123");
    			Statement st = conn.createStatement();
    			System.out.println("before query");
    		/*	if ((parm == null))
    				parameter = "";
    			else
    				parameter = parm;
    			if (parameter.length() == 0)
    				parameter = " ";
    			if (parameter.toUpperCase().equals("*ALL")) {
    				rec = st.executeQuery("select * from orders");
    			} else {*/
    				rec = st.executeQuery(
    						"SELECT * FROM orderdetails where orderNumber = "
    							+ "'"
    							+ parm
    							+ "'");
    			System.out.println("after query");
    			while (rec.next()) {
    				System.out.println("productCode = " +	rec.getString("productCode"));
    				OrderDetails addOrder = new OrderDetails(
							rec.getInt("orderNumber"),
						
							rec.getString("productCode"),
							rec.getInt("quantityOrdered"),
							rec.getDouble("priceEach"));
					OrderDetailsData.add(addOrder); // Add an OrderDetail 
    			}
         
        	} catch (Exception e) {

    			System.out.println("Error -- DataRepository " + e.toString());
    		}
       // }
        return OrderDetailsData;
    }

}
