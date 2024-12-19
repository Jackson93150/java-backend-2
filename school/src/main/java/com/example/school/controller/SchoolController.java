package com.example.school.controller;

import com.example.school.entity.School;
import com.example.school.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/school")
public class SchoolController {
    @Autowired
    private SchoolService schoolService;

    @GetMapping
    public ResponseEntity<List<School>> findAll()
    {
        return ResponseEntity.ok(schoolService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<School> findById(@PathVariable Long id)
    {
        System.out.println(id);
        return ResponseEntity.ok(schoolService.findById(id));
    }

    @PostMapping
    public ResponseEntity<School> save(@RequestBody School school) {
        return ResponseEntity.ok(schoolService.save(school));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        schoolService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
