package com.example.produto.payload;

import com.example.produto.model.Avaliacao;
import com.example.produto.model.Produto;

import java.util.List;

public record ResponsePayload(Produto produto, List<Avaliacao> avaliacaoList) {
}
