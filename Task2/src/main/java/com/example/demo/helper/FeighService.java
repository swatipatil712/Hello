package com.example.demo.helper;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.model.StudentDto;



@FeignClient(url="http://localhost:8081/",name="studentclient")
public interface FeighService {
	@GetMapping("student/getAllStudents")
	public ResponseEntity<List<StudentDto>> getStudentList() throws  com.example.demo.controller.ServiceException;

	

}
