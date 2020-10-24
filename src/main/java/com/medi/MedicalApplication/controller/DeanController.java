package com.medi.MedicalApplication.controller;


import com.medi.MedicalApplication.model.Dean;
import com.medi.MedicalApplication.service.DeanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dean")
@CrossOrigin
public class DeanController {
    @Autowired
    private DeanService service;

    @PostMapping("/adddean")
    public Dean addDean(@RequestBody Dean dean) { return service.saveDean(dean); }
    @PostMapping("/addDeans")
    public List<Dean> addDeans(@RequestBody List<Dean> deans) { return service.saveDeans(deans); }
    @GetMapping("/deans")
    public List<Dean> findAllDeans(){
        return service.getDeans();
    }
    @GetMapping("/{id}")
    public Dean findByDeanId(@PathVariable(value="id") String deanId) {return service.getDeanByDeanId(deanId);}
    @GetMapping("/dean/{name}")
    public Dean findByDeanName(@PathVariable(value = "name") String deanName) {return service.getDeanByDeanName(deanName); }
    @PutMapping("/update")
    public Dean updateDean(@RequestBody Dean dean){ return service.updateDean(dean); }
    @DeleteMapping("/delete/{id}")
    public String deleteDean(@PathVariable String id) {
        return service.deleteDean(id);
    }
}
