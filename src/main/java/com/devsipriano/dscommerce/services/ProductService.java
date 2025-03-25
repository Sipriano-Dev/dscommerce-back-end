package com.devsipriano.dscommerce.services;

import com.devsipriano.dscommerce.dto.ProductDTO;
import com.devsipriano.dscommerce.entities.Product;
import com.devsipriano.dscommerce.repositories.ProductRepository;
import com.devsipriano.dscommerce.services.exceptions.DatabaseException;
import com.devsipriano.dscommerce.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductService {

    @Autowired
    ProductRepository repository;

    @Transactional(readOnly = true)
    //Vai retorna uma lista de dto paginada, pra isso recebe um Pageable pra passa pro repository o tamanho da página
    public Page<ProductDTO> findAll(Pageable pageable) { //O repository já tem uma sobrecarga do findAll recebendo pageable
        Page<ProductDTO> result = repository.findAll(pageable).map(ProductDTO::new);//.map direto pq Page já é um stream
        return result;
    }

    @Transactional(readOnly = true)//Da um lock para somente leitura
    public ProductDTO findById(Long id) {
        //Optional inline, busca e já pega o obj dentro, Lança no console a exception personaliza que criei
        Product product = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Recurso não encontrado"));
        return new ProductDTO(product); //Construtor criado no dto pra ceceber uma entidade e passar os dados
    }


    @Transactional
    public ProductDTO insert(ProductDTO dto) {
        Product entity = new Product();
        copyDtoToEntity(dto, entity);
        //return new ProductDTO(repository.save(entity));//Retorna o produto dto, usando a entidade retornada pelo repository ao salvar
        entity = repository.save(entity); //Retorna uma nova referencia atualizada
        return new ProductDTO(entity);
    }

    @Transactional
    public ProductDTO update(Long id, ProductDTO dto) {
        try {
            Product entity = repository.getReferenceById(id); //Não vai no banco de dados, mas instancia com id e fica monitorado pela JPA, diferente do new
            copyDtoToEntity(dto, entity);
            entity = repository.save(entity);
            return new ProductDTO(entity);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException("Recurso Não encontrado");
        }
    }

    //Só executa o Transactional se o método se estiver no contexto de outra transação
    //É pra captura o erro certo nesse contexto do h2
    @Transactional(propagation = Propagation.SUPPORTS)
    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Recurso não encontrado");
        }
        try {
            repository.deleteById(id);
        }
        catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Falha de integridade referencial");
        }
    }

    private void copyDtoToEntity(ProductDTO dto, Product entity) {
        entity.setName(dto.getName());
        entity.setDescription(dto.getDescription());
        entity.setImgUrl(dto.getImgUrl());
        entity.setPrice(dto.getPrice());
    }





}
