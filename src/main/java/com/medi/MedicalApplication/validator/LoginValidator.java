package com.medi.MedicalApplication.validator;

import com.medi.MedicalApplication.model.Login;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;


@Component
public class LoginValidator implements Validator {

    @Override
    public boolean supports(Class<?> aClass) {
        return Login.class.equals(aClass);
    }

    @Override
    public void validate(Object object, Errors errors) {
         Login login = (Login) object;

         if(login.getPassword().length() <6){
             errors.rejectValue("password", "Length", "password must be at least 6 characters");
         }
//confirmpassword
         if(!login.getPassword().equals(login.getConfirmpassword())){
             errors.rejectValue("confirmpassword", "Length", "password must match");

         }
    }
}
