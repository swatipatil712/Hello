package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.School;
@Repository
public interface SchoolRepository extends JpaRepository<School, Integer>{

}
