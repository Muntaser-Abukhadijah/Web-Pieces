package com.eastnets.studentcrud.service.student.impl;

import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.inject.Named;

import com.eastnets.studentcrud.bean.Student;
import com.eastnets.studentcrud.dao.StudentDAO;
import com.eastnets.studentcrud.dao.impl.StudentDAOImpl;
import com.eastnets.studentcrud.service.student.StudentService;

@ManagedBean()
@ApplicationScoped
public class StudentServiceImpl implements StudentService {

	StudentDAO studentDAO = new StudentDAOImpl();
	
	
	@Override
	public void add(Student student) {
		studentDAO.add(student);
	}

	@Override
	public void remove(long studentId) {
		studentDAO.remove(studentId);
	}

	@Override
	public void update(Student student) {
		studentDAO.update(student);
	}

	@Override
	public Student getStudent(long studentId) {
		return studentDAO.getStudent(studentId);
	}

	@Override
	public List<Student> getAllStudents() {
		return studentDAO.getAllStudents();
	}
}
