package com.example.demo.service.IMPL;

import com.example.demo.dto.StudentDTO;
import com.example.demo.dto.request.StudentSaveRequestDTO;
import com.example.demo.dto.request.StudentUpdateRequestDTO;
import com.example.demo.entity.Student;
import com.example.demo.exception.EntryDuplicateException;
import com.example.demo.repo.StudentRepo;
import com.example.demo.repo.TaskRepo;
import com.example.demo.service.StudentService;
import com.example.demo.util.Mappers.StudentMapper;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class StudentServiceIMPL implements StudentService {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private StudentRepo studentRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private TaskRepo taskRepo;

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

    @Override
    public String updateStudent(StudentUpdateRequestDTO studentUpdateRequestDTO) {
        if(studentRepo.existsById(studentUpdateRequestDTO.getStudentId())){
            Student student = studentRepo.getReferenceById(studentUpdateRequestDTO.getStudentId());

            student.setStudentName(studentUpdateRequestDTO.getStudentName());
            student.setStudentAddress(studentUpdateRequestDTO.getStudentAddress());

            return studentRepo.save(student).getStudentName();
        }else{
            throw new EntryDuplicateException("Not in database");
        }

    }

    @Override
    public int deleteStudent(int id) {
        if (studentRepo.existsById(id)) {
            studentRepo.deleteById(id);
        } else {
            throw new NoSuchElementException("Not found customer for this id");
        }
        return id;
    }
//@Override
//public int deleteStudent(int id) {
//    Optional<Student> studentOptional = studentRepo.findById(id);
//
//    if (studentOptional.isPresent()) {
//        Student student = studentOptional.get();
//
//        // Check if there are associated tasks and clear them before deletion
//        if (student.getTasks() != null) {
//            student.getTasks().clear();
//        }
//
//        studentRepo.deleteById(id);
//        return id;
//    } else {
//        throw new NoSuchElementException("Not found customer for this id");
//    }
//}

//    @Transactional
//    public int deleteStudent(int Id) {
//        Student student = studentRepo.findById(Id).orElseThrow(() -> new RuntimeException("Student not found"));
//        // Detach the student entity if it is managed by Hibernate
//        entityManager.detach(student);
//
//        // Clear the collection after detaching the entity
//        student.getTasks().clear();
//
//        // Now delete the student
//        studentRepo.delete(student);
//        return Id;
//    }
//@Transactional
//public int deleteStudent(int Id) {
//    Student student = studentRepo.findById(Id)
//            .orElseThrow(() -> new RuntimeException("Student not found"));
//
//    studentRepo.delete(student); // No need to clear or detach manually
//    return Id;
//}
//@Transactional
//public int deleteStudent(int Id) {
//    Student student = studentRepo.findById(Id)
//            .orElseThrow(() -> new RuntimeException("Student not found"));
//
//    taskRepo.deleteAll(student.getTasks()); // Delete tasks first
//    studentRepo.delete(student); // Now delete student
//
//    return Id;
//}

}
