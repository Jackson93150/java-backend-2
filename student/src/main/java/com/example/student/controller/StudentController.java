package com.example.student.controller;

import com.example.student.entity.Student;
import com.example.student.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping("/{id}")
    public Map<String, Object> getStudentWithSchool(@PathVariable String id) {
        return studentService.getStudentWithSchool(id);
    }

    @PostMapping
    public ResponseEntity<Student> save(@RequestBody Student student) {
        return ResponseEntity.ok(studentService.save(student));
    }
}
