package com.eastnets.studentcrud.service.course;

import java.util.List;

import com.eastnets.studentcrud.bean.Course;

public interface CourseService {

	public abstract void add(Course course);

	public abstract void remove(long courseId);

	public abstract void update(Course course);

	public abstract Course getCourse(long courseId);

	public abstract List<Course> getAllCourses();

}
