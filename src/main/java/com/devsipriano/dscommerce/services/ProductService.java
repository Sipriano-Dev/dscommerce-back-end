package com.devsipriano.dscommerce.services;

import com.devsipriano.dscommerce.dto.ProductDTO;
import com.devsipriano.dscommerce.entities.Product;
import com.devsipriano.dscommerce.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductService {

    @Autowired
    ProductRepository repository;

    @Transactional(readOnly = true)//Da um lock para somente leitura
    public ProductDTO findById(Long id) {
        Product product = repository.findById(id).get(); //Optional inline, busca e já pega o obj dentro
        return new ProductDTO(product); //Construtor criado no dto pra ceceber uma entidade e passar os dados
    }

}
