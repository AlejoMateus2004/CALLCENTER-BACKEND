package com.callcenter.controllers;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Admin")
public class RestControllerAdministrador {

    @GetMapping
    public String saludar(){

        return "Hola desde Spring";
    }
}
