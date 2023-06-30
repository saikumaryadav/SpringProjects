package com.in28minutes.jpa.hibernate.jpademo1.repository;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import com.in28minutes.jpa.hibernate.jpademo1.Jpademo1Application;
import com.in28minutes.jpa.hibernate.jpademo1.entity.Course;

@SpringBootTest(classes = Jpademo1Application.class)
class JPQLTest {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

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
	public void jpql_basic() {
		Query TypedQuery = em.createNamedQuery("query_get_all_courses");
		List list = TypedQuery.getResultList();
		logger.info("select c from course c  basic-> " + list);
	}
	
	@Test
	public void jpql_typed() {
		TypedQuery<Course> TypedQuery = em.createQuery("select c from Course c", Course.class);
		List<Course> list = TypedQuery.getResultList();
		logger.info("select c from course c  typed-> " + list);
	}
	
	@Test
	public void jpql_condition() {
		TypedQuery<Course> TypedQuery = em.createQuery("select c from Course c where name like '%DS%'", Course.class);
		List<Course> list = TypedQuery.getResultList();
		logger.info("select c from course c condition -> " + list);
	}

}