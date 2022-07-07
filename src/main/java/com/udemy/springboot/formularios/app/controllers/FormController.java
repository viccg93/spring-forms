package com.udemy.springboot.formularios.app.controllers;

import com.udemy.springboot.formularios.app.models.domain.Usuario;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@Controller
public class FormController {
    @GetMapping("/form")
    public String showForm(Model model){
        model.addAttribute("titulo", "formulario");
        model.addAttribute("usuario", new Usuario());
        return "form";
    }

    @PostMapping("/form")
    //la anotacion Valid es para indicar que la entidad se va a validar
    //BindingResult contiene el resultado de la validacion y va despues de la entidad
    public String processForm(@Valid Usuario usuario, BindingResult validationResult, Model model, @RequestParam String username,
                              @RequestParam String password,
                              @RequestParam String email){
        /**
        Al pasar el usuario como argumento (y sus campos coinciden con los parametros
        se inyecta la informacion en la instancia haciendo que el siguiente codigo sea inecesario

         Usuario sentUser = new Usuario();
        sentUser.setUsername(username);
        sentUser.setPassword(password);
        sentUser.setEmail(email);
         **/
        //la anotacion RequestParam sirve para obtener los valores de request de Post
        model.addAttribute("titulo", "Resultado formulario");
        if(validationResult.hasErrors()){
            Map<String,String> errores = new HashMap<>();
            validationResult.getFieldErrors().forEach(
                    err-> errores.put(err.getField(), "El campo ".concat(err.getField())
                            .concat(" ")
                            .concat(err.getDefaultMessage()))
            );
            model.addAttribute("errores", errores);
            return "form";

        }
        model.addAttribute("usuario", usuario);
        return "resultado";
    }
}
