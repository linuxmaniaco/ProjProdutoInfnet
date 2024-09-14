package com.example.produto.controller;

import com.example.produto.model.Avaliacao;
import com.example.produto.model.Produto;
import com.example.produto.payload.ResponsePayload;
import com.example.produto.service.AvaliacaoService;
import com.example.produto.service.ProdutoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/")
@Slf4j
public class ProdutoController {
    private final ProdutoService produtoService;
    private final AvaliacaoService avaliacaoService;

    @GetMapping
    public ResponseEntity<?> findAll(){
        log.info("Buscando produtos");
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

    @GetMapping("/{id}/complete")
    public ResponseEntity<?> findByIdComAvaliacoes(@PathVariable Long id){
        Optional<Produto> optionalProduto = produtoService.findById(id);
        if(optionalProduto.isPresent()) {
            List<Avaliacao> allById = avaliacaoService.getAllById(id);
            ResponsePayload responsePayload = new ResponsePayload(optionalProduto.get(), allById);

            return ResponseEntity.ok(responsePayload);
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
