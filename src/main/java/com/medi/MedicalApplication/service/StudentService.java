package com.medi.MedicalApplication.service;

import com.medi.MedicalApplication.model.Student;
import com.medi.MedicalApplication.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class StudentService {
    @Autowired
    private StudentRepository repository;
    //Post
    public Student saveStudent(Student student) {
       // System.out.println(student.getFirstName());
       // if(student.getFirstName().equals("abc")){
        //    student.setFirstName("Hello world");
       // }
        return repository.save(student);
    }
    //save all
    public List<Student> saveStudents(List<Student> students){
        return repository.saveAll(students);
    }
    public List<Student> getStudents(){
        return repository.findAll();
    }
    public  Student getStudentByStudentId(String studentId){
        return repository.findByStudentId(studentId);
    }
    public Student getStudentByFirstName(String firstName){
        return repository.findByFirstName(firstName);
    }
    public String deleteStudent(String studentId) {
        repository.deleteByStudentId(studentId);
        return "student removed!! "+ studentId;
    }
    public Student updateStudent(Student student)
    {
        //Student exisitingStudent = repository.findByStudentId(student.getStudentId());
       /* exisitingStudent.setFirstName(student.getFirstName());
        exisitingStudent.setAddress(student.getAddress());
        exisitingStudent.setCourseId(student.getCourseId());*/
        Student exisitingStudent = new Student();
        return repository.save(exisitingStudent);

    }
}
