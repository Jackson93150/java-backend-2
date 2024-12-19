package com.example.school.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "school")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class School {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "school_id")
    private Long id;

    private String name;
    private String address;

    public String getAddress() {
        return address;
    }

    public String getName() {
        return name;
    }

    public Long getId() {
        return id;
    }
}
