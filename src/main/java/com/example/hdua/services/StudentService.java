package com.example.hdua.services;

import com.example.hdua.models.Student;

public interface StudentService {
    Student save(Student student);
    Student findByName(String name);
    void delete (String id);
}
