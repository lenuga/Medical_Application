package com.medi.MedicalApplication.service;

import com.medi.MedicalApplication.model.Login;
import com.medi.MedicalApplication.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class LoginService {

    @Autowired
    private LoginRepository loginRepository;

//    public Login saveLogin (Login newlogin){
//        newlogin.setPassword(bCryptPasswordEncoder.encode(newlogin.getPassword()));
//         return loginRepository.save(newlogin);
//    }

    public Login saveLogin(Login login) { return loginRepository.save(login); }

    public List<Login> saveLogins(List<Login> logins){return loginRepository.saveAll(logins);}

    public List<Login> getLogins(){ return loginRepository.findAll(); }

    public Login getLoginByLoginId(Long loginId){ return loginRepository.findByLoginId(loginId); }

    public Login getLoginByUsername(String username){ return loginRepository.findByUsername(username); }

    public Login updateLogin(Login login)
    {
//        Login exisitingLogin = loginRepository.findByLoginId(login.getLoginId());
//        exisitingLogin.setusername(login.getusername());
//        exisitingLogin.setpassword(login.getpassword());
        Login exisitingLogin = new Login();
        return loginRepository.save(exisitingLogin);

    }
////////
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

}
