package com.medi.MedicalApplication.service;

import com.medi.MedicalApplication.model.Lecturer;
import com.medi.MedicalApplication.repository.LecturerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class LecturerService {
    @Autowired
    private LecturerRepository lecturerRepository;

    public Lecturer saveLecturer(Lecturer lecturer) {
        // System.out.println(lecturer.getlecturerName());
        // if(lecturer.getlecturerName().equals("abc")){
        //    lecturer.setlecturerName("Hello world");
        // }
        return lecturerRepository.save(lecturer);
    }
    public List<Lecturer> saveLecturers(List<Lecturer> lecturers){return lecturerRepository.saveAll(lecturers);}

    public List<Lecturer> getLecturers(){
        return lecturerRepository.findAll();
    }

    public  Lecturer getLecturerByLecturerId(String lecturerId){ return lecturerRepository.findByLecturerId(lecturerId); }

    public Lecturer getLecturerByLecturerName(String lecturerName){ return lecturerRepository.findByLecturerName(lecturerName); }

    public String deleteLecturer(String lecturerId) {
        lecturerRepository.deleteByLecturerId(lecturerId);
        return "Lecturer removed!! "+ lecturerId;
    }
    public Lecturer updateLecturer(Lecturer lecturer)
    {
        //Lecturer exisitingLecturer = repository.findByLecturerId(lecturer.getLecturerId());
       /* exisitingLecturer.setFirstName(lecturer.getFirstName());
        exisitingLecturer.setAddress(lecturer.getAddress());
        exisitingLecturer.setCourseId(lecturer.getCourseId());*/
        Lecturer exisitingLecturer = new Lecturer();
        return lecturerRepository.save(exisitingLecturer);

    }
}
