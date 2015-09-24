package com.fruta.btuco.dao;

import com.fruta.btuco.model.Course;
import com.fruta.btuco.model.Student;

import java.util.List;

public interface CourseDao {

	List<Course> findAll();
	
	Course find(Integer id);
	
	Course save(Course course);

	Course update(Integer id, Course newCourse);

	void delete(Course student);
	
	void deleteById(Integer id);
}
