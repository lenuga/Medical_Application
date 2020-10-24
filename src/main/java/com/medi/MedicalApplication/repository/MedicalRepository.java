package com.medi.MedicalApplication.repository;


import com.medi.MedicalApplication.model.Medical;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicalRepository extends JpaRepository<Medical, Long> {


    Medical findByMedicalId(Long medicalId);

    Medical findByAttendance(Integer attendance);

    void deleteByMedicalId(Long medicalId);
}
