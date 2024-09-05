package com.example.produto.controller;

import com.example.produto.model.Produto;
import com.example.produto.service.ProdutoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/")
public class ProdutoController {
    private final ProdutoService produtoService;

    @GetMapping
    public ResponseEntity<?> findAll(){
        return ResponseEntity.ok(produtoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        Optional<Produto> optionalProduto = produtoService.findById(id);
        if(optionalProduto.isPresent()) {
            return ResponseEntity.ok(optionalProduto.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id){
        produtoService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody Produto produto){
        Produto produtoSaved =produtoService.create(produto);
        return ResponseEntity.ok(produtoSaved);
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody Produto produto){
        produtoService.update(produto);
        return ResponseEntity.ok().build();
    }
}
