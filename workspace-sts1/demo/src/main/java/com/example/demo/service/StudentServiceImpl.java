package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Student;
import com.example.demo.repository.Repo;

@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	Repo repo;
 
	@Override
	public List<Student> getAllStudent() {
		return repo.findAll();
	}

	@Override
	public Student getStudentById(long id) {
		return repo.findById(id).get();	}

	@Override
	public Student addStudent(Student student) {
		return repo.insert(student);
	} 

	@Override
	public void deleteById(long id) {
		repo.deleteById(id);
		
	}

	@Override
	public Student updateStudent(Student student) {
		return repo.save(student);
	}

}
