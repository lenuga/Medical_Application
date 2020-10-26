package com.medi.MedicalApplication.controller;

import com.medi.MedicalApplication.model.Login;
import com.medi.MedicalApplication.payload.JwtLoginSuccessResponse;
import com.medi.MedicalApplication.payload.LoginRequest;
import com.medi.MedicalApplication.security.JwtTokenProvider;
import com.medi.MedicalApplication.service.LoginService;
import com.medi.MedicalApplication.service.MapValidationErrorService;
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

    @Autowired
    private JwtTokenProvider tokenProvider;

    @Autowired
    private AuthenticationManager authenticationManager;

    public LoginController() {
    }


    @PostMapping("/login")
    public ResponseEntity<?> authenticateLogin(@Valid @RequestBody LoginRequest loginRequest, BindingResult result){
        ResponseEntity<?> errorMap = mapValidationErrorService.MapValidationService(result);

    if(errorMap != null) return errorMap;
      Authentication authentication = authenticationManager.authenticate(
              new UsernamePasswordAuthenticationToken(
                      "abc@gmail.com",
                      "12345"
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

//    @PostMapping("/addlogin")
//    public Login addLogin(@RequestBody Login login) { return loginService.saveLogin(login); }
//    @PostMapping("/addLogins")
//    public List<Login> addLogins(@RequestBody List<Login> logins) { return loginService.saveLogins(logins); }
//    @GetMapping("/logins")
//    public List<Login> findAllLogins(){ return loginService.getLogins(); }
//    @GetMapping("/{id}")
//    public Login findByLoginId(@PathVariable (value="id") Long id) {return loginService.getLoginById(id);}
//    @GetMapping("/login/{name}")
//    public Login findByUsername(@PathVariable(value = "name") String username) {return loginService.getLoginByUsername(username); }
//    @PutMapping("/update")
//    public Login updateLogin(@RequestBody Login login){ return loginService.updateLogin(login); }

}
