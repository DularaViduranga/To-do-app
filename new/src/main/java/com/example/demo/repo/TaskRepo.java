package com.example.demo.repo;

import com.example.demo.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TaskRepo extends JpaRepository<Task, Integer> {

    @Query("SELECT t FROM Task t WHERE t.student.studentId = :id")
    List<Task> getTaskByStudentId(int id);

    @Query("Select t from Task t where t.completed = :status")
    List<Task> getTaskByActiveState(boolean status);
}
