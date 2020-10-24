package com.medi.MedicalApplication.service;

import com.medi.MedicalApplication.model.Hod;
import com.medi.MedicalApplication.repository.HodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class HodService {
    @Autowired
    private HodRepository repository;
    //Post
    public Hod saveHod(Hod hod) {
        // System.out.println(hod.getFirstName());
        // if(hod.getFirstName().equals("abc")){
        //    hod.setFirstName("Hello world");
        // }
        return repository.save(hod);
    }
    //save all
    public List<Hod> saveHods(List<Hod> hods){
        return repository.saveAll(hods);
    }
    public List<Hod> getHods(){
        return repository.findAll();
    }
    public  Hod getHodByHodId(String hodId){
        return repository.findByHodId(hodId);
    }
    public Hod getHodByHodName(String hodName){
        return repository.findByHodName(hodName);
    }
    public String deleteHod(String hodId) {
        repository.deleteByHodId(hodId);
        return "hod removed!! "+ hodId;
    }
    public Hod updateHod(Hod hod)
    {
        Hod exisitingHod = new Hod();
        return repository.save(exisitingHod);

    }
}
