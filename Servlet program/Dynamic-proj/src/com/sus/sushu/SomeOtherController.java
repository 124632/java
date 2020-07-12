package com.sus.sushu;

import java.io.IOException;


import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class SomeOtherController extends GenericServlet {

	public SomeOtherController() {
		System.out.println(this.getClass().getSimpleName()+"creat");
	}
	@Override
	public void service(ServletRequest agr0, ServletResponse agr1) throws ServletException, IOException {
		System.out.println("hi seema"+this.getClass().getSimpleName());
		

	}

}
