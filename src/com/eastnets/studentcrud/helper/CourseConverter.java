package com.eastnets.studentcrud.helper;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import com.eastnets.studentcrud.bean.Course;
import com.eastnets.studentcrud.service.course.CourseService;
import com.eastnets.studentcrud.service.course.impl.CourseServiceImpl;

@ManagedBean
@RequestScoped
@FacesConverter("com.eastnets.studentcrud.CourseConverter")
public class CourseConverter implements Converter {

	private CourseService courseService = new CourseServiceImpl();

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {

		
		if (value == null || value.isEmpty()) {
			return null;
		}

		try {
			System.out.println(courseService.getCourse(Long.valueOf(value)));
			return courseService.getCourse(Long.valueOf(value));
		} catch (NumberFormatException e) {
			throw new ConverterException(new FacesMessage(String.format("%s is not a valid User ID", value)), e);
		}
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {

		
		if (value == null) {
			return "";
		}
	
		if (value instanceof Course) {
			return String.valueOf(((Course) value).getId());
		} else {
			throw new ConverterException(new FacesMessage(String.format("%s is not a valid User", value)));
		}
	}

}
