package com.example.school.service;

import com.example.school.entity.School;
import com.example.school.repository.SchoolRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class SchoolService {
    @Autowired
    private SchoolRepository schoolRepository;

    public List<School> findAll() {
        return schoolRepository.findAll();
    }

    public School findById(long id) {
        return schoolRepository.findById(id).orElse(null);
    }

    public School save(School school) {
        return schoolRepository.save(school);
    }

    public void delete(Long id) {
        schoolRepository.deleteById(id);
    }

}
