package com.medi.MedicalApplication.controller;

import com.medi.MedicalApplication.model.Login;
import com.medi.MedicalApplication.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/login")
@CrossOrigin
public class LoginController {
    @Autowired
    private LoginService loginService;

    @PostMapping("/addlogin")
    public Login addLogin(@RequestBody Login login) { return loginService.saveLogin(login); }
    @PostMapping("/addLogins")
    public List<Login> addLogins(@RequestBody List<Login> logins) { return loginService.saveLogins(logins); }
    @GetMapping("/logins")
    public List<Login> findAllLogins(){ return loginService.getLogins(); }
    @GetMapping("/{id}")
    public Login findByLoginId(@PathVariable (value="id") Long loginId) {return loginService.getLoginByLoginId(loginId);}
    @GetMapping("/login/{name}")
    public Login findByUsername(@PathVariable(value = "name") String username) {return loginService.getLoginByUsername(username); }
    @PutMapping("/update")
    public Login updateLogin(@RequestBody Login login){ return loginService.updateLogin(login); }

}
