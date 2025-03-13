package com.example.demo.service.IMPL;

import com.example.demo.dto.StudentDTO;
import com.example.demo.dto.request.StudentSaveRequestDTO;
import com.example.demo.entity.Student;
import com.example.demo.repo.StudentRepo;
import com.example.demo.service.StudentService;
import com.example.demo.util.Mappers.StudentMapper;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class StudentServiceIMPL implements StudentService {

    @Autowired
    private StudentRepo studentRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public String addStudent(StudentSaveRequestDTO studentSaveRequestDTO) {
        Student student = studentMapper.RequestDTOtoEntity(studentSaveRequestDTO);
        return studentRepo.save(student).getStudentName();
    }

    @Override
    public List<StudentDTO> getAllStudents() {
        List<Student> getStudents = StreamSupport
                .stream(studentRepo.findAll().spliterator(), false)
                .collect(Collectors.toList());
        List<StudentDTO> studentDTOS = modelMapper.map(getStudents, new TypeToken<List<StudentDTO>>() {}.getType());
        return studentDTOS;
    }

}
