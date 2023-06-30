package com.in28minutes.jpa.hibernate.jpademo1.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.in28minutes.jpa.hibernate.jpademo1.entity.Course;
@RepositoryRestResource(path = "course")
public interface CourseSpringDataRepository extends JpaRepository<Course, Long> {
	List<Course> findByName(String name);

	List<Course> findByNameAndId(String name, Long id);

	List<Course> deleteByName(String name);

	List<Course> countByName(String name);

	@Query("select c from Course c where name like '%OS%'")
	List<Course> courseWithOS();

	@Query(value = "select * from Course c where name like '%OS%'", nativeQuery = true)
	List<Course> courseWithOSNativeQuery();

	@Query(name = "query_get_all_courses")
	List<Course> courseWithOSWithNamedQuery();
}
