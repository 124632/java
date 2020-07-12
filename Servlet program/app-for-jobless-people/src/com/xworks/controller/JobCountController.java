package com.xworks.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class JobCountController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter writer = resp.getWriter();
		writer.println("In second servlet....");
		int min = 1, max = 100;
		Random number = new Random();
		int randomNo = min + number.nextInt(max);
		writer.println(randomNo + "Job Available");
		if (randomNo != 0) {
			resp.sendRedirect("JobAvailable.html");
		}
		writer.close();
	}

}
