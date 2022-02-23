package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.StudentDto;
import com.example.demo.exception.HealthCheckFailed;
import com.example.demo.exception.StudentNotAdded;
import com.example.demo.exception.StudentNotFound;
import com.example.demo.model.Student;


public interface StudentService {

	/*public StudentDto createStudent(StudentDto studentDto) throws StudentNotAdded;

	public StudentDto getStudentById(int id) throws StudentNotFound;

	public List<StudentDto> getStudents() throws StudentNotFound;*/
	
	/*public Student createStudent(Student student) throws StudentNotAdded;

	public StudentDto getStudentById(int id) throws StudentNotFound;

	public List<StudentDto> getStudents() throws StudentNotFound;*/


	
	
	public String healthCheckMethod() throws HealthCheckFailed;

	public Student addStudent(Student student) throws StudentNotAdded;

	public List<Student> getAllStudents();

	//public Student getStudentsById(int id);

}
