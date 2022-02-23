package com.example.demo.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.demo.config.RestConfig;

import com.example.demo.helper.FeighService;
import com.example.demo.model.School;
import com.example.demo.model.StudentDto;
import com.example.demo.service.SchoolService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RestController
@RequestMapping("/school")
public class SchoolController {
	@Autowired
	private SchoolService schoolService;
	@Autowired
	RestTemplate restTemplate;
	@Autowired
	FeighService feighService;
	
	@Autowired
	RestConfig restConfig;
	
	public static final String STUDENT_SERVICE_BY_REST_TEMPLATE="getAllStudentFallbackRestTemplate";
	public static final String STUDENT_SERVICE_BY_FEIGH="getAllStudentFallbackByFeigh";
	
	
	
	/*@Value("${user.provider.url}")
	private String url;*/
	
	
	
	@GetMapping("/getbyresttemplate")
	@CircuitBreaker(name=STUDENT_SERVICE_BY_REST_TEMPLATE, fallbackMethod="getAllStudentFallbackRestTemplate")
	public List<StudentDto> getAllStudents() {
		//StudentDto[] stud = restTemplate.getForObject(restConfig.getRestUrl(), StudentDto[].class);
		StudentDto[] stud = restTemplate.getForObject("http://localhost:9090/student/getAllStudents", StudentDto[].class);
		return Arrays.asList(stud);
	}
	public ResponseEntity<String> getAllStudentFallbackByRestTemplate(Exception e){
	return new ResponseEntity<String>("student service down when fetching by rest template", HttpStatus.OK);
	}
	

	
	@GetMapping("/getallstudentsbyfeign")
	@CircuitBreaker(name=STUDENT_SERVICE_BY_FEIGH, fallbackMethod="getAllStudentFallbackByFeigh")
	public ResponseEntity<List<StudentDto>> getAllStudentsUsingFeign() throws ServiceException {
		return feighService.getStudentList();
	}
	public ResponseEntity<String> getAllStudentFallbackByFeigh(Exception e){
		return new ResponseEntity<String>("student service down when fetching by feigh service", HttpStatus.OK);
		}
			
	/*@GetMapping("/getbyresttemplate")
	//@CircuitBreaker(name=)
	public List<StudentDto> getAllStudents() {
		StudentDto[] stud = restTemplate.getForObject(constants.getUrlString(), StudentDto[].class);
		
		return Arrays.asList(stud);
	}*/
}
