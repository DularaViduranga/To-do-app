package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "fullstack")
public class Student {
    @Id
    @Column(name = "student_id", length = 45)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int studentId;

    @Column(name = "student_name", length = 180, nullable = false)
    private String studentName;

    @Column(name = "student_address", length = 150)
    private String studentAddress;

}