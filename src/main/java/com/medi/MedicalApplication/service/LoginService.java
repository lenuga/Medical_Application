package com.medi.MedicalApplication.service;

import com.medi.MedicalApplication.exceptions.UsernameAlreadyExistsException;
import com.medi.MedicalApplication.exceptions.UsernameAlreadyExistsException;
import com.medi.MedicalApplication.model.Login;
import com.medi.MedicalApplication.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class LoginService {



    @Autowired
    private LoginRepository loginRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public Login saveLogin (Login newlogin){

        try{
            newlogin.setPassword(bCryptPasswordEncoder.encode(newlogin.getPassword()));

            //username has to be unique
            newlogin.setUsername(newlogin.getUsername());

            //Make sure that password and confirmPassword match

            //we don't persist or show the confirmpassword
            newlogin.setConfirmpassword("");
            return loginRepository.save(newlogin);

        }catch (Exception e) {
            throw new UsernameAlreadyExistsException("Username '"+ newlogin.getUsername()+"' already exists");
        }

    }




}
