package com.eastnets.studentcrud.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.eastnets.studentcrud.bean.Course;
import com.eastnets.studentcrud.bean.Student;
import com.eastnets.studentcrud.dao.CourseDAO;

public class CourseDAOImpl implements CourseDAO {

	private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("UniversityEntities");
	private EntityManager entityManager = entityManagerFactory.createEntityManager();

	@Override
	public void add(Course course) {
		entityManager.getTransaction().begin();
		entityManager.persist(course);
		entityManager.getTransaction().commit();
	}

	@Override
	public void remove(long courseId) {
		entityManager.getTransaction().begin();
		Course course = entityManager.find(Course.class, courseId);
		entityManager.remove(course);
		entityManager.getTransaction().commit();
	}

	@Override
	public void update(Course course) {
		entityManager.getTransaction().begin();
		Course courseToBeEdit = entityManager.find(Course.class, course.getId());
		courseToBeEdit.setName(course.getName());
		courseToBeEdit.setCourseDiscription(course.getCourseDiscription());
		courseToBeEdit.setStudents(course.getStudents());
		entityManager.getTransaction().commit();
	}

	@Override	
	public Course getCourse(long courseId) {
		return entityManager.find(Course.class,courseId );
	}

	@Override
	public List<Course> getAllCourses() {
		return entityManager.createQuery("FROM Course", Course.class).getResultList();
	}

}
