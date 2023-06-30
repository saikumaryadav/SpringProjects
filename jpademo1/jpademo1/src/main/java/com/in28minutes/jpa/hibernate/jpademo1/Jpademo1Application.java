package com.in28minutes.jpa.hibernate.jpademo1;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.in28minutes.jpa.hibernate.jpademo1.entity.Course;
import com.in28minutes.jpa.hibernate.jpademo1.entity.FulltimeEmployee;
import com.in28minutes.jpa.hibernate.jpademo1.entity.PartTimeEmployee;
import com.in28minutes.jpa.hibernate.jpademo1.entity.Student;
import com.in28minutes.jpa.hibernate.jpademo1.repository.CourseRepository;
import com.in28minutes.jpa.hibernate.jpademo1.repository.EmployeeRepository;
import com.in28minutes.jpa.hibernate.jpademo1.repository.StudentRepository;

@SpringBootApplication
public class Jpademo1Application implements CommandLineRunner {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private CourseRepository cr;

	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private EmployeeRepository employeeRepository;

	public static void main(String[] args) {
		SpringApplication.run(Jpademo1Application.class, args);

	}

	@Override
	public void run(String... args) throws Exception {
		/*
		 * Course course = cr.findById(1001L); System.out.println("hello");
		 * logger.info("course for 1001 is "+course);
		 * logger.info("course for 1002 is "+cr.findById(1002L)); cr.deleteById(1002L);
		 * cr.save(new Course("DS through Java"));
		 */
		// cr.playWithEntityManager();
		// studentRepository.saveStudentWithPassport();
		// cr.addCourseReviews();
		//studentRepository.insertHardcodedStudentAndCourse();
	//	studentRepository.insertStudentAndCourse(new Student("Jack"),new Course("APache kafka"));
		
		// full time employee sai 1000
		// part time employee Jack 55
		employeeRepository.insert(new FulltimeEmployee("sai", new BigDecimal(1000)));
		employeeRepository.insert(new PartTimeEmployee("jack", new BigDecimal(55)));
		logger.info("employees full time info :: "+employeeRepository.retrieveFullTimeEmployees());
		logger.info("employees part time employee info :: "+employeeRepository.retrievePartTimeEmployees());
	}

}
