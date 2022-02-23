package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.SchoolRepository;
import com.example.demo.model.School;


@Service
public class SchoolServiceImpl implements SchoolService{
	
	@Autowired
	private SchoolRepository schoolRepository;

	@Override
	public School createSchool(School school) {
		// TODO Auto-generated method stub
		return null;
	}

	

	

}
