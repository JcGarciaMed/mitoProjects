package com.example.apirest1.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.apirest1.dto.StudentRequest;
import com.example.apirest1.dto.StudentResponse;
import com.example.apirest1.service.StudentService;
import com.example.apirest1.util.EntityDtoConverter;


@RestController
public class StudentController {
	
	@Autowired
	public StudentService studentService;
	
	@Autowired
	private EntityDtoConverter converter;	
	
	@PostMapping("/students")
	public ResponseEntity<StudentResponse> createStudent(@RequestBody StudentRequest payload){
		return new ResponseEntity<StudentResponse>(converter.convertStudentToDto(studentService.createStudent(payload)),HttpStatus.CREATED);
	}
}
