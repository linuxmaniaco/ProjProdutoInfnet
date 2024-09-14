package com.example.produto.service.client;

import com.example.produto.model.Avaliacao;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient("AVALIACAO-SERVICE")
public interface AvaliacaoClient {
    @GetMapping("/{id}")
    List<Avaliacao> getById(@PathVariable Long id);
}
