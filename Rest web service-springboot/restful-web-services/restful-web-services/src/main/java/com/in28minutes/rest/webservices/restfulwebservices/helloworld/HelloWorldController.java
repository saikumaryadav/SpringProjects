package com.in28minutes.rest.webservices.restfulwebservices.helloworld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloWorldController {

	@GetMapping(path="/hello-world")
	public String helloworld() {
		return "Hello World Saikumar...!";
	}
	
	@GetMapping(path="/hello-world-bean")
	public HelloWorldBean helloworldbean() {
		return new HelloWorldBean("hey hello... sai");
	}
	
	@GetMapping(path = "/hello-world/{name}")
	public HelloWorldBean helloworldbeanPathVariable(@PathVariable String name) {
		HelloWorldBean bean = new HelloWorldBean(name);
		bean.setMessage(name);
		return bean;
		
	}
}
