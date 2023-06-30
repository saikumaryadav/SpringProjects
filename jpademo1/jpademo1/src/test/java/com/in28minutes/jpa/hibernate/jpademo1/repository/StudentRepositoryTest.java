package com.in28minutes.jpa.hibernate.jpademo1.repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.in28minutes.jpa.hibernate.jpademo1.Jpademo1Application;
import com.in28minutes.jpa.hibernate.jpademo1.entity.Passport;
import com.in28minutes.jpa.hibernate.jpademo1.entity.Student;

@SpringBootTest(classes = Jpademo1Application.class)
class StudentRepositoryTest {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	StudentRepository sr;

	@Autowired
	EntityManager em;

	@Test
	void contextLoads() {
		/*
		 * logger.info("hellooo all...!!"); Course course = cr.findById(1001L);
		 * assertEquals("DS", course.getName());
		 */
	}

	@Test
	@Transactional
	public void retriveStudentAndPassport() {
		Student student = em.find(Student.class, 2001L);
		logger.info("student details --> " + student);
		logger.info("passport details --> " + student.getPassport());
	}

	@Test
	@Transactional
	public void retrivePassportAndAssociatedStudent() {
		Passport passport = em.find(Passport.class, 4001L);
		logger.info("Passport details  in PAS--> " + passport);
		logger.info("Student details in PAS --> " + passport.getStudent());
	}

	@Test
	public void someTest() {

		sr.playWithPersistanceContext();
	}

	// Many to Many
	@Test
	@Transactional
	public void retriveStudentAndCourseDetails() {
		Student student = em.find(Student.class, 2001L);
		logger.info("courses of student 2001 id student  ::" + student.getCourses());
	}

}