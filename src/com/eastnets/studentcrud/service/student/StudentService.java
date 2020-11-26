package com.eastnets.studentcrud.service.student;

import java.util.List;

import com.eastnets.studentcrud.bean.Student;

public interface StudentService {

	public abstract void add(Student student);

	public abstract void remove(long studentId);

	public abstract void update(Student student);

	public abstract Student getStudent(long studentId);

	public abstract List<Student> getAllStudents();

}
