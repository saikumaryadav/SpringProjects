package com.in28minutes.database.databasedemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.in28minutes.database.databasedemo.entity.Person;
import com.in28minutes.database.databasedemo.jdbc.PersonJdbcDao;
import com.in28minutes.database.databasedemo.jpa.PersonJpaRepository;


@RestController
@RequestMapping(path = "/p")
public class PersonController {

	@Autowired
	PersonJdbcDao personJdbcDao;
	
	@Autowired
	PersonJpaRepository personJpaRepository;
	
	/*@RequestMapping("/getperson")
	public List<Person> getAllPersons(){
		return personJdbcDao.findAll();
	}*/
	@RequestMapping("/persons")
	public List<Person> getAllPersonsByJpa(){
		return personJpaRepository.findAll();
	}
}
