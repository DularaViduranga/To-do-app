package com.example.demo.repo;

import com.example.demo.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepo extends JpaRepository<Task, Integer> {

    void deleteByStudent_Id(int id);
}
