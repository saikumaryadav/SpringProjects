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
class NativeQueryTest {
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
	public void nativequery_basic() {
		Query TypedQuery = em.createNativeQuery("select * from course", Course.class);
		List list = TypedQuery.getResultList();
		logger.info("select c from course c  native basic-> " + list);
	}
	@Test
	public void nativequery_basic_with_parameter() {
		Query TypedQuery = em.createNativeQuery("select * from course where id = ?", Course.class);
		TypedQuery.setParameter(1, 1001L);
		List list = TypedQuery.getResultList();
		logger.info("select * from course where id = ? native basic with condition-> " + list);
	}
	@Test
	public void nativequery_basic_with_named_parameter() {
		Query TypedQuery = em.createNativeQuery("select * from course where id = :id", Course.class);
		TypedQuery.setParameter("id", 1001L);
		List list = TypedQuery.getResultList();
		logger.info("select * from course where id = :id native basic with named parameter-> " + list);
	}

}