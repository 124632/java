package com.xworkz.sushma;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AppendController extends HttpServlet{
	
	public AppendController() {
		System.out.println("Append Controller created..............");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession httpSession=req.getSession();
		PrintWriter writer = resp.getWriter();
		writer.println("<html>");
		writer.println("<body>");
		writer.println("<a href='FirstName.jsp'>click to call first page</a>");
		writer.println("</body>");
		writer.println("</html>");
		
		//String firstname = req.getParameter("fname");
		String lastName = req.getParameter("lastName");
		httpSession.setAttribute("lastname", lastName);
		String fname=(String)httpSession.getAttribute("fname");
		String  lastname=(String)httpSession.getAttribute("lastname");
		
		ServletConfig config=getServletConfig();
		String LastName=config.getInitParameter("NAME");
		System.out.println("Servlet config using name:"+LastName);
		
		System.out.println("AppensController:"+fname+"/t"+lastname);
		
		System.out.println("------------------------------------------");
		ServletContext context= getServletContext();
		String Lastname=context.getInitParameter("NAME");
		System.out.println("Servlet context using name:"+Lastname);
		
		if(LastName.isEmpty()) {
			writer.println("please enter the lastname......");
		}else {
			writer.println("<h2> welcome"+fname+" "+lastname+"</h2>");
		}
		writer.close();
	}
}

