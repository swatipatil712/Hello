package com.example.demo.mapper;

import org.springframework.stereotype.Component;

import com.example.demo.dto.StudentDto;
import com.example.demo.model.Student;
@Component
public class StudentMapperImpl implements StudentMapper{

	@Override
	public StudentDto studentToDto(Student student) {

        if ( student == null ) {
            return null;
        }

        StudentDto studentDto = new StudentDto();

        studentDto.setId( student.getId() );
        studentDto.setName( student.getName() );
        studentDto.setAge(student.getAge());
        return studentDto;
        
	}

	@Override
	public Student dtoToStudent(StudentDto studentDto) {
		if ( studentDto == null ) {
            return null;
        }

		Student student = new Student();

		student.setId( studentDto.getId() );
		student.setName( studentDto.getName() );
		student.setAge(studentDto.getAge());

        return student;

	}

}
