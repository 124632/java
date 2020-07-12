package com.xworkz.spring;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Component
@RequestMapping
public class Controller {
	
	public Controller() {
		System.out.println("Created \t"+this.getClass().getSimpleName());
	}
	
	@RequestMapping("/click.odc")
	public String onclick() {
		System.out.println("invoked onclick");
		System.out.println("will send response to success.html");
		return"/success.html";
	}
	@RequestMapping("/submit.odc")
	public String onSubmit(@RequestParam String address,@RequestParam String name,
			@RequestParam String email,@RequestParam String phoneno,@RequestParam String symptoms) {
	System.out.println("invokes onSubmit");
	System.out.println("Name:"+name);
	System.out.println("Address:"+address);
	System.out.println("Email:"+email);
	System.out.println("Phone No:"+phoneno);
	System.out.println("Symptoms:"+symptoms);
	
	System.out.println("will send response to success.html");
	return"/success.html";
	}


}
