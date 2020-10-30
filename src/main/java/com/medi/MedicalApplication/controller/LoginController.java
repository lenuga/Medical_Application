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


}
