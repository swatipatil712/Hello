package com.example.demo.dto;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
public class StudentDto {
	@Id
	@GeneratedValue
	private int id;
	private String name;
	private int age;
	
	
	
	
	public StudentDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public StudentDto(int id, String name, int age) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
	}
	

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}


	
	

}
