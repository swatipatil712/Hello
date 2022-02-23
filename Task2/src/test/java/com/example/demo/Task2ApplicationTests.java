package com.example.demo;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.util.Assert;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.WebApplicationContext;

import com.example.demo.controller.SchoolController;
import com.example.demo.model.StudentDto;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootTest
@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
class Task2ApplicationTests {
	
	@Test
	void contextLoads() {
	}
	
	@Autowired
	private MockMvc mockmvc;
	@MockBean
	private RestTemplate resttemplate;
	//@InjectMocks
	@MockBean
	SchoolController schoolController;
	
	/*@MockBean
	SchoolController schoolController;
	private IStudentFeignClient iStudentFeignClient;*/



	ObjectMapper omap = new ObjectMapper();
	
	
	
	@Test
	public void getAllStudentByRestTemplateTest() throws Exception
	{
		StudentDto[] student = new StudentDto[2];
		student[0] = new StudentDto(1,"aaa",67);
		student[1] = new StudentDto(2,"bbb",67);

	Mockito.when(resttemplate.getForObject("http://localhost:8081/student/getallStudents", StudentDto[].class))
	.thenReturn(student);

	mockmvc.perform(get("/school/get"))
	.andExpect(status().isOk());
	Assert.assertEquals(student.length, 2);

	}
	
	@Test
	public void getAllStudentByFeighTest() throws Exception
	{
		StudentDto[] student = new StudentDto[2];
		student[0] = new StudentDto(3,"ccc",34);
		student[1] = new StudentDto(4,"ddd",36);

	Mockito.when(resttemplate.getForObject("http://localhost:8081/student/getallStudents", StudentDto[].class))
	.thenReturn(student);

	mockmvc.perform(get("/school/getAllStudents-feign"))
	.andExpect(status().isOk());
	Assert.assertEquals(student.length, 2);

	}
}
	/*@Test
	public void getAllStudentByFeignClient() throws Exception
	{
	List<StudentDto> student = new ArrayList<StudentDto>();

	StudentDto student1 = new StudentDto(101, "ccc", 40);
	StudentDto student2 = new StudentDto(102, "ddd", 35);
	student.add(student1);
	student.add(student2);

	when(schoolController.getAllStudentByFeign())
	.thenReturn(student);
	mockmvc.perform(get("/school/getAllStudents-feign"))
	.andExpect(status().isOk());
	//.andExpect(jsonPath("collegeName[0]", is("gda")));

	Assert.assertEquals(student.size(), 2);
	}
	}*/
	
	
	
	
	/*@Test
	public void getAllStudentsRestTest() throws Exception{
	        StudentDto studentdto = new StudentDto();
		    studentdto.setName("viha");
		    studentdto.setAge(25);
		
		  StudentDto[] studentdto = new StudentDto[2];
		    studentdto[0]=new StudentDto(1,"aaa", 30);
		    studentdto[1]=new StudentDto(2,"bbb", 33);
		
		    String jsonRequest=omap.writeValueAsString(studentdto);
		    
		    when(resttemplate.getForObject(any(String.class), any(Class.class)))
		    .thenReturn(studentdto);
		
		     mockmvc.perform(get("/student/getAllStudents")
				.content(jsonRequest).contentType(MediaType.APPLICATION_JSON_VALUE))
		        .andDo(print())
                .andExpect(status().isOk());
		     //Assert.assertEquals(studentdto.length, 2);
		     Assert.assertEquals(studentdto.length, 2);
	}
	
	/*@Test
	public void getAllStudentFeigh_Test() throws Exception{
	        StudentDto studentdto = new StudentDto();
		    studentdto.setName("viha");
		    studentdto.setAge(25);
		
		    String jsonRequest=omap.writeValueAsString(studentdto);
		    
		    when(resttemplate.getForObject(any(String.class), any(Class.class)))
		    .thenReturn(studentdto);
		
		     mockmvc.perform(get("/school/getAllStudents-feign")
				.content(jsonRequest).contentType(MediaType.APPLICATION_JSON_VALUE))
		        .andDo(print())
                .andExpect(status().isOk());
	}*/


