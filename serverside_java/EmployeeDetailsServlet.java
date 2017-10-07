package Ajax;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import jquery.datatables.model.Employee;
import jquery.datatables.model.EmployeeRepository;
import com.google.gson.Gson;

@WebServlet("/EmployeeDetailsServlet")
public class EmployeeDetailsServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

	public EmployeeDetailsServlet() 
	{
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		System.out.println("into Employee Details servlet ");
		System.out.println("id= " + request.getParameter("id"));

		String id = request.getParameter("id");
		int i = Integer.parseInt(id);

		try 
		{
			Employee e = EmployeeRepository.GetEmployeeDetails(i);
		 	String json = new Gson().toJson(e);
		 	response.setContentType("application/json");
		 	response.setCharacterEncoding("UTF-8");
		 	System.out.println("Gson Response " + json);
		 	response.getWriter().write(json);		
		}
		catch (Exception e) 
		{
			System.out.println("Error -- Servlet" + e.toString());
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doGet(request, response);
	}
}
