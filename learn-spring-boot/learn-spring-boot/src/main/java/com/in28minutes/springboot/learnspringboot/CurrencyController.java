package com.in28minutes.springboot.learnspringboot;

import java.util.*;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyController {

	@RequestMapping("/courses")
	public List<Course> retrieveAllCourses(){
		return Arrays.asList(
				new Course(1,"learn aws", "sky"),
				new Course(2,"learn java", "sky"),
				new Course(4,"learn linux", "sky"),
				new Course(3,"devops","kunal")
							);
	}
}
