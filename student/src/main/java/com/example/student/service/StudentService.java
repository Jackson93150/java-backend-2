package com.example.student.service;

import com.example.student.dto.School;
import com.example.student.entity.Student;
import com.example.student.repository.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class StudentService {
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private StudentRepository studentRepository;
    private final String SCHOOL_URL = "http://school";

    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    public Student save(Student student) {
        return studentRepository.save(student);
    }

    public void delete(String id) {
        studentRepository.deleteById(id);
    }

    public Map<String, Object> getStudentWithSchool(String studentId) {
        Student student = studentRepository.findById(studentId).orElse(null);
        if (student == null) {
            throw new RuntimeException("Student not found with ID: " + studentId);
        }

        String schoolUrl = SCHOOL_URL + "/school/" + student.getSchoolId();
        School school = restTemplate.getForObject(schoolUrl, School.class);

        Map<String, Object> response = new HashMap<>();
        response.put("student", student);
        response.put("school", school);

        return response;
    }
}
