package com.in28minutes.jpa.hibernate.jpademo1.repository;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import com.in28minutes.jpa.hibernate.jpademo1.Jpademo1Application;
import com.in28minutes.jpa.hibernate.jpademo1.entity.Course;
import com.in28minutes.jpa.hibernate.jpademo1.entity.Review;

@SpringBootTest(classes = Jpademo1Application.class)
class CourseRepositoryTest {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	CourseRepository cr;
	
	@Autowired
	EntityManager em;
	
	@Test
	void contextLoads() {
		/*logger.info("hellooo all...!!");
		Course course = cr.findById(1001L);
		assertEquals("DS", course.getName());*/
	}
	@Test
	public void findById_basic() {
		Course course = cr.findById(1001L);
		assertEquals("DS", course.getName());
	}
	
	@Test
	@Transactional
	public void findById_firstLevelCacheDemo() {
		Course course = cr.findById(1001L);
		logger.info("first course retrieved {} "+ course);
		
		Course course1 = cr.findById(1001L);
		logger.info("first course retrieved again{} "+ course1);
		
		assertEquals("DS", course.getName());
	}
	
	@Test
	@Transactional
	@DirtiesContext  // it will reset the data b/c other methods will effect by this so it can resolve this
	public void deleletById_baic() {
		cr.deleteById(1003L);
		assertNull(cr.findById(1003L));
	}
	
	@Test
	@DirtiesContext
	public void save_basic() {
		Course course = cr.findById(1001L);
		assertEquals("DS", course.getName());
		
	/*	course.setName("DS - updated");
		
		cr.save(course);
		
		Course course1 = cr.findById(1001L);
		assertEquals("DS - updated", course1.getName());
		
		*/
	}
	@Test
	@Transactional
	public void  retriveCourseForReview() {
		Review review= em.find(Review.class, 5001L);
		logger.info("courses for 5001l review id iss :: "+review.getCourse()); // it will fetch all course details as well as associated all reviews
	}
}