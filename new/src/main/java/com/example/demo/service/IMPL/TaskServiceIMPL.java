package com.example.demo.service.IMPL;

import com.example.demo.dto.StudentDTO;
import com.example.demo.dto.request.TaskSaveRequestDTO;
import com.example.demo.dto.response.TaskByNameReponseDTO;
import com.example.demo.entity.Student;
import com.example.demo.entity.Task;
import com.example.demo.repo.StudentRepo;
import com.example.demo.repo.TaskRepo;
import com.example.demo.service.TaskService;
import com.example.demo.util.Mappers.TaskMapper;
import com.example.demo.util.StandardResponse;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

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

    @Override
    public List<TaskByNameReponseDTO> getTaskByStudentName(int id) {
        List<Task> getTaskByStudentId = taskRepo.getTaskByStudentId(id);
        List<TaskByNameReponseDTO> taskByNameReponseDTOS = modelMapper.map(getTaskByStudentId, new TypeToken<List<TaskByNameReponseDTO>>() {}.getType());
        return taskByNameReponseDTOS;

    }

//    @Override
//    public List<StudentDTO> getAllStudents() {
//        List<Student> getStudents = StreamSupport
//                .stream(studentRepo.findAll().spliterator(), false)
//                .collect(Collectors.toList());
//        List<StudentDTO> studentDTOS = modelMapper.map(getStudents, new TypeToken<List<StudentDTO>>() {}.getType());
//        return studentDTOS;
//    }
}
