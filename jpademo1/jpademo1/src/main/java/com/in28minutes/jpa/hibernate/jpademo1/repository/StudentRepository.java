package com.in28minutes.jpa.hibernate.jpademo1.repository;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.in28minutes.jpa.hibernate.jpademo1.entity.Course;
import com.in28minutes.jpa.hibernate.jpademo1.entity.Passport;
import com.in28minutes.jpa.hibernate.jpademo1.entity.Student;

@Repository
@Transactional
public class StudentRepository {

	@Autowired
	EntityManager em;

	public Student findById(Long id) {
		return em.find(Student.class, id);
	}

	public void deleteById(Long id) {
		Student Student = findById(id);
		em.remove(Student);
	}

	public Student save(Student Student) {
		if (Student.getId() != null) {
			em.persist(Student); // insert Student object
		} else {
			em.merge(Student); // update object
		}
		return Student;
	}

	public void saveStudentWithPassport() {

		// Passport passport = new Passport("Z321654");
		// em.persist(passport);

		Student Student1 = new Student("MIKE");
		// Student1.setPassport(passport);
		em.persist(Student1);

	}

	public void playWithPersistanceContext() {
		// db operation 1 - retrive student
		Student student = em.find(Student.class, 2001L);

		// db operation 1 - retrive passport
		Passport passport = student.getPassport();

		// db operation 1 - update student
		student.setName("ranga - updated");

		// db operation 1 - update passport
		passport.setNumber("AB123321");

	}

	public void insertHardcodedStudentAndCourse() {
		Student student = new Student("Jack");
		Course course = new Course("Apache Kafka");
		em.persist(student);
		em.persist(course);

		student.addCourses(course);
		em.persist(student);
	}

	public void insertStudentAndCourse(Student student, Course course) {

		student.addCourses(course);
		em.persist(student);
		em.persist(course);

	}
}