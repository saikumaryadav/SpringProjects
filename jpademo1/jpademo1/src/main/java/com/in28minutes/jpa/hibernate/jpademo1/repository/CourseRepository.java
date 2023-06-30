package com.in28minutes.jpa.hibernate.jpademo1.repository;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.in28minutes.jpa.hibernate.jpademo1.entity.Course;
import com.in28minutes.jpa.hibernate.jpademo1.entity.Review;

@Repository
@Transactional
public class CourseRepository {

	@Autowired
	EntityManager em;

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	public Course findById(Long id) {
		return em.find(Course.class, id);
	}

	public void deleteById(Long id) {
		Course course = findById(id);
		em.remove(course);
	}

	public Course save(Course course) {
		if (course.getId() != null) {
			em.persist(course); // insert course object
		} else {
			em.merge(course); // update object
		}
		return course;
	}

	public void playWithEntityManager() {
		Course course1 = new Course("DBMS");
		em.persist(course1);

		Course course2 = findById(1002L);
		course2.setName("Java-updated");
		/*
		 * Course course2 = new Course("WORK"); em.persist(course2);
		 * 
		 * em.flush(); em.clear(); //em.detach(course); course1.setName("ENJOY");
		 */
	}

	public void addCourseReviews() {
		// get course 1003
		Course course = findById(1003L);
		logger.info("course.getrewviews -- > : " + course.getReviews());
		// add 2 reviews in course
		Review review1 = new Review("4", "best course");
		Review review2 = new Review("5", "GOAT");

		course.addReviews(review1);
		review1.setCourse(course);

		course.addReviews(review2);
		review2.setCourse(course);

		// save the course
		em.persist(review1);
		em.persist(review2);
		// Note : we need to save relationship data owning side object only
		logger.info("course. updated reviews-- > : " + findById(1003L));
	}
	// TODO : create a method to store reviews based on course id(long course_id,
	// List<reviews> reviews)

}