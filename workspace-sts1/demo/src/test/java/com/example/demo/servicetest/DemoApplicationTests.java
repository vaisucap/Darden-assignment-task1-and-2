package com.example.demo.servicetest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock; 
import org.mockito.MockitoAnnotations;

import com.example.demo.model.Student;
import com.example.demo.repository.Repo;
import com.example.demo.service.StudentServiceImpl;
 
public class DemoApplicationTests {

    @Mock
    private Repo repoMock;

    @InjectMocks
    private StudentServiceImpl studentService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAllStudents() {
        // Arrange
        List<Student> expectedStudents = Arrays.asList(new Student(1, "John", null, 0), new Student(2, "Jane", null, 0));
        when(repoMock.findAll()).thenReturn(expectedStudents);

        // Act
        List<Student> actualStudents = studentService.getAllStudent();

        // Assert
        assertEquals(expectedStudents, actualStudents);
    }

    @Test
    public void testGetStudentById() {
        // Arrange
        long studentId = 1;
        Student expectedStudent = new Student(studentId, "John", null, studentId);
        when(repoMock.findById(studentId)).thenReturn(Optional.of(expectedStudent));

        // Act
        Student actualStudent = studentService.getStudentById(studentId);

        // Assert
        assertEquals(expectedStudent, actualStudent);
    }

    @Test
    public void testAddStudent() {
        // Arrange
        Student studentToAdd = new Student(3, "Alice", null, 0);
        when(repoMock.insert(studentToAdd)).thenReturn(studentToAdd);

        // Act
        Student addedStudent = studentService.addStudent(studentToAdd);

        // Assert
        assertEquals(studentToAdd, addedStudent);
    }

    @Test
    public void testDeleteById() {
        // Arrange
        long studentId = 2;

        // Act
        studentService.deleteById(studentId);

        // Assert
        verify(repoMock, times(1)).deleteById(studentId);
    }

    @Test
    public void testUpdateStudent() {
        // Arrange
        Student studentToUpdate = new Student(4, "Bob", null, 0);
        when(repoMock.save(studentToUpdate)).thenReturn(studentToUpdate);

        // Act
        Student updatedStudent = studentService.updateStudent(studentToUpdate);

        // Assert
        assertEquals(studentToUpdate, updatedStudent);
    }
}
