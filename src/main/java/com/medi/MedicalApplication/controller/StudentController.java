package com.medi.MedicalApplication.controller;

import com.medi.MedicalApplication.model.Student;
import com.medi.MedicalApplication.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/student")
@CrossOrigin
public class StudentController {
    @Autowired
    private StudentService service;

    @PostMapping("/addstudent")
    public Student addStudent(@RequestBody Student student) { return service.saveStudent(student); }
    @PostMapping("/addStudents")
    public List<Student> addStudents(@RequestBody List<Student> students) {
        return service.saveStudents(students);
    }
    @GetMapping("/students")
    public List<Student> findAllStudents(){
        return service.getStudents();
    }
    @GetMapping("/{id}")
    public Student findByStudentId(@PathVariable(value="id") String studentId) {return service.getStudentByStudentId(studentId);}
    @GetMapping("/student/{name}")
    public Student findByFirstName(@PathVariable(value = "name") String firstName) {return service.getStudentByFirstName(firstName); }
    @PutMapping("/update")
    public Student updateStudent(@RequestBody Student student){
        return service.updateStudent(student);
    }
    @DeleteMapping("/delete/{id}")
    public String deleteStudent(@PathVariable String id) { return service.deleteStudent(id); }
}
