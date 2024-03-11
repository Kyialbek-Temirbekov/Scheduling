package com.example.schedulingdemo.util;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.List;

public interface ErrorsUtil {
    default String getErrors(BindingResult bindingResult) {
        StringBuilder errorMessage = new StringBuilder();
        List<FieldError> errors = bindingResult.getFieldErrors();
        errors.forEach(error -> {
            errorMessage.append(error.getField() + ": " + error.getDefaultMessage() + "; ");
        });
        return errorMessage.toString();
    }
}
