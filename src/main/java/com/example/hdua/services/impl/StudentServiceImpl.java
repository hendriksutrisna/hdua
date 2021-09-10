package com.example.hdua.services.impl;

import com.example.hdua.models.Student;
import com.example.hdua.repositories.StudentRepository;
import com.example.hdua.services.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    @Override
    public Student save(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student findByName(String name) {
        return studentRepository.findByName(name);
    }

    @Override
    public void delete(String id) {
        studentRepository.deleteById(id);
    }
}
