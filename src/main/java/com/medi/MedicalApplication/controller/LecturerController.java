package com.medi.MedicalApplication.controller;

import com.medi.MedicalApplication.model.Lecturer;
import com.medi.MedicalApplication.service.LecturerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lecturer")
@CrossOrigin
public class LecturerController {
    @Autowired
    private LecturerService service;

    @PostMapping("/addlecturer")
    public Lecturer addLecturer(@RequestBody Lecturer lecturer) { return service.saveLecturer(lecturer); }
    @PostMapping("/addLecturers")
    public List<Lecturer> addLecturers(@RequestBody List<Lecturer> lecturers) { return service.saveLecturers(lecturers); }
    @GetMapping("/lecturers")
    public List<Lecturer> findAllLecturers(){
        return service.getLecturers();
    }
    @GetMapping("/{id}")
    public Lecturer findByLecturerId(@PathVariable(value="id") String lecturerId) {return service.getLecturerByLecturerId(lecturerId);}
    @GetMapping("/lecturer/{name}")
    public Lecturer findByLecturerName(@PathVariable(value = "name") String lecturerName) {return service.getLecturerByLecturerName(lecturerName); }
    @PutMapping("/update")
    public Lecturer updateLecturer(@RequestBody Lecturer lecturer){ return service.updateLecturer(lecturer); }
    @DeleteMapping("/delete/{id}")
    public String deleteLecturer(@PathVariable String id) { return service.deleteLecturer(id); }
}
