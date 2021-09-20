package com.example.apirest1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.apirest1.dto.CourseRequest;
import com.example.apirest1.entities.Course;
import com.example.apirest1.repositories.CourseRepository;


@Service
public class CourseService {
	@Autowired
	private CourseRepository courseRepository;
	
	public Course createCourse(CourseRequest courseRequest) {
		Course course = Course.builder().namee(courseRequest.getNamee()).build();
		return courseRepository.save(course);
	}	
}
