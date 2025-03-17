package com.example.demo.service;

import com.example.demo.dto.StudentDTO;
import com.example.demo.dto.request.StudentSaveRequestDTO;
import com.example.demo.dto.request.StudentUpdateRequestDTO;

import java.util.List;

public interface StudentService{

    String addStudent(StudentSaveRequestDTO studentSaveRequestDTO);

    List<StudentDTO> getAllStudents();

    String updateStudent(StudentUpdateRequestDTO studentUpdateRequestDTO);

    int deleteStudent(int id);
}
