package com.example.demo.service;


import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.demo.model.Student;

@Service
@Component
public interface StudentService {
public List<Student> getAllStudent();
public Student getStudentById(long id);
public Student addStudent(Student student);
public void deleteById(long id);
public Student updateStudent(Student student);
}
