package com.sss.sushu;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class LoginValidation extends GenericServlet {

	public LoginValidation() {
		System.out.println(this.getClass().getSimpleName() + "creat");
	}

	public void inint(ServletConfig config) throws ServletException {
		super.init(config);
		System.out.println("nice" + this.getClass().getSimpleName());
	}

	@Override
	public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException {

		PrintWriter writer = resp.getWriter();

		writer.println("<html>");
		writer.println("<body>");
		writer.println("<a href='index.html'>click to call index page</a>");
		writer.println("</body>");
		writer.println("</html>");

		String firstname = req.getParameter("FirstName");
		String lastname = req.getParameter("LastName");
		if (firstname.isEmpty() || lastname.isEmpty()) {
			writer.println("please enter name");
		} else {
			writer.println("<h2> welcome " + firstname + "  " + lastname + "</h2");
		}
		writer.close();
	}
		public void destory() {
			super.destroy();
			System.out.println("Inside destory() of"+this.getClass().getSimpleName());
		}
	

}
