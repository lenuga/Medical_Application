package com.medi.MedicalApplication.repository;


import com.medi.MedicalApplication.model.Dean;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeanRepository extends JpaRepository<Dean, String> {

    Dean findByDeanName(String deanName);

    Dean findByDeanId(String deanId);

    void deleteByDeanId(String deanId);
}
