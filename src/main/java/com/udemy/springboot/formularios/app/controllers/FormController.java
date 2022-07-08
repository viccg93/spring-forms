package com.udemy.springboot.formularios.app.controllers;

import com.udemy.springboot.formularios.app.models.domain.Usuario;
import com.udemy.springboot.formularios.app.validations.UsuarioValidador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import javax.validation.Valid;

@Controller
@SessionAttributes("usuario") //persiste en una session http el attributo que se pasa a la vista (igual al de model.addAttribute)
public class FormController {
    @Autowired
    private UsuarioValidador usuarioValidador; //instancia que valida identificador y nombre

    //Inyecta validador
    @InitBinder
    public void initBinder(WebDataBinder binder){
        binder.addValidators(usuarioValidador); //agrega validador definido al stack de validadores
    }

    @GetMapping("/form")
    public String showForm(Model model){
        model.addAttribute("titulo", "formulario");
        model.addAttribute("usuario", new Usuario("123.123.123-A","Vic","CG"));
        return "form";
    }

    @PostMapping("/form")
    //la anotacion Valid es para indicar que la entidad se va a validar
    //BindingResult contiene el resultado de la validacion y va despues de la entidad

    public String processForm(@Valid Usuario usuario, BindingResult validationResult, Model model, SessionStatus status){
        //valida entidad e inyecta errores de validacion se cambia por initBinder que inyecta
        //usuarioValidador.validate(usuario,validationResult);

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
            /**
             * se comenta ya que Thymeleaf lo hace en automatico
            Map<String,String> errores = new HashMap<>();
            validationResult.getFieldErrors().forEach(
                    err-> errores.put(err.getField(), "El campo ".concat(err.getField())
                            .concat(" ")
                            .concat(err.getDefaultMessage()))
            );
            model.addAttribute("errores", errores);
             **/
            return "form";

        }
        model.addAttribute("usuario", usuario);
        status.setComplete(); // indica que limpie el attributo persistido en la session
        return "resultado";
    }
}
