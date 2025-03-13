package com.example.demo.repo;

import com.example.demo.entity.Student;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
@EnableJpaRepositories
public interface StudentRepo extends JpaRepository<Student, Integer> {

}
