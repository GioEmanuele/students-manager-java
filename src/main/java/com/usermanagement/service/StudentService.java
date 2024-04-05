package com.usermanagement.service;

import com.usermanagement.entity.Student;
import org.springframework.stereotype.Service;

import java.util.List;

public interface StudentService {
    List<Student> getAllStudents();

    Student getStudentById(Integer studentId);

    void deleteStudentById(Integer studentId);

    void saveStudent(Student student);

    void updateStudent(Student student);
}
