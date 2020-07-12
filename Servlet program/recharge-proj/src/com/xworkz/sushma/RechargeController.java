package com.xworkz.sushma;



import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RechargeController extends HttpServlet{
	
	/*protected void inint(ServletConfig config) throws ServletException {
		super.init(config);
		System.out.println("nice" + this.getClass().getSimpleName());
	}*/
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println(this.getClass().getCanonicalName()+"service() created.....");
	
		PrintWriter writer = resp.getWriter();
		RequestDispatcher reDispatcher=req.getRequestDispatcher("success.html");
		writer.println("<html>");
		writer.println("<body>");
		writer.println("<a href='recharge.html'>click to call Recharge page</a>");
		writer.println("</body>");
		writer.println("</html>");
		
		String phonenumber = req.getParameter("phonenumber");
		String amount = req.getParameter("amount");
		String otp = req.getParameter("op");
		if(phonenumber.length()==10 && phonenumber.matches("[-+]?[0-9]*")
				&& !otp.isEmpty()&& amount.matches("[-+]?[0-9]*")) {
			writer.print("Recharge Done successfully");
			RequestDispatcher dis=req.getRequestDispatcher("success.html");
			dis.include(req, resp);
		} else {
			writer.println("Recharge fail.....");
			
		}
		writer.close();
	}
	
	public void destory() {
		super.destroy();
		System.out.println("Inside destory() of"+this.getClass().getSimpleName());
	}
}
