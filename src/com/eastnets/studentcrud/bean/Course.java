package com.eastnets.studentcrud.bean;

import java.util.ArrayList;
import java.util.Collection;

import javax.faces.bean.ViewScoped;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "Courses")
@ViewScoped
public class Course {

	@Id
	@Column(name = "Id")
	private long id;
	@Column(name = "Course_Name")
	private String name;
	
	@Lob
	@Column(name = "Course_discription")
	private String courseDiscription;
	
	@ManyToMany(mappedBy = "courses")
	@JsonBackReference
	private Collection<Student> students = new ArrayList<>();

	public Course() {

	}

	public Course(long id, String name, String courseDiscription) {
		super();
		this.id = id;
		this.name = name;
		this.courseDiscription = courseDiscription;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCourseDiscription() {
		return courseDiscription;
	}

	public void setCourseDiscription(String courseDiscription) {
		this.courseDiscription = courseDiscription;
	}

	public Collection<Student> getStudents() {
		return students;
	}

	public void setStudents(Collection<Student> students) {
		this.students = students;
	}
	
	


	
	


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Course other = (Course) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Course [id=" + id + ", name=" + name + ", courseDiscription=" + courseDiscription + "]";
	}

}
