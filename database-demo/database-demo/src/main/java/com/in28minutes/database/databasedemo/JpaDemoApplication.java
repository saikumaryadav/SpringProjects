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
import com.in28minutes.database.databasedemo.jpa.PersonJpaRepository;

@SpringBootApplication
public class JpaDemoApplication implements CommandLineRunner{

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	PersonJpaRepository personJpaRepository;
	public static void main(String[] args) {
		SpringApplication.run(JpaDemoApplication.class, args);
		System.out.println("database");
	}

	@Override
	public void run(String... args) throws Exception {
		
		logger.info("user 10001 details {} "+ personJpaRepository.findById(10001));
		logger.info("inserting 10005 ->no of records {} "+ personJpaRepository.insert(new Person( "tanuu", "berlin", new Date())));
		logger.info("inserting 100052 ->no of records {} "+ personJpaRepository.insert(new Person(10001, "tara", "kenya", new Date())));
		personJpaRepository.deleteById(10004);
		logger.info("All Personal details "+ personJpaRepository.findAll());
		/*logger.info("all users {} "+ personJdbcDao.findAll());
		 
		
		logger.info("deleting 10002 ->no of records {} "+ personJdbcDao.deleteById(10002));
	
		logger.info("all users {} "+ personJdbcDao.findAll());*/
	}

}