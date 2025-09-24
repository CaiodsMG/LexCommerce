package com.lex.LexCommerce.services;

import com.lex.LexCommerce.dto.ProdutoDTO;
import com.lex.LexCommerce.entities.Produto;
import com.lex.LexCommerce.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository repository;

    @Transactional(readOnly = true)
    public ProdutoDTO findById(Long id){
        Optional<Produto> result = repository.findById(id);
        Produto produto = result.get();
        ProdutoDTO dto = new ProdutoDTO(produto);
        return dto;
    }
}
