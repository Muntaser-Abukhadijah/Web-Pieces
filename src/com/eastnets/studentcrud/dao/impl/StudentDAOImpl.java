package com.eastnets.studentcrud.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.eastnets.studentcrud.bean.Student;
import com.eastnets.studentcrud.dao.StudentDAO;

public class StudentDAOImpl implements StudentDAO {

	private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("UniversityEntities");
	private EntityManager entityManager = entityManagerFactory.createEntityManager();

	@Override
	public void add(Student student) {
		entityManager.getTransaction().begin();
		entityManager.persist(student);
		entityManager.getTransaction().commit();
	}

	@Override
	public void remove(long studentId) {

		entityManager.getTransaction().begin();
		Student student = entityManager.find(Student.class, studentId);
		entityManager.remove(student);
		entityManager.getTransaction().commit();
	}

	@Override
	public void update(Student student) {

		entityManager.getTransaction().begin();
		Student studentToBeEdit = entityManager.find(Student.class, student.getId());
		studentToBeEdit.setFirstName(student.getFirstName());
		studentToBeEdit.setLastName(student.getLastName());
		studentToBeEdit.setAddress(student.getAddress());
		studentToBeEdit.setEmail(student.getEmail());
		entityManager.getTransaction().commit();

	}

	@Override
	public Student getStudent(long studentId) {
		return entityManager.find(Student.class,studentId );
	}

	@Override
	public List<Student> getAllStudents() {
		return entityManager.createQuery("FROM Student", Student.class).getResultList();
	}

}
