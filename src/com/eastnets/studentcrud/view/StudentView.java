package com.eastnets.studentcrud.view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.RowEditEvent;

import com.eastnets.studentcrud.bean.Course;
import com.eastnets.studentcrud.bean.Student;
import com.eastnets.studentcrud.service.course.CourseService;
import com.eastnets.studentcrud.service.course.impl.CourseServiceImpl;
import com.eastnets.studentcrud.service.jms.StudentProducer;
import com.eastnets.studentcrud.service.student.StudentService;
import com.eastnets.studentcrud.service.student.impl.StudentServiceImpl;

@ManagedBean(name = "studentView")
@SessionScoped
public class StudentView implements Serializable { // Tell me again, why do we
													// use serializable

	private List<Student> students;
	private StudentService studentService = new StudentServiceImpl();
	private Student student = new Student();
	private CourseService courseService = new CourseServiceImpl();
	private List<Course> courses = courseService.getAllCourses();;
	private List<Course> selectedCourses;
	private boolean send;
	private String courseDiscription;

	public List<Course> getSelectedCourses() {
		return selectedCourses;
	}

	public void setSelectedCourses(List<Course> selectedCourses) {
		this.selectedCourses = selectedCourses;
	}

	
	public String getCourseDiscription() {
		return courseDiscription;
	}

	public void setCourseDiscription(String courseDiscription) {
		this.courseDiscription = courseDiscription;
	}


	public boolean isSend() {
		return send;
	}

	public void setSend(boolean send) {
		this.send = send;
	}

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

	public List<Student> getStudents() {
		students = studentService.getAllStudents();
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	public StudentService getStudentService() {
		return studentService;
	}

	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}

	public void onRowEdit(RowEditEvent<Student> event) {
		studentService.update(event.getObject());
		FacesMessage msg = new FacesMessage("Student Edited", String.valueOf(event.getObject().getId()));
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public void onRowCancel(RowEditEvent<Student> event) {
		FacesMessage msg = new FacesMessage("Edit Cancelled", String.valueOf(event.getObject().getId()));
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public void addStudent(Student student) {

		Collection<Course> courses = getCoursesFromIds();
		student.setCourses(courses);

		studentService.add(student);
		if (isSend()) {
			StudentProducer.produceStudentMessage(student);
			setSend(false);
		}

		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage("Successful", "New student added"));
	}

	public void deleteStudent(Student student) {
		studentService.remove(student.getId());
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	private List<Course> getCoursesFromIds() {
		List<Course> courses = new ArrayList<Course>();

		selectedCourses.forEach(c -> courses.add(c));
		
		selectedCourses=null;
		
		return courses;
	}

	public void onCourseChange() {
		System.out.println(courseDiscription + "n");
	}
}