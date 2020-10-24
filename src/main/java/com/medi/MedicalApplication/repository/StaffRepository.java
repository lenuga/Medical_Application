package com.medi.MedicalApplication.repository;


import com.medi.MedicalApplication.model.Staff;
import org.springframework.data.jpa.repository.JpaRepository;


public interface StaffRepository extends JpaRepository<Staff, String> {

    Staff findByStaffId(String staffId);

    Staff findByStaffName(String staffName);

    void deleteByStaffId(String staffId);
}
