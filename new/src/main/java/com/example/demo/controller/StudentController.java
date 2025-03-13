package com.example.demo.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/test")
@CrossOrigin
public class StudentController {
    @GetMapping(path = "/test1")
    public String getMyText() {
        String myText = "Hello World";
        System.out.println(myText);
        return myText;

    }
    @GetMapping(path = "/test2")
    public String getMyText2() {
        String myText = "Hello World2";
        System.out.println(myText);
        return myText;

    }
}
