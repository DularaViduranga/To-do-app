package com.example.demo.controller;

import com.example.demo.dto.request.TaskSaveRequestDTO;
import com.example.demo.service.TaskService;
import com.example.demo.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/task")
@CrossOrigin
public class TaskController {
    @Autowired
    private TaskService taskService;

    @PostMapping(path = "/save")
    public ResponseEntity<StandardResponse> saveItem(@RequestBody TaskSaveRequestDTO taskSaveRequestDTO) {
        String id = taskService.addTask(taskSaveRequestDTO);

        System.out.println(taskSaveRequestDTO);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(201," task saved success",2),
                HttpStatus.CREATED
        );
    }
}
