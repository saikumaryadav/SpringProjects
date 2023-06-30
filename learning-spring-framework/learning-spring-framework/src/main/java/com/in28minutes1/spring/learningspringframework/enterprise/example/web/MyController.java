package com.in28minutes1.spring.learningspringframework.enterprise.example.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.in28minutes1.spring.learningspringframework.enterprise.example.business.BusinessService;

@Component
public class MyController {
	@Autowired
	BusinessService businessService;
	public long returnBusinessValue() {
		return businessService.calculateSum();
	}
}


