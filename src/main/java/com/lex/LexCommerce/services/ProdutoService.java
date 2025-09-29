package com.lex.LexCommerce.services;

import com.lex.LexCommerce.dto.ProdutoDTO;
import com.lex.LexCommerce.entities.Produto;
import com.lex.LexCommerce.repositories.ProdutoRepository;
import com.lex.LexCommerce.services.exceptions.DatabaseException;
import com.lex.LexCommerce.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository repository;

    @Transactional(readOnly = true)
    public ProdutoDTO findById(Long id){
        Produto produto = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Recurso não encontrado"));
        ProdutoDTO dto = new ProdutoDTO(produto);
        return dto;
    }

    @Transactional(readOnly = true)
    public Page<ProdutoDTO> findAll(Pageable pageable){
        Page<Produto> result = repository.findAll(pageable);
        return result.map(x -> new ProdutoDTO(x));
    }

    @Transactional
    public ProdutoDTO inserirProduto(ProdutoDTO dto){
        Produto entity = new Produto();
        copiarDTOparaEntidade(dto,entity);
        entity = repository.save(entity);
        return new ProdutoDTO(entity);
    }

    @Transactional
    public ProdutoDTO atualizarProduto(Long id, ProdutoDTO dto){
        Produto entity = repository.getReferenceById(id);
        copiarDTOparaEntidade(dto, entity);
        entity = repository.save(entity);
        return new ProdutoDTO(entity);
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public void deletarProduto(Long id){
        if (!repository.existsById(id)){
            throw new ResourceNotFoundException("Recurso não encontrado.");
        }
        try{
            repository.deleteById(id);
        }catch (DataIntegrityViolationException e){
            throw new DatabaseException("Falha de Integridade Referencial");
        }

    }

    private void copiarDTOparaEntidade(ProdutoDTO dto, Produto entity) {
        entity.setNome(dto.getNome());
        entity.setDescricao(dto.getDescricao());
        entity.setPreco(dto.getPreco());
        entity.setImgUrl(dto.getImgUrl());
    }
}
