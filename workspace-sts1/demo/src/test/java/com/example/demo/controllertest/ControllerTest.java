package com.example.demo.controllertest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.demo.controller.Controller;
import com.example.demo.model.Student;
import com.example.demo.service.StudentServiceImpl;

public class ControllerTest {

    @Mock
    private StudentServiceImpl serviceImplMock;

    @InjectMocks
    private Controller controller;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAllStudent() {
        // Arrange
        List<Student> expectedStudents = Arrays.asList(new Student(1, "John", null, 0), new Student(2, "Jane", null, 0));
        when(serviceImplMock.getAllStudent()).thenReturn(expectedStudents);

        // Act
        List<Student> actualStudents = controller.getAllStudent();

        // Assert
        assertEquals(expectedStudents, actualStudents);
    }

    @Test
    public void testGetStudentById() {
        // Arrange
        long studentId = 1;
        Student expectedStudent = new Student(studentId, "John", null, studentId);
        when(serviceImplMock.getStudentById(studentId)).thenReturn(expectedStudent);

        // Act
        Student actualStudent = controller.getStudentById(studentId);

        // Assert
        assertEquals(expectedStudent, actualStudent);
    }

    @Test
    public void testAddStudent() {
        // Arrange
        Student studentToAdd = new Student(3, "Alice", null, 0);

        // Act
        long addedStudentId = controller.addStudent(studentToAdd);

        // Assert
        assertEquals(studentToAdd.getId(), addedStudentId);
        verify(serviceImplMock, times(1)).addStudent(studentToAdd);
    }

    @Test
    public void testUpdateStudent() {
        // Arrange
        long studentId = 2;
        Student studentToUpdate = new Student(studentId, "Bob", null, studentId);

        // Act
        long updatedStudentId = controller.updateStudent(studentToUpdate);

        // Assert
        assertEquals(studentToUpdate.getId(), updatedStudentId);
        verify(serviceImplMock, times(1)).updateStudent(studentToUpdate);
    }

    @Test
    public void testDeleteStudent() {
        // Arrange
        long studentId = 3;

        // Act
        controller.deleteStudent(studentId);

        // Assert
        verify(serviceImplMock, times(1)).deleteById(studentId);
    }
}
