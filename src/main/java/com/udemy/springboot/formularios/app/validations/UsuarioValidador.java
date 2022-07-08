package com.udemy.springboot.formularios.app.validations;

import com.udemy.springboot.formularios.app.models.domain.Usuario;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class UsuarioValidador implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return Usuario.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Usuario usuario = (Usuario) target;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"nombre","NotEmpty.usuario.nombre");

        /*
        if(!(usuario.getIdentificador().matches("[\\d]{3}[.][\\d]{3}[.][\\d]{3}[-][A-Z]{1}"))){
            errors.rejectValue("identificador","Pattern.usuario.identificador");
        }

        */
    }
}
