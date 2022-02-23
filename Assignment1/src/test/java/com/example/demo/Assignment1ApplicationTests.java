package com.example.demo;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.aspectj.lang.annotation.Before;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoSettings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.example.demo.dto.StudentDto;
import com.example.demo.model.Student;
import com.example.demo.service.StudentService;
import com.fasterxml.jackson.databind.ObjectMapper;





@SpringBootTest
@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
class Assignment1ApplicationTests {

	@MockBean
	StudentService studentservice;	
	
	@Autowired
	private MockMvc mockmvc;
	@Autowired
	private WebApplicationContext webcontext;
	
	ObjectMapper omap = new ObjectMapper();
	
	@org.junit.Before
	private void setUp() {
		
		mockmvc=MockMvcBuilders.webAppContextSetup(webcontext).build();
	}
	@Test
	void contextLoads() {
	}
	
	/*@Test
	public void createStudentTest() throws Exception{
		StudentDto studentdto = new StudentDto();

		studentdto.setName("mahi");
		studentdto.setAge(30);
		
		String jsonRequest=omap.writeValueAsString(studentdto);
		
		     mockmvc.perform(post("/student/addStudents")
				.content(jsonRequest).contentType(MediaType.APPLICATION_JSON_VALUE)
		         .accept(MediaType.APPLICATION_JSON)).andDo(print())
                 .andExpect(status().isCreated());
	}*/
	
	@Test
    void createStudentTest() throws Exception {
		Student student = new Student(10,"asddf",45);
       String jsonRequest = omap.writeValueAsString(student);
       Mockito.when(studentservice.addStudent(student)).thenReturn(student);
       mockmvc.perform(MockMvcRequestBuilders.post("/student/addStudents").content(jsonRequest)
               .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
               .andExpect(status().isCreated());

   }
	
	@Test
	public void getAllStudentsTest() throws Exception{
	       //StudentDto[] studentdto = new StudentDto[2];
		    //studentdto[0]=new StudentDto(1,"aaa", 30);
		    //studentdto[1]=new StudentDto(2,"bbb", 33);
		
		     List<Student> student=new ArrayList<Student>();
		     Student s1=new Student(1,"sassd",34);
		     Student s2=new Student(2,"hhhh",36);
		     student.add(s1);
		     student.add(s2);
		     
		    //String jsonRequest=omap.writeValueAsString(student);
		    Mockito.when(studentservice.getAllStudents()).thenReturn(student);
		
		     mockmvc.perform(get("/student/getAllStudents"))
                .andExpect(status().isOk());
		     
		    
		   Assert.assertEquals(student.size(), 2);
	}
	
	
	
	
	/*@Test
	public void getAllStudentsTest() throws Exception
	{
	Student student = new Student();
	student.setId(100);
	student.setName("xxxx");
	student.setAge(60);
	
	mockmvc.perform(get("/student/getallStudents")
	.contentType(MediaType.APPLICATION_JSON_VALUE))
	.andDo(print())
	.andExpect(status()
	.isOk());
	}
	
	@Test
	public void addStudentTest() throws Exception
	{
	Student stud = new Student();
	stud.setId(1);
	stud.setName("fff");
	stud.setAge(45);
	
	String jsonRequest = omap.writeValueAsString(stud);
	mockmvc.perform(post("/student/addStudents")
	.content(jsonRequest)
	.contentType(MediaType.APPLICATION_JSON_VALUE)
	.accept(MediaType.APPLICATION_JSON))
	.andDo(print())
	.andExpect(status()
	.isCreated());



	}*/
	
}
