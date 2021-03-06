package com.udemy.springboot.formularios.app.models.domain;

import com.udemy.springboot.formularios.app.validations.IdentificadorRegex;

import javax.validation.constraints.*;

public class Usuario {
    @IdentificadorRegex
    private String identificador;
    //@NotEmpty
    private String nombre;
    @NotEmpty
    private String apellido;
    @NotBlank
    @Size(min = 3, max = 8)
    private String username;
    @NotEmpty
    private String password;
    @NotEmpty
    @Email
    private String email;


    public Usuario() {
    }

    public Usuario(String identificador, String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.identificador = identificador;
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
