package com.example.demo.controller;

import java.rmi.ServerException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.StudentDto;
import com.example.demo.exception.HealthCheckFailed;
import com.example.demo.exception.StudentNotAdded;
import com.example.demo.exception.StudentNotFound;
import com.example.demo.model.Student;
import com.example.demo.service.StudentService;

//import ch.qos.logback.classic.Logger;



@RestController
@RequestMapping("/student")
public class StudentController {
	@Autowired
	private StudentService studentService;
	
	Logger logger = LogManager.getLogger(StudentController.class);
	
	
	/*@PostMapping("/addStudent")
	public ResponseEntity<StudentDto> addStudent(@RequestBody StudentDto student) throws ServerException{
		logger.info("student added");
		StudentDto studentDto=studentService.createStudent(student);
		if(student==null) {
			throw new ServerException(null);
		} else {
		return ResponseEntity.status(HttpStatus.CREATED).body(student);
		}
	}*/
	@PostMapping(value="/addStudents")
	public ResponseEntity<Student> addStudent( @Validated @RequestBody Student student) throws StudentNotAdded{
		
		logger.info("Post mapping called for student:"+student.getId());
		Student addedStudent=studentService.addStudent(student);
		ResponseEntity<Student> response=new ResponseEntity<Student>(addedStudent, HttpStatus.OK);
		logger.info(addedStudent.getName()+" added");
		return response;
	
	}
	
	@GetMapping(value="/getAllStudents")
	public ResponseEntity<List<Student>> showAllStudents() throws StudentNotFound{
		
		logger.info("Get mapping called for all students");
		List<Student> studentList=studentService.getAllStudents();
		logger.info("students List fetched");
		return ResponseEntity.ok(studentList);

	}
	
	
	@GetMapping("/healthcheck")
	public ResponseEntity<String> healthCheck() throws HealthCheckFailed{
		
		logger.info("Health check called");
		String healthcheckstatus=studentService.healthCheckMethod();
		ResponseEntity<String> response=new ResponseEntity<String>("Health Check Succefull", HttpStatus.OK);
		return response;
	
	}
	
	


	
	
	

		
	/*@GetMapping("/getAllStudents")
	public ResponseEntity<List<StudentDto>> getAllStudents() throws ServerException{
		logger.info("get all students");
		List<StudentDto> list=studentService.getStudents();
		if(list.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}else {

	       return ResponseEntity.ok(list);
		}
	}*/
	
	
	/*@GetMapping("/getStudentById")
	public ResponseEntity<Student> showStudentById(int id) throws StudentNotFound{
		
		logger.info("Get mapping called for student by id");
		Student student =studentService.getStudentsById(id);
		logger.info("student fetched");
		return new ResponseEntity<Student>(student,HttpStatus.OK);

	}*/
	
	
	/*@GetMapping("/studentById/{id}")
	public StudentDto getStudById(@PathVariable int id) {
		return studentService.getStudentById(id);
	}*/
	

}
