package com.eastnets.studentcrud.bean;

import java.util.ArrayList;
import java.util.Collection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "Student_Data")
@ManagedBean(name = "student")
@RequestScoped
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id")
	private long id;

	@Size(min = 1, message = "First name can not be empty!")
	@Column(name = "First_Name")
	private String firstName;
	@Size(min = 1, message = "Last name can not be empty!")
	@Column(name = "Last_Name")
	private String lastName;

	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "city", column = @Column(name = "City")),
			@AttributeOverride(name = "country", column = @Column(name = "Country")) })
	private Address address = new Address();

	@Size(min = 1, message = "Email name can not be empty!")
	@Column(name = "Email")
	private String email;

	@ManyToMany
	@JoinTable(name = "Student_Course", joinColumns = @JoinColumn(name = "Student_ID"), inverseJoinColumns = @JoinColumn(name = "Course_ID"))
	@JsonManagedReference
	private Collection<Course> courses = new ArrayList<>();

	public Student() {
	}

	public Student(String firstName, String lastName, Address address, String email,Collection<Course> courses ) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.email = email;
		this.courses=courses;
	}

	public long getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
	public Collection<Course> getCourses() {
		return courses;
	}

	public void setCourses(Collection<Course> courses) {
		this.courses = courses;
	}

	public void emailCheck(FacesContext context, UIComponent component, Object value) {

		Pattern validEmailAdressREGEX = Pattern.compile("^[A-Z0-9._%+-]+@bau+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
		Matcher matcher = validEmailAdressREGEX.matcher(value.toString());
		if (!matcher.find()) {
			throw new ValidatorException(
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Invalid email.", "ex: example@bau.com"));
		}
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", address=" + address
				+ ", email=" + email + ", courses=" + courses + "]";
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
		Student other = (Student) obj;
		if (id != other.id)
			return false;
		return true;
	}


	
	
	
}
