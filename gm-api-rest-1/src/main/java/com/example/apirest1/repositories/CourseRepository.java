package com.example.apirest1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.apirest1.entities.Course;


@Repository
public interface CourseRepository extends JpaRepository<Course, Long>{
	
}
