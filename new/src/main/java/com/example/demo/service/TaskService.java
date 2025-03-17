package com.example.demo.service;

import com.example.demo.dto.request.TaskSaveRequestDTO;

public interface TaskService {
    String addTask(TaskSaveRequestDTO taskSaveRequestDTO);
}
