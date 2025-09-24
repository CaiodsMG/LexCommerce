package com.lex.LexCommerce.controllers;

import com.lex.LexCommerce.dto.ProdutoDTO;
import com.lex.LexCommerce.entities.Produto;
import com.lex.LexCommerce.repositories.ProdutoRepository;
import com.lex.LexCommerce.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService service;

    @GetMapping("/{id}")
    public ProdutoDTO findById(@PathVariable Long id){
        ProdutoDTO dto = service.findById(id);
        return dto;
    }
}
