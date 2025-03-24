package com.devsipriano.dscommerce.controllers;

import com.devsipriano.dscommerce.dto.ProductDTO;
import com.devsipriano.dscommerce.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/products") //Mapeia como o caminha de requisições
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping //Mapeia para o GET, trazendo tudo
    public Page<ProductDTO> findAll(Pageable pageable) { //Não precisa de anotation como @RequestParam
        return service.findAll(pageable);
    }

    @GetMapping(value = "/{id}") //Mapeia para o GET por id
    public ProductDTO findById(@PathVariable Long id) {
        return service.findById(id);
    }

}
