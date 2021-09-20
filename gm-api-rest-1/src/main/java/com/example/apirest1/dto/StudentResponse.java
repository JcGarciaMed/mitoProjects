package com.example.apirest1.dto;

import javax.persistence.Column;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentResponse {
	private Long id;
	private String firstName;
	private String email;	
}
