package com.medi.MedicalApplication.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class UsernameAlredyExistsException extends RuntimeException {
    public UsernameAlredyExistsException(String message) {
        super(message);
    }
}
