package com.example.demo.controller;

import com.example.demo.dto.StudentDTO;
import com.example.demo.dto.request.StudentSaveRequestDTO;
import com.example.demo.service.StudentService;
import com.example.demo.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/test")
@CrossOrigin
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping(path = "/save")
    public ResponseEntity<StandardResponse> saveStudent(@RequestBody StudentSaveRequestDTO studentSaveRequestDTO) {
        String id = studentService.addStudent(studentSaveRequestDTO);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(201,id+" saved success",id),
                HttpStatus.CREATED
        );
    }


    @GetMapping(path = "/get-all-students")
    public ResponseEntity<StandardResponse> getAllStudents() {
        List<StudentDTO> allItems = studentService.getAllStudents();
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200,"success",allItems),
                HttpStatus.OK
        );
    }

}
