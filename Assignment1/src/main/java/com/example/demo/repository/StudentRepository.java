package com.example.demo.repository;



import org.apache.logging.log4j.Logger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.dto.StudentDto;


@Repository
public interface StudentRepository extends JpaRepository<StudentDto, Integer>{

	//boolean isPresent();
	
	
}
