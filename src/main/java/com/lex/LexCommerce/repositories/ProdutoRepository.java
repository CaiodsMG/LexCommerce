package com.lex.LexCommerce.repositories;

import com.lex.LexCommerce.entities.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
