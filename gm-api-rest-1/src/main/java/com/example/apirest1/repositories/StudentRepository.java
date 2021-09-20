package com.example.apirest1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.apirest1.entities.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>{	

}
