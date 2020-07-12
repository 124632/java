package com.xworks.happyeasygo.controller;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PriceController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	
	String source=req.getParameter("source");
	String destination=req.getParameter("destination");
	
	System.out.println("PriceController"  +source+ "\t" +destination);
	
	ServletConfig servletConfig=getServletConfig();
	
	String flightCount=servletConfig.getInitParameter("noOfFlights");
	String mainLocation=servletConfig.getInitParameter("headOffice");
	String CheapestCharge=servletConfig.getInitParameter("cheapestFlightcharge");
	
	System.out.println(flightCount+ "\t" +mainLocation+ "\t" +CheapestCharge);
	
	System.out.println("-------------------------------------------");
	
	ServletContext servletContext=getServletContext();
	String ceoOfArtiAPP = servletContext.getInitParameter("CEO");
	System.out.println("CEO:"+ceoOfArtiAPP);
	
	System.out.println("--------------------------------------------");
	
	}
}
