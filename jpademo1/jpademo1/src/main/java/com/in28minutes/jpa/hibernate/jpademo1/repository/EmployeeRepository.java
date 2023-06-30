package com.in28minutes.jpa.hibernate.jpademo1.repository;

import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.in28minutes.jpa.hibernate.jpademo1.entity.Course;
import com.in28minutes.jpa.hibernate.jpademo1.entity.Employee;
import com.in28minutes.jpa.hibernate.jpademo1.entity.FulltimeEmployee;
import com.in28minutes.jpa.hibernate.jpademo1.entity.PartTimeEmployee;

@Repository
@Transactional
public class EmployeeRepository {
	@Autowired
	EntityManager em;

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	public Course findById(Long id) {
		return em.find(Course.class, id);
	}

	// insert an employee
	public void insert(Employee employee) {
		em.persist(employee);
	}

	// retrieve full employees
	public List<FulltimeEmployee> retrieveFullTimeEmployees() {
		return em.createQuery("select e from FulltimeEmployee e", FulltimeEmployee.class).getResultList();
	}
	// retrieve part time employees	
	public List<PartTimeEmployee> retrievePartTimeEmployees() {
		return em.createQuery("select e from PartTimeEmployee e", PartTimeEmployee.class).getResultList();
	}
}
