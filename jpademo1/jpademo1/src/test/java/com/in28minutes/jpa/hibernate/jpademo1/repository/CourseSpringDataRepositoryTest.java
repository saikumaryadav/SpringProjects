package com.in28minutes.jpa.hibernate.jpademo1.repository;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;

import com.in28minutes.jpa.hibernate.jpademo1.Jpademo1Application;
import com.in28minutes.jpa.hibernate.jpademo1.entity.Course;

@SpringBootTest(classes = Jpademo1Application.class)
class CourseSpringDataRepositoryTest {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	CourseSpringDataRepository csdr;

	@Test
	public void findById_present() {
		Optional<Course> courseOptional = csdr.findById(1001L);
		logger.info("course present :: " + courseOptional.isPresent());
		assertTrue(courseOptional.isPresent());
	}

	@Test
	public void findById_absent() {
		Optional<Course> courseOptional = csdr.findById(2001L);
		logger.info("course absent :: " + courseOptional.isPresent());
		assertFalse(courseOptional.isPresent());
	}

	@Test
	public void sorting() {
		Direction desc = Sort.Direction.DESC;
		Sort sort = Sort.by(desc, "name");
		logger.info("sorted courses :: " + csdr.findAll(sort));
	}

	@Test
	public void pagination() {
		PageRequest pageRequest = PageRequest.of(0, 3);
		logger.info("first page courses :: " + csdr.findAll(pageRequest).getContent());
	}
	
	@Test
	public void findUsingName(String name) {
		
		logger.info("first page courses :: " + csdr.findByName(name));
	}
	
}