package com.in28minutes.jpa.hibernate.jpademo1.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.in28minutes.jpa.hibernate.jpademo1.Jpademo1Application;
import com.in28minutes.jpa.hibernate.jpademo1.entity.Course;

@SpringBootTest(classes = Jpademo1Application.class)
class CriteriaQueryTest {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	EntityManager em;

	@Test
	void contextLoads() {

	}

	@Test
	public void jpql_basic() {
		// 1. use the criteria builder to create a criteria query returning the expected
		// result object
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Course> cq = cb.createQuery(Course.class);

		// 2. define roots for table which are involved in the query
		Root<Course> courseRoot = cq.from(Course.class);

		// 3. define predicates etc using criteria builder note not have any condtns and
		// order by like that
		Predicate like = cb.like(courseRoot.get("name"), "%S");
		
		// 4. add predicate etc to the Criteria Query
		cq.where(like);
		// 5 build the typer query using the criteria manager and criteria query
		TypedQuery<Course> createQuery = em.createQuery(cq.select(courseRoot));
		List<Course> list = createQuery.getResultList();
		logger.info("select c from course c  basic cqt-> " + list);

	}

}