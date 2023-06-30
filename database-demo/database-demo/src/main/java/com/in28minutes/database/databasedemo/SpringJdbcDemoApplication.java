package com.in28minutes.database.databasedemo;



import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.in28minutes.database.databasedemo.entity.Person;
import com.in28minutes.database.databasedemo.jdbc.PersonJdbcDao;

//@SpringBootApplication
public class SpringJdbcDemoApplication implements CommandLineRunner{

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	PersonJdbcDao personJdbcDao;
	public static void main(String[] args) {
		SpringApplication.run(SpringJdbcDemoApplication.class, args);
		System.out.println("database");
	}

	@Override
	public void run(String... args) throws Exception {
		
		logger.info("all users {} "+ personJdbcDao.findAll());
		logger.info("user 10001 details {} "+ personJdbcDao.findById(10001));
		logger.info("deleting 10002 ->no of records {} "+ personJdbcDao.deleteById(10002));
	//	logger.info("inserting 10005 ->no of records {} "+ personJdbcDao.insert(new Person(10005, "tanu", "berlin", new Date())));
		logger.info("all users {} "+ personJdbcDao.findAll());
	}

}
