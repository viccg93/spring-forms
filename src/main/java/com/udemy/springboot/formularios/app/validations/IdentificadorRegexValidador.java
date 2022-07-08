package com.udemy.springboot.formularios.app.validations;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class IdentificadorRegexValidador implements ConstraintValidator<IdentificadorRegex,String> {
    @Override
    public void initialize(IdentificadorRegex constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if(value.matches("[\\d]{3}[.][\\d]{3}[.][\\d]{3}[-][A-Z]{1}")){
            return true;
        }else{
            return false;
        }
    }
}
