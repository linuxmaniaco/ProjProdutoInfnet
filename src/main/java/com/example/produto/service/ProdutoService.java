package com.example.produto.service;

import com.example.produto.model.Produto;

import java.util.List;
import java.util.Optional;

public interface ProdutoService {

    Produto create(Produto produto);
    Optional<Produto> findById(Long id);
    List<Produto> findAll();
    void deleteById(Long id);
    Produto update(Produto produto);

}
