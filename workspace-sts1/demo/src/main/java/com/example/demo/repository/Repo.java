package com.example.demo.repository;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Student;



@Repository
public interface Repo extends MongoRepository<Student,Long> {

	
}
