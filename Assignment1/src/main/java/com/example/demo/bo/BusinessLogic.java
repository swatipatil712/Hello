package com.example.demo.bo;

import java.util.List;
import java.util.Optional;
import java.util.ArrayList;
import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.dto.StudentDto;
import com.example.demo.exception.StudentNotFound;
import com.example.demo.repository.StudentRepository;

@Component
public class BusinessLogic {
 @Autowired
public StudentRepository studentRepository;
 
 public List<StudentDto> callDBForHealthCheck() {
		List<StudentDto> customerdtolist = studentRepository.findAll();
		return customerdtolist;

	}
 
 
 
 public List<StudentDto> showAllEntries() throws StudentNotFound {

		List<StudentDto> studentdtolist = studentRepository.findAll();
		if (studentdtolist.isEmpty()) {
			throw new StudentNotFound();
		}
		return studentdtolist;
	}
 
 /*public StudentDto showEntry(int id) throws StudentNotFound {

		Optional<StudentDto> studentdto = studentRepository.findById(id);
		if (studentRepository.isPresent()) {
			throw new StudentNotFound();
		}

		return studentdto.get();
	}*/
 
 
 
}
