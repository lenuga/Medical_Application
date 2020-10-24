package com.medi.MedicalApplication.repository;


import com.medi.MedicalApplication.model.Hod;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HodRepository extends JpaRepository<Hod, String> {

    Hod findByHodId(String hodId);

    void deleteByHodId(String hodId);

    Hod findByHodName(String hodName);
}
