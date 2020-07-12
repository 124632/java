package com.xworkz.sushma;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.SessionCookieConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class FromController extends HttpServlet {

	
	public FromController() {
		System.out.println("From Controller is Created..");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession httpSession = req.getSession();

		String firstName = req.getParameter("firstname");

		httpSession.setAttribute("firstname", firstName);
		ServletConfig config = getServletConfig();
		String FirstName = config.getInitParameter("name");
		System.out.println("Servlet config using name:" + firstName);

		System.out.println("------------------------------------------");
		ServletContext context = getServletContext();
		context.getInitParameter("name");

		if (FirstName.isEmpty()) {
			System.out.println("please enter first name.....");
		} else {
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("LastName.jsp");
			requestDispatcher.include(req, resp);
		}
	}
}
