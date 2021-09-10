package com.example.hdua.controllers;

import com.example.hdua.models.Student;
import com.example.hdua.services.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;

    @PostMapping(value = {"/student"}, produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public Student save(@RequestBody Student student) {
        return studentService.save(student);
    }

    @GetMapping(value = {"/student"}, produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public Student findByName(@RequestParam String name) {
        return studentService.findByName(name);
    }

    @DeleteMapping(value = {"/student"}, produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public void delete(@RequestParam String id) {
        studentService.delete(id);
    }
}
