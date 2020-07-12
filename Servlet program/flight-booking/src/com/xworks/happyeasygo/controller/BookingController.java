package com.xworks.happyeasygo.controller;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.omg.PortableServer.Servant;

public class BookingController extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String source=req.getParameter("source");
		String destination=req.getParameter("destination");
		
		System.out.println("BookingController" +source+ "\t" +destination);
		
		ServletConfig servletConfig=getServletConfig();
		
		String flightCount=servletConfig.getInitParameter("noOfFlight");
		String mainLocation=servletConfig.getInitParameter("headOffice");
		String CheapestCharge=servletConfig.getInitParameter("cheapestFlightCharge");
		
		System.out.println(flightCount+ "\t" +mainLocation+ "\t" +CheapestCharge);
		
		System.out.println("------------------------------");
		
		ServletContext servletContext=getServletContext();
		String ceoOfArtiApp=servletContext.getInitParameter("CEO");
		System.out.println("CEO:"+ceoOfArtiApp);
		
		System.out.println("--------------------------------");
		
		resp.sendRedirect("price");
	}

}
