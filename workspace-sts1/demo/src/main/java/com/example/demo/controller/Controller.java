package com.example.demo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Student;
import com.example.demo.repository.Repo;
import com.example.demo.service.StudentServiceImpl;

@RestController
@RequestMapping("/student")
public class Controller {
	Logger log= LoggerFactory.getLogger(Controller.class);
	@Autowired
	StudentServiceImpl serviceImpl;
	
	@GetMapping("/get")  
	public List<Student> getAllStudent()
	{
		log.info("Students details obtained");
		return serviceImpl.getAllStudent();
		
	} 
	
	@GetMapping("/getbyid/{id}")
	public Student getStudentById(@PathVariable long id)
	{
		log.info("Student " +id+ "obtained");
		return serviceImpl.getStudentById(id);
	}
	
	@PostMapping("/add")
	public long addStudent(@RequestBody Student student)
	{
		serviceImpl.addStudent(student);
		log.info("Student added");
		return student.getId();
	}
	
	@PutMapping("/update/{id}")
	public long updateStudent(@RequestBody Student student)
	{ 
		log.info("Student updated");
		serviceImpl.updateStudent(student);
		
		return student.getId();
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteStudent(@PathVariable long id)
	{
		log.info("Student " +id+ "deleted");
		serviceImpl.deleteById(id);
	}
}
