package com.xworks.wish;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet(loadOnStartup=1, urlPatterns="/greetings")
public class GreetingsController extends HttpServlet{
	
	private WishesDAO dao=null;
	
	public GreetingsController() {
		System.out.println(this.getClass().getSimpleName()+"servlet object created");
	}
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		dao=new WishesDAO();
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String personName=req.getParameter("personName");
		String wishes=req.getParameter("wishes");
		
		if(personName !=null && !personName.isEmpty() && wishes!=null && !wishes.isEmpty()) {
			boolean saveStatus=dao.saveWishes(personName, wishes);
			
			if(saveStatus) {
				req.setAttribute("person", personName);
				RequestDispatcher requestDispatcher=req.getRequestDispatcher("success.jsp");
				requestDispatcher.include(req, resp);
				
			}else {
				resp.sendRedirect("failure.jsp");
			}
		}
	}
	

}
