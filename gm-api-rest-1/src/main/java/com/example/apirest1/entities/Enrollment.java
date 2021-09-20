package com.example.apirest1.entities;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;
import javax.persistence.ForeignKey;

@Entity
@Table(name="enrollments")
public class Enrollment {
	@EmbeddedId
	private EnrollmentId enrollmentId;
	
	@ManyToOne
	@MapsId("studentId")
	@JoinColumn(
			name="enrollment_student_id",
			foreignKey = @ForeignKey(
					name="enrolment_student_id_fk"
			)
	)
	private Student student;
	
	
	@ManyToOne
	@MapsId("courseId")
	@JoinColumn(
			name="enrollment_course_id",
			foreignKey = @ForeignKey(
					name="enrolment_course_id_fk"
			)
	)
	private Course course;
	
	
	@Column(
			name="enrollment_create_at",
			nullable = false
			)
	private LocalDateTime createAt;
}
