package com.medi.MedicalApplication.controller;

import com.medi.MedicalApplication.model.Login;
import com.medi.MedicalApplication.payload.JwtLoginSuccessResponse;
import com.medi.MedicalApplication.payload.LoginRequest;
import com.medi.MedicalApplication.security.JwtTokenProvider;
import com.medi.MedicalApplication.service.LoginService;
import com.medi.MedicalApplication.service.MapValidationErrorService;
import com.medi.MedicalApplication.validator.LoginValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static com.medi.MedicalApplication.security.SecurityConstants.TOKEN_PREFIX;


@RestController
@RequestMapping("/api/logins")
@CrossOrigin
public class LoginController {
    @Autowired
    private MapValidationErrorService mapValidationErrorService;

    @Autowired
    private LoginService loginService;
    // Validator
    @Autowired
    private LoginValidator loginValidator;

    @Autowired
    private JwtTokenProvider tokenProvider;

    @Autowired
    private AuthenticationManager authenticationManager;

    public LoginController() {
    }


    @PostMapping("/login")
    public ResponseEntity<?> authenticateLogin(@Valid @RequestBody Login loginRequest, BindingResult result){

        //Validator passwords match

//        loginValidator.validate(login,result);

        ResponseEntity<?> errorMap = mapValidationErrorService.MapValidationService(result);
        if(errorMap != null) return errorMap;
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getUsername(),
                        loginRequest.getPassword()
                )
        );
        System.out.println(authentication.getPrincipal().toString());
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = TOKEN_PREFIX + tokenProvider.generateToken(authentication);

        System.out.println(jwt);
        return ResponseEntity.ok(new JwtLoginSuccessResponse(true, jwt));
    }


    @PostMapping("/register")
    public ResponseEntity<?> registerogin(@Valid @RequestBody Login login, BindingResult result){
        //Validate passwords match

        ResponseEntity<?> errorMap = mapValidationErrorService.MapValidationService(result);
        if(errorMap != null) return errorMap;

        Login newLogin = loginService.saveLogin(login);
        return new ResponseEntity<Login>(newLogin, HttpStatus.CREATED);
    }



}
