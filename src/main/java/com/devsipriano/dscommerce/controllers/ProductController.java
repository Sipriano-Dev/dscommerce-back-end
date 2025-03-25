package com.devsipriano.dscommerce.controllers;

import com.devsipriano.dscommerce.dto.CustomError;
import com.devsipriano.dscommerce.dto.ProductDTO;
import com.devsipriano.dscommerce.services.ProductService;
import com.devsipriano.dscommerce.services.exceptions.ResourceNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.time.Instant;

@RestController
@RequestMapping(value = "/products") //Mapeia como o caminha de requisições
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping //Mapeia para o GET, trazendo tudo
    public ResponseEntity<Page<ProductDTO>> findAll(Pageable pageable) { //Não precisa de anotation como @RequestParam
        Page<ProductDTO> result = service.findAll(pageable);
        return ResponseEntity.ok(result); //Retorna um ResponseEntity é uma boa pratica pra mostrar o código correspondente
    }

    @GetMapping(value = "/{id}") //Mapeia para o GET por id
    public ResponseEntity<ProductDTO> findById(@PathVariable Long id) {
        ProductDTO dto = service.findById(id);
        return ResponseEntity.ok(dto);
    }

    @PostMapping() //Mapeia para inserir
    public ResponseEntity<ProductDTO> insert(@Valid @RequestBody ProductDTO dto) {//Faz a ligação do corpo que chega com esse dto atraves da anotação
        dto = service.insert(dto);
        URI uri = ServletUriComponentsBuilder //Código pra pega a URI
                .fromCurrentRequest()
                .path("/{id}").buildAndExpand(dto.getId())
                .toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @PutMapping(value = "/{id}") //Mapeia para atualizar
    //@Valid ativa para que seja validado as condiçoes que chegam nos dtos
    public ResponseEntity<ProductDTO> update(@PathVariable Long id,@Valid @RequestBody ProductDTO dto) {
        dto = service.update(id, dto);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
