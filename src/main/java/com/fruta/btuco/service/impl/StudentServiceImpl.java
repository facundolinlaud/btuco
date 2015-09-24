package com.fruta.btuco.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fruta.btuco.dao.StudentDao;
import com.fruta.btuco.exceptions.ResourceAlreadyExistsException;
import com.fruta.btuco.exceptions.ResourceNotFoundException;
import com.fruta.btuco.model.Student;
import com.fruta.btuco.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	private StudentDao studentDao;

	@Override
	public List<Student> findAll() {
		return studentDao.findAll();
	}

	@Override
	public Student find(String id) {
		Student student = studentDao.find(id);
		if (student == null) {
			throw new ResourceNotFoundException("Student with id " + id + " not found");
		}
		return student;
	}
	
	@Override
	public boolean exists(String id) {
		return studentDao.find(id) != null;
	}

	@Override
	public Student save(Student student) throws ResourceAlreadyExistsException {
		if (this.studentDao.find(student.getId()) != null) {
			throw new ResourceAlreadyExistsException("Student with id " + student.getId() + " already exists");
		}
		
		return this.studentDao.save(student);
	}

	@Override
	public Student update(String id, Student newStudent) {
    	
    	if (!id.equals(newStudent.getId()) && this.exists(newStudent.getId())) {
    		throw new ResourceAlreadyExistsException("Student with id " + newStudent.getId().toString() + " already exists");
    	}
		
		return this.studentDao.update(id, newStudent);
	}

	@Override
	public void delete(Student student) {
		this.studentDao.delete(student);
	}
}
