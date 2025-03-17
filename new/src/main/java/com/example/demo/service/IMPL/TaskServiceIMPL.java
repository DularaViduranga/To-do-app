package com.example.demo.service.IMPL;

import com.example.demo.dto.request.TaskSaveRequestDTO;
import com.example.demo.entity.Student;
import com.example.demo.entity.Task;
import com.example.demo.repo.StudentRepo;
import com.example.demo.repo.TaskRepo;
import com.example.demo.service.TaskService;
import com.example.demo.util.Mappers.TaskMapper;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceIMPL implements TaskService {
    @Autowired
    private TaskRepo taskRepo;

    @Autowired
    StudentRepo studentRepo;
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private TaskMapper taskMapper;

    @Override
    public String addTask(TaskSaveRequestDTO taskSaveRequestDTO) {
        Student student = studentRepo.findById(taskSaveRequestDTO.getStudent())
                .orElseThrow(() -> new RuntimeException("Student not found with ID: " + taskSaveRequestDTO.getStudent()));

        Task task = new Task();
        task.setTitle(taskSaveRequestDTO.getTitle());
        task.setDescription(taskSaveRequestDTO.getDescription());
        task.setStudent(student);
        taskRepo.save(task);
        return "Task added successfully";

    }
}
