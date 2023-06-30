package com.in28minutes.jpa.hibernate.jpademo1.entity;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public  class FulltimeEmployee extends Employee{
	
	protected FulltimeEmployee() {}
	
	public FulltimeEmployee(String name, BigDecimal salary) {
		super(name); 
		this.salary = salary;
	}
	
	private BigDecimal salary;

}
