package com.fruta.btuco.service;

import java.util.List;

import com.fruta.btuco.exceptions.ResourceAlreadyExistsException;
import com.fruta.btuco.model.Student;

public interface StudentService {
	List<Student> findAll();

	Student find(String id);
	
	boolean exists(String id);
	
	Student save(Student student) throws ResourceAlreadyExistsException;
	
	Student update(String id, Student newStudent);
	
	void delete(Student student);
}
