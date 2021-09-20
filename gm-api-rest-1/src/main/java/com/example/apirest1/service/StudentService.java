package com.example.apirest1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.apirest1.dto.StudentRequest;
import com.example.apirest1.entities.Student;
import com.example.apirest1.repositories.StudentRepository;

@Service
public class StudentService {
	
	@Autowired
	private StudentRepository studentRepository;
	
	public Student createStudent(StudentRequest studentRequest) {
		Student student = Student.builder().firstName(studentRequest.getFirstName()).email(studentRequest.getEmail()).build();
		return studentRepository.save(student);
	}
}
