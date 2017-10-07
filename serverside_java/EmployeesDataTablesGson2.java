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
import jquery.datatables.model.Employee;
import jquery.datatables.model.EmployeeRepository;
import com.google.gson.Gson;
import jquery.datatables.model.JQueryDataTableParamModel;
//import jquery.datatables.model.Product;

//Servlet implementation class ProductDataTablesGson2 
@WebServlet("/EmployeesDataTablesGson2")
public class EmployeesDataTablesGson2 extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	
	public EmployeesDataTablesGson2() 
	{
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		System.out.println("into EmployeeDataTablesGson2 ");
		JQueryDataTableParamModel param = DataTablesParamUtility.getParam(request);
		String sEcho = param.sEcho;
		int iTotalRecords = 0; // total number of records (unfiltered)
		int iTotalDisplayRecords = 0;// value will be set when code filters

		try 
		{					
			List<Employee> employeeData = new LinkedList<Employee>();
			for(Employee e : EmployeeRepository.GetEmployees())
			{
				if(	e.getLastName().toLowerCase().contains(param.sSearch.toLowerCase()) || e.getOfficeCode().toLowerCase().contains(param.sSearch.toLowerCase()))			
				{
					employeeData.add(e); // Add employee that matches search criterion
		        }
		    }
			
			iTotalRecords = employeeData.size();
			iTotalDisplayRecords = employeeData.size();
			
			
			final int sortColumnIndex = param.iSortColumnIndex;
			final int sortDirection = param.sSortDirection.equals("asc") ? -1: 1;   						
			
			Collections.sort(employeeData, new Comparator<Employee>() 
			{
			   @Override
			   public int compare(Employee e1, Employee e2) 
			   {
				   	 System.out.println("sort column index = " + sortColumnIndex);
			         switch (sortColumnIndex) 
			         { 
			             case 1:
			                  return e1.getLastName().compareTo(e2.getLastName())
			                  * sortDirection;
			 
			             case 5:
			                  return e1.getOfficeCode().compareTo(e2.getOfficeCode())
			                  * sortDirection;
			                  
			             /*case 2:
			                  return e1.getFirstName().compareTo(e2.getFirstName())
			                  * sortDirection;*/
			         }
			         
			         return 0;
			   }
			});

			/* check if paging is required*/
			if (employeeData.size() < param.iDisplayStart + param.iDisplayLength)
				employeeData = employeeData.subList(param.iDisplayStart, employeeData.size());
			else
				employeeData = employeeData.subList(param.iDisplayStart, param.iDisplayStart + param.iDisplayLength);
			
			/* create datatables output and convert to Json format using Gson*/
			Hashtable<String, Object> output = new Hashtable<String, Object>();
			output.put("sEcho", sEcho);
			output.put("iTotalRecords", iTotalRecords);
			output.put("iTotalDisplayRecords", iTotalDisplayRecords);
			output.put("aaData", employeeData);
			String json = new Gson().toJson(output);
			
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			System.out.println("Gson Response " + json);
			response.getWriter().write(json);
		} 
		catch (Exception e) 
		{
			System.out.println("Error --Products DB " + e.toString());
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doGet(request, response);
	}

}
