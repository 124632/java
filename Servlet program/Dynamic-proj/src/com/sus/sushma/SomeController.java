package com.sus.sushma;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class SomeController extends GenericServlet{
	
	public SomeController() {
		System.out.println(this.getClass().getSimpleName()+"creat");
	}
	
	public void inint(ServletConfig config)throws ServletException{
		super.init(config);
		System.out.println("nice"+this.getClass().getSimpleName());
	}

	@Override
	public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException {
		
		System.out.println("friends");
		
PrintWriter writer=resp.getWriter();
		
		writer.println("<html>");
		writer.println("<body>");
		writer.println("<a href='welcome.html'>click to call welcome page</a>");
		writer.println("</body>");
		writer.println("</html>");
		
		writer.close();
	}

}
