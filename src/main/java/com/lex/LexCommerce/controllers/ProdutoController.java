package com.lex.LexCommerce.controllers;

import com.lex.LexCommerce.dto.ProdutoDTO;
import com.lex.LexCommerce.entities.Produto;
import com.lex.LexCommerce.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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

    @GetMapping()
    public Page<ProdutoDTO> findAll(Pageable pageable){
        return service.findAll(pageable);
    }

    @PostMapping()
    public ProdutoDTO inserirProduto(@RequestBody ProdutoDTO produto){
        return service.inserirProduto(produto);
    }
}
