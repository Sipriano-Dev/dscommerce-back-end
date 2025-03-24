package com.devsipriano.dscommerce.controllers;

import com.devsipriano.dscommerce.entities.Product;
import com.devsipriano.dscommerce.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping(value = "/products") //Mapeia como o caminha de requisições
public class ProductController {

    @Autowired
    private ProductRepository repository;

    @GetMapping //Mapeia para o GET
    public String teste() {
        Optional<Product> result = repository.findById(1L); //Retorna um optional com um obj dentro ou vazio, lida com null
        Product product = result.get(); //Forma de pegar o obj dentro do Optional
        return product.getName();
    }

}
