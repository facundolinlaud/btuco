package com.fruta.btuco.service.impl;

import com.fruta.btuco.dao.CourseDao;
import com.fruta.btuco.exceptions.ResourceAlreadyExistsException;
import com.fruta.btuco.exceptions.ResourceNotFoundException;
import com.fruta.btuco.model.Course;
import com.fruta.btuco.model.Student;
import com.fruta.btuco.service.CourseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {
	
	@Autowired
	private CourseDao courseDao;

	@Override
	public List<Course> findAll() {
		return courseDao.findAll();
	}

	@Override
	public Course find(Integer id) {
		Course course = courseDao.find(id);
		if (course == null) {
			throw new ResourceNotFoundException("Course with id " + id + " not found");
		}
		return course;
	}
	
	@Override
	public boolean exists(Integer id) {
		return courseDao.find(Integer.valueOf(id)) != null;
	}

	@Override
	public Course save(Course course) throws ResourceAlreadyExistsException {
		if (this.courseDao.find(course.getId()) != null) {
			throw new ResourceAlreadyExistsException("Course with id " + course.getId() + " already exists");
		}
		
		return this.courseDao.save(course);
	}

	@Override
	public Course update(Integer id, Course newCourse) {
    	
    	if (!id.equals(newCourse.getId()) && this.exists(newCourse.getId())) {
    		throw new ResourceAlreadyExistsException("Course with id " + newCourse.getId().toString() + " already exists");
    	}
		
		return this.courseDao.update(id, newCourse);
	}

	@Override
	public void delete(Course course) {
		this.courseDao.delete(course);
	}
}
