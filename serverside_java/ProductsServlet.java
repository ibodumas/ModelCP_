package jquery.datatables.controller;

import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import jquery.datatables.model.JQueryDataTableParamModel;
import jquery.datatables.model.Product;
import jquery.datatables.model.ProductRepository;
import com.google.gson.Gson;

@WebServlet("/ProductsServlet")
public class ProductsServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
    public ProductsServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		System.out.println("into Products Servlet ");
		JQueryDataTableParamModel param = DataTablesParamUtility
				.getParam(request);

		String sEcho = param.sEcho;
		int iTotalRecords = 0; // total number of records (unfiltered)
		int iTotalDisplayRecords = 0;// value will be set when code filters

		try {					
			List<Product> productData = new LinkedList<Product>();
		
			
			for(Product p : ProductRepository.GetProducts()){
				if(	p.getProductLine().toLowerCase().contains(param.sSearch.toLowerCase())
					||
		              p.getName().toLowerCase().contains(param.sSearch.toLowerCase()))			
					{
		                 productData.add(p); // Add product that matches search criterion
		             }
		  
		         }	
			
			iTotalRecords = ProductRepository.GetProducts().size(); // total number of records (unfiltered)
			iTotalDisplayRecords = productData.size();
			
			
			 final int sortColumnIndex = param.iSortColumnIndex;
			 final int sortDirection = param.sSortDirection.equals("asc") ? -1: 1;   						
			   Collections.sort(productData, new Comparator<Product>() {
			   @Override
			   public int compare(Product p1, Product p2) {
			         switch (sortColumnIndex) { 
			             case 1:
			                  return p1.getName().compareTo(p2.getName())
			                  * sortDirection;
			 
			             case 2:
			                  return p1.getProductLine().compareTo(p2.getProductLine())
			                  * sortDirection;
			        }
			        return 0;
			        }
			  });

     /* check if paging is required*/
			if (productData.size() < param.iDisplayStart + param.iDisplayLength)
				productData = productData.subList(param.iDisplayStart,
						productData.size());
			else
				productData = productData.subList(param.iDisplayStart,
						param.iDisplayStart + param.iDisplayLength);
     /* create datatables output and convert to Json format using Gson*/
			Hashtable<String, Object> output = new Hashtable<String, Object>();
			output.put("sEcho", sEcho);
			output.put("iTotalRecords", iTotalRecords);
			output.put("iTotalDisplayRecords", iTotalDisplayRecords);
			output.put("aaData", productData);
			String json = new Gson().toJson(output);
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			System.out.println("Gson Response " + json);
			response.getWriter().write(json);

		} catch (Exception e) {
			System.out.println("Error --Products DB " + e.toString());

		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		System.out.println("into Products Servlet : doPost");
		doGet(request,response);
	}

}
