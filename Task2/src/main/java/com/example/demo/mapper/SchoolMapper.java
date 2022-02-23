package com.example.demo.mapper;


import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.web.bind.annotation.Mapping;
@Mapper
public interface SchoolMapper {
	
	SchoolMapper INSTANCE = Mappers.getMapper( SchoolMapper.class );

}
