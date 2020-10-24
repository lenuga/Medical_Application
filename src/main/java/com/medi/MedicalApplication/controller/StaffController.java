package com.medi.MedicalApplication.controller;


import com.medi.MedicalApplication.model.Staff;
import com.medi.MedicalApplication.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/staff")
@CrossOrigin
public class StaffController {
    @Autowired
    private StaffService service;

    @PostMapping("/addstaff")
    public Staff addStaff(@RequestBody Staff staff) { return service.saveStaff(staff); }
    @PostMapping("/addStaffs")
    public List<Staff> addStaffs(@RequestBody List<Staff> staffs) { return service.saveStaffs(staffs); }
    @GetMapping("/staffs")
    public List<Staff> findAllStaffs(){
        return service.getStaffs();
    }
    @GetMapping("/{id}")
    public Staff findByStaffId(@PathVariable(value="id") String staffId) {return service.getStaffByStaffId(staffId);}
    @GetMapping("/staff/{name}")
    public Staff findByStaffName(@PathVariable(value = "name") String staffName) {return service.getStaffByStaffName(staffName); }
    @PutMapping("/update")
    public Staff updateStaff(@RequestBody Staff staff){ return service.updateStaff(staff); }
    @DeleteMapping("/delete/{id}")
    public String deleteStaff(@PathVariable String id) { return service.deleteStaff(id); }

}
