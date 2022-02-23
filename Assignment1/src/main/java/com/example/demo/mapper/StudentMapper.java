package com.example.demo.mapper;


import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.Mapping;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.example.demo.dto.StudentDto;
import com.example.demo.model.Student;
@Mapper(componentModel = "spring")
public interface StudentMapper {
	
	
	
	StudentMapper INSTANCE = Mappers.getMapper( StudentMapper.class );
	
	StudentDto studentToDto(Student student);
	
	Student dtoToStudent(StudentDto studentDto);

}
