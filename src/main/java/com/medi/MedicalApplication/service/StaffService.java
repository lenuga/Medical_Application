package com.medi.MedicalApplication.service;

import com.medi.MedicalApplication.model.Staff;
import com.medi.MedicalApplication.repository.StaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class StaffService {
    @Autowired
    private StaffRepository staffRepository;

    public Staff saveStaff(Staff staff) {
        return staffRepository.save(staff);
    }
    public List<Staff> saveStaffs(List<Staff> staffs){return staffRepository.saveAll(staffs);}

    public List<Staff> getStaffs(){
        return staffRepository.findAll();
    }
    public  Staff getStaffByStaffId(String staffId){
        return staffRepository.findByStaffId(staffId);
    }
    public Staff getStaffByStaffName(String staffName){
        return staffRepository.findByStaffName(staffName);
    }
    public String deleteStaff(String staffId) {
        staffRepository.deleteByStaffId(staffId);
        return "Staff removed!! "+ staffId;
    }
    public Staff updateStaff(Staff staff)
    {
        Staff exisitingStaff= new Staff();
        return staffRepository.save(exisitingStaff);

    }

}
