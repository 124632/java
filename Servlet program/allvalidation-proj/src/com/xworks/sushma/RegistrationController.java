package com.xworks.sushma;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegistrationController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(this.getClass().getCanonicalName()+"service() created.....");
		
		PrintWriter writer = resp.getWriter();
		RequestDispatcher reDispatcher=req.getRequestDispatcher("success.html");
		writer.println("<html>");
		writer.println("<body>");
		writer.println("<a href='index.html'>click to call index page</a>");
		writer.println("</body>");
		writer.println("</html>");
		
		String firstname = req.getParameter("firstname");
		String lastname = req.getParameter("lastname");
		String email = req.getParameter("email");
		String otp = req.getParameter("op");
		if(firstname!=null && !firstname.isEmpty() && lastname!=null && !lastname.isEmpty() && email!=null 
				&& !email.isEmpty() && otp!=null && !otp.isEmpty()) {
			writer.print("Registration Done successfully");
			RequestDispatcher dis=req.getRequestDispatcher("success.html");
			dis.include(req, resp);
		} else {
			writer.println("Registration fail.....");
			
		}
		writer.close();
	}
}
