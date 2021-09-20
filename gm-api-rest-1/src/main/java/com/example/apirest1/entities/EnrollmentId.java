package com.example.apirest1.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class EnrollmentId implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Column(name="enrollment_student_id")
	private Long studentId;
	
	
	@Column(name="enrollment_course_id")
	private Long courseId;
	

}
