package com.medi.MedicalApplication.repository;

import com.medi.MedicalApplication.model.Login;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginRepository extends JpaRepository<Login, Long> {
    
    Login findByUsername(String username);

    Login findByLoginId(Long loginId);
}
