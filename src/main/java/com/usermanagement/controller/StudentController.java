package com.usermanagement.controller;

import com.usermanagement.entity.Student;
import com.usermanagement.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/get-all-students")
    public ResponseEntity<List<Student>> getAllStudents() {
        return ResponseEntity.status(HttpStatus.OK).body(studentService.getAllStudents());
    }

    @PostMapping("/add-new-student")
    public ResponseEntity<String> addNewStudent(@RequestBody Student student) {
        if (student.getName() == null || student.getMajor() == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Campi mancanti, riprova");
        } else {
            studentService.saveStudent(student);
            return ResponseEntity.status(HttpStatus.OK).body("aggiunto nuovo studente");
        }
    }
}
