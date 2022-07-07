package com.udemy.springboot.formularios.app.controllers;

import com.udemy.springboot.formularios.app.models.domain.Usuario;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FormController {
    @GetMapping("/form")
    public String showForm(Model model){
        model.addAttribute("titulo", "formulario");
        return "form";
    }

    @PostMapping("/form")
    public String processForm(Usuario usuario, Model model, @RequestParam String username,
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
        model.addAttribute("usuario", usuario);
        return "resultado";
    }
}
