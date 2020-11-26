package com.eastnets.studentcrud.service.course.impl;

import java.util.List;

import com.eastnets.studentcrud.bean.Course;
import com.eastnets.studentcrud.dao.CourseDAO;
import com.eastnets.studentcrud.dao.impl.CourseDAOImpl;
import com.eastnets.studentcrud.service.course.CourseService;

public class CourseServiceImpl implements CourseService {

	CourseDAO courseDAO = new CourseDAOImpl();

	@Override
	public void add(Course course) {
		courseDAO.add(course);
	}

	@Override
	public void remove(long courseId) {
		courseDAO.remove(courseId);
	}

	@Override
	public void update(Course course) {
		courseDAO.update(course);

	}

	@Override
	public Course getCourse(long courseId) {
		return courseDAO.getCourse(courseId);
	}

	@Override
	public List<Course> getAllCourses() {
		return courseDAO.getAllCourses();
	}

}