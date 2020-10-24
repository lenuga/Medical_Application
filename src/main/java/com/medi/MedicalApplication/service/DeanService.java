package com.medi.MedicalApplication.service;


import com.medi.MedicalApplication.model.Dean;
import com.medi.MedicalApplication.repository.DeanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class DeanService {
    @Autowired
    private DeanRepository deanRepository;

    public Dean saveDean(Dean dean) {
        return deanRepository.save(dean);
    }
    public List<Dean> saveDeans(List<Dean> deans){return deanRepository.saveAll(deans);}

    public List<Dean> getDeans(){
        return deanRepository.findAll();
    }
    public  Dean getDeanByDeanId(String deanId){
        return deanRepository.findByDeanId(deanId);
    }
    public Dean getDeanByDeanName(String deanName){
        return deanRepository.findByDeanName(deanName);
    }
    public String deleteDean(String deanId) {
        deanRepository.deleteByDeanId(deanId);
        return "Dean removed!! "+ deanId;
    }
    public Dean updateDean(Dean dean)
    {
        Dean exisitingDean = new Dean();
        return deanRepository.save(exisitingDean);

    }
}
