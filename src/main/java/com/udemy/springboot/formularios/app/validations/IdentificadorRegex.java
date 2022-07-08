package com.udemy.springboot.formularios.app.validations;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = IdentificadorRegexValidador.class)
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD,ElementType.METHOD})
public @interface IdentificadorRegex {
    String message() default "Identificador invalido";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default { };

}
