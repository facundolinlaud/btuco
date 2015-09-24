package com.fruta.btuco.service;

import com.fruta.btuco.exceptions.ResourceAlreadyExistsException;
import com.fruta.btuco.model.Course;
import com.fruta.btuco.model.Student;

import java.util.List;

public interface CourseService {
	List<Course> findAll();

	Course find(Integer id);
	
	boolean exists(Integer id);
	
	Course save(Course course) throws ResourceAlreadyExistsException;
	
	Course update(Integer id, Course newCourse);
	
	void delete(Course course);
}
