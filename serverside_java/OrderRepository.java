package jquery.datatables.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;


public class OrderRepository {
	
	/// <summary>
    /// Singleton collection of orders
    /// </summary>
    private static List<Order> OrderData = null;

    /// <summary>
    /// Method that returns all orders 
    /// </summary>
    /// <returns>List of products</returns>
    public static List<Order> GetOrders(String parm)
    {
    	
       // if (OrderData == null)
       // {
        	ResultSet rec = null;
        	
        	try {
        		
        		OrderData = new LinkedList<Order>();
        		String dataSource = "jdbc:mysql://localhost:3306/classicmodels";
    			Class.forName("com.mysql.jdbc.Driver");
    			// com.mysql.jdbc.Driver
    			Connection conn = DriverManager.getConnection(dataSource, "satAD",
    					"test123");
    			Statement st = conn.createStatement();
    			System.out.println("before query");
    		
    				rec = st.executeQuery(
    						"SELECT * FROM orders where customerNumber = "
    							+ "'"
    							+ parm
    							+ "'");
    			System.out.println("after query");
    			while (rec.next()) {
    				System.out.println("order Number = " +	rec.getInt("orderNumber"));
    				Order addOrder = new Order(
    						rec.getInt("orderNumber"),
    						rec.getDate("orderDate"),
    						rec.getDate("requiredDate"),
    						rec.getDate("shippedDate"),
    						rec.getString("status"),
    						rec.getString("comments"),
    						rec.getInt("customerNumber"),
    				        rec.getString("customerName"));
    				OrderData.add(addOrder); // Add an Order 
    			}
         
        	} catch (Exception e) {

    			System.out.println("Error -- DataRepository " + e.toString());
    		}
       // }
        return OrderData;
    }
    public static List<Order> GetOrders( )
    {
    	ResultSet rec = null;
    
    	try {
    		
    		OrderData = new LinkedList<Order>();
    		String dataSource = "jdbc:mysql://localhost:3306/classicmodels";
			Class.forName("com.mysql.jdbc.Driver");
			// com.mysql.jdbc.Driver
			Connection conn = DriverManager.getConnection(dataSource, "satAD",
					"test123");
			Statement st = conn.createStatement();
			System.out.println("before query");
			
				rec = st.executeQuery("select * from orders,customers  where "
						+ "orders.customerNumber = customers.customerNumber order by orderNumber asc");
			
			System.out.println("after query");
			while (rec.next()) {
				
				Order addOrder = new Order(
						rec.getInt("orderNumber"),
						rec.getDate("orderDate"),
						rec.getDate("requiredDate"),
						rec.getDate("shippedDate"),
						rec.getString("status"),
						rec.getString("comments"),
						rec.getInt("customerNumber"),
				        rec.getString("customerName"));
				OrderData.add(addOrder); // Add an Order 
			}
     
    	} catch (Exception e) {

			System.out.println("Error -- DataRepository " + e.toString());
		}
    	 return OrderData;
    }

}
