package com.example.hdua.repositories;

import com.example.hdua.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, String> {
    Student findByName(String name);
}
