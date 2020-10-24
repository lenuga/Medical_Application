package com.medi.MedicalApplication.controller;

import com.medi.MedicalApplication.model.Hod;
import com.medi.MedicalApplication.service.HodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/hod")
public class HodController {
    @Autowired
    private HodService service;

    @PostMapping("/addhod")
    public Hod addHod(@RequestBody Hod hod) { return service.saveHod(hod); }
    @PostMapping("/addHods")
    public List<Hod> addHods(@RequestBody List<Hod> hods) { return service.saveHods(hods); }
    @GetMapping("/hods")
    public List<Hod> findAllHods(){
        return service.getHods();
    }
    @GetMapping("/{id}")
    public Hod findByHodId(@PathVariable(value="id") String hodId) {return service.getHodByHodId(hodId);}
    @GetMapping("/hod/{name}")
    public Hod findByHodName(@PathVariable(value = "name") String hodName) {return service.getHodByHodName(hodName); }
    @PutMapping("/update")
    public Hod updateHod(@RequestBody Hod hod){ return service.updateHod(hod); }
    @DeleteMapping("/delete/{id}")
    public String deleteHod(@PathVariable String id) {
        return service.deleteHod(id);
    }
}
