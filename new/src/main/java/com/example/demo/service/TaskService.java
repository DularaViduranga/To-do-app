package com.example.demo.service;

import com.example.demo.dto.request.TaskSaveRequestDTO;
import com.example.demo.dto.response.TaskByActiveStatusResponseDTO;
import com.example.demo.dto.response.TaskByNameReponseDTO;

import java.util.List;

public interface TaskService {
    String addTask(TaskSaveRequestDTO taskSaveRequestDTO);

    List<TaskByNameReponseDTO> getTaskByStudentID(int id);

    List<TaskByActiveStatusResponseDTO> getTaskByActiveState(boolean status);
}
