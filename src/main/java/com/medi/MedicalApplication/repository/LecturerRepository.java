package com.medi.MedicalApplication.repository;

import com.medi.MedicalApplication.model.Lecturer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LecturerRepository extends JpaRepository<Lecturer, String> {

    Lecturer findByLecturerId(String lecturerId);

    Lecturer findByLecturerName(String lecturerName);

    void deleteByLecturerId(String lecturerId);
}
