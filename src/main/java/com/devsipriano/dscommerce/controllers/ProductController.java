package com.devsipriano.dscommerce.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/products") //Mapeia como o caminha de requisições
public class ProductController {


    @GetMapping //Mapeia para o GET
    public String teste() {
         return "Olá Mundo";
    }

}
