package com.in28minutes1.spring.learningspringframework.enterprise.example.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.in28minutes1.spring.learningspringframework.enterprise.example.data.DataService;

@Component
public class BusinessService{
	@Autowired
	DataService dataService;
	public int calculateSum() {
		List<Integer> list = dataService.getData();
		return list.stream().reduce(Integer::sum).get();
	}
}
