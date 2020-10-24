package com.medi.MedicalApplication.repository;


import com.medi.MedicalApplication.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, String> {
    Student findByStudentId(String studentId);

    Student findByFirstName(String firstName);

    void deleteByStudentId(String studentId);
}
