package com.xworks.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class JobFinderController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		PrintWriter writer = resp.getWriter();
		writer.println("<html>");
		writer.println("<body>");
		writer.println("<a href='JobFinder.html'>click to call job finder page</a>");
		writer.println("</body>");
		writer.println("</html>");
		String jobcatagaries = req.getParameter("jc");
		String expectedsalary = req.getParameter("es");
		try {
			if (expectedsalary != null) {
				int salary = Integer.parseInt(expectedsalary);
				System.out.println(salary);
			}
		} catch (NumberFormatException nf) {
			writer.println("please enter only number..............");

		}
		writer.println("congratulation your new job..............");

		if (jobcatagaries != null && expectedsalary.matches("[-+]?[0-9]*")) {
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("JobCountController");
			requestDispatcher.include(req, resp);
		}
		writer.close();

	}
}