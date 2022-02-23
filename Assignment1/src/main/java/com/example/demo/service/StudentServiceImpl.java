package com.example.demo.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.bo.BusinessLogic;
import com.example.demo.dto.StudentDto;
import com.example.demo.exception.StudentNotAdded;
import com.example.demo.exception.StudentNotFound;
import com.example.demo.mapper.StudentMapper;
import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService{
	
	Logger logger = LogManager.getLogger(StudentServiceImpl.class);
	
	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	StudentMapper studentMapper;
	
	
	
	
	@Autowired
	BusinessLogic studentBo;

	/*@Override
	public StudentDto createStudent(StudentDto studentDto) {
		logger.info("addStudentDto called in service layer"); 
		
		return studentRepository.save(studentDto);
	}
	@Override
	public Student addStudent(Student student) throws StudentNotAdded {
		// TODO Auto-generated method stub
		return null;
	}
	

	@Override
	public StudentDto getStudentById(int id) {
		
		return studentRepository.findById(id).orElse(null);
	}

	@Override
	public List<StudentDto> getStudents() {
		
		return studentRepository.findAll();
	}*/

	@Override
	public String healthCheckMethod() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Student addStudent(Student student) throws StudentNotAdded {
		logger.info("addstudentDto called in service layer"); 
			
		StudentDto saveStudent=studentRepository.save(studentMapper.studentToDto(student));
		  
		//StudentDto studentdtoadded;
	    return studentMapper.dtoToStudent(saveStudent); 
	}

	@Override
	public List<Student> getAllStudents() throws StudentNotFound{
		logger.info("showAllEntries called in service layer");
		 
			
		  List<StudentDto> studentDtoList = studentRepository.findAll(); 
		  if(studentDtoList.isEmpty()) { throw new StudentNotFound(); }
		  Iterator<StudentDto> dtoiterator = studentDtoList.iterator();
		  List<Student> studentList = new ArrayList<Student>();
		  
		  while (dtoiterator.hasNext()) {
			  studentList.add(studentMapper.dtoToStudent(dtoiterator.next())); }
		  
		  return studentList;
	}

	/*@Override
	public Student getStudentsById(int id) throws StudentNotFound{
		Student student = studentMapper.dtoToStudent(studentBo.showEntry(id));
		return student;
	}*/

	

	

}
