//package com.example.demo.entity;
//
//import jakarta.persistence.*;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//import java.util.Set;
//
//@AllArgsConstructor
//@NoArgsConstructor
//@Data
//@Entity
//@Table(name = "student")
//public class Student {
//    @Id
//    @Column(name = "student_id", length = 45)
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private int studentId;
//
//    @Column(name = "student_name", length = 180, nullable = false)
//    private String studentName;
//
//    @Column(name = "student_address", length = 150)
//    private String studentAddress;
//
//    @OneToMany(mappedBy="student", cascade = CascadeType.ALL, orphanRemoval = true)
//    private Set<Task> tasks;
//
//}
package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "student")
public class Student {

    @Id
    @Column(name = "student_id", length = 45)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int studentId;

    @Column(name = "student_name", length = 180, nullable = false)
    private String studentName;

    @Column(name = "student_address", length = 150)
    private String studentAddress;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Task> tasks;
}
