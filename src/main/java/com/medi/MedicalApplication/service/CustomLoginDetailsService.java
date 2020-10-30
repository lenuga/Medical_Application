package com.medi.MedicalApplication.service;

import com.medi.MedicalApplication.model.Login;
import com.medi.MedicalApplication.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CustomLoginDetailsService implements UserDetailsService {
    @Autowired
    private LoginRepository loginRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Login login = loginRepository.findByUsername(username);

        if (login==null) new UsernameNotFoundException("user not found");
        return login;
    }
    @Transactional
    public  Login loadLoginByLoginId(Long loginId){
        Login login = loginRepository.getByLoginId(loginId);
        if(login==null) new UsernameNotFoundException("user not found");
        return  login;
    }
}

