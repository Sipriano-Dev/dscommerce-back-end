package com.devsipriano.dscommerce.controllers;

import com.devsipriano.dscommerce.dto.ProductDTO;
import com.devsipriano.dscommerce.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/products") //Mapeia como o caminha de requisições
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping(value = "/{id}") //Mapeia para o GET
    public ProductDTO findById(@PathVariable Long id) {
        return service.findById(id);
    }

}
