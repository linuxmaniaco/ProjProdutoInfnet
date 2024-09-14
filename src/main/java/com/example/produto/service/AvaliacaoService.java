package com.example.produto.service;

import com.example.produto.model.Avaliacao;
import com.example.produto.repository.ProdutoRepository;
import com.example.produto.service.client.AvaliacaoClient;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
@RequiredArgsConstructor
@Slf4j
public class AvaliacaoService {
    private final AvaliacaoClient avaliacaoClient;
    private static Map<Long, List<Avaliacao>> CACHE = new ConcurrentHashMap<>();
    @CircuitBreaker(name = "avaliacaoService", fallbackMethod = "buscarNoCache")
    public List<Avaliacao> getAllById(Long produtoId) {
        List<Avaliacao> avaliacaos = avaliacaoClient.getById(produtoId);
        CACHE.put(produtoId, avaliacaos);
        return avaliacaoClient.getById(produtoId);
    }
    private List<Avaliacao> buscarNoCache(Long produtoId, Throwable e){
      log.info("Buscando no cache");
      return CACHE.getOrDefault(produtoId, new ArrayList<>());
    }
}
