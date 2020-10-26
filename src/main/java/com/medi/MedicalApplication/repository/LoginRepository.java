package com.medi.MedicalApplication.repository;

import com.medi.MedicalApplication.model.Login;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//import java.util.Optional;

@Repository
public interface LoginRepository extends JpaRepository<Login, Long> {
 Login findByUsername(String username);

 Login getByLoginId(Long loginId);
 

// Optional<Login> findByloginId(Long loginId);
}
