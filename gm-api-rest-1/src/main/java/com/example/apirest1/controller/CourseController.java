package com.example.apirest1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.apirest1.dto.CourseRequest;
import com.example.apirest1.dto.CourseResponse;
import com.example.apirest1.service.CourseService;
import com.example.apirest1.util.EntityDtoConverter;


@RestController
public class CourseController {
	
	@Autowired 
	private CourseService courseService;
	
	@Autowired
	private EntityDtoConverter converter;
	
	@PostMapping("/courses")
	public ResponseEntity<CourseResponse> createCourse(@RequestBody CourseRequest payload){
		return new ResponseEntity<CourseResponse>(converter.convertCourseToDto(courseService.createCourse(payload)),HttpStatus.CREATED);
	}	
}
