package com.eastnets.studentcrud.driver;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.eastnets.studentcrud.bean.Address;
import com.eastnets.studentcrud.bean.Course;
import com.eastnets.studentcrud.bean.Student;
import com.eastnets.studentcrud.dao.StudentDAO;
import com.eastnets.studentcrud.dao.impl.StudentDAOImpl;
import com.eastnets.studentcrud.service.course.CourseService;
import com.eastnets.studentcrud.service.course.impl.CourseServiceImpl;
import com.eastnets.studentcrud.service.jms.StudentProducer;
import com.eastnets.studentcrud.service.student.StudentService;
import com.eastnets.studentcrud.service.student.impl.StudentServiceImpl;
import com.eastnets.studentcrud.view.StudentView;

public class Main {

	public static void main(String[] args) {

//		StudentDAO studentDAO = new StudentDAOImpl();
//		Address address = new Address("Amman","Jordan");
//		Student student =new Student("Muntaser", "Abukhadijah",address,"m@gmail.com");
//		studentDAO.add(student);

//	System.out.println(studentDAO.getStudent(1));
//	System.out.println(studentDAO.getAllStudents());

//		studentDAO.remove(12);

//		Student temp = studentDAO.getStudent(2);
//		temp.setFirstName("ANAS");
//		studentDAO.update(temp);

//		StudentService studentService =new StudentServiceImpl();

//		System.out.println(studentService.getAllStudents());

//		StudentView studentView =new StudentView();
//		System.out.println(studentView.getStudents());

		CourseService courseService = new CourseServiceImpl();
//
//		Course course = new Course(1110, " Introduction to Computer Science",
//				"Introduction to computer science and the study of algorithms; foundational ideas, computer organization, software concepts (e.g., networking, databases, security); programming concepts using Python. GE: Quantitative or Formal Reasoning.");
//		Course course2 = new Course(2620, "Networking and Security for Informatics",
//				"Introduction to computer networking, overview of network organization and management; basic understanding of encryption and network security; practical experience in network programming. Prerequisites: CS:2110 with a minimum grade of C-.");
//		Course course3 = new Course(2630, "Computer Organization",
//				"Competitive programming is a mind sport usually held over the Internet or a local network, involving participants trying to program according to provided specifications. Contestants are referred to as sport programmers. Competitive programming is recognized and supported by several multinational software and Internet companies, such as Google and Facebook. There are several organizations who host programming competitions on a regular basis.");
//		Course course4 = new Course(5438, "Object Oriented Programming",
//				"Computer building blocks: representing data, computer arithmetic, instruction sets, assembly language, digital logic, control units, ALU design, register operations, memory organization, IO.");
		Course course5 = new Course(1153, "C#",
				"C# is a modern, object-oriented programming language intended to create simple yet robust programs. Designed specifically to take advantage of CLI features, C# is the core language of the Microsoft . NET framework.");
		Course course6 = new Course(4252, "Web Development",
				"Throughout the course students are introduced to planning and designing effective web pages; implementing web pages by writing HTML and CSS code; enhancing web pages with the use of page layout techniques, text formatting, graphics, images, and multimedia; and producing a functional, multi-page website.");
//
//		courseService.add(course);
//		courseService.add(course2);
//		courseService.add(course3);
//		courseService.add(course4);
		courseService.add(course5);
		courseService.add(course6);

//		Course course =courseService.getCourse(5837);
//		System.out.println(course);
//		courseService.getAllCourses();

//		StudentService studentService = new StudentServiceImpl();
//		
//		Address address = new Address("Amman", "Jordan");
//		Collection<Course> courses = courseService.getAllCourses();
//		Student student = new Student("Esraa", "Ali", address, "Esraa@bau.com", courses);
//		studentService.add(student);

//		new StudentProducer().produceStudentMessage(student);
	}

}
