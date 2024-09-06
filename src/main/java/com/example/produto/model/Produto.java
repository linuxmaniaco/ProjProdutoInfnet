package com.example.produto.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int codigo;
    private BigDecimal preco;
    private String descricao;
    private boolean estoque;
    private String marca;
    private String tipomercadoria;
    private String detalhe;
    private boolean alimento;
    private Integer vendedor_id;
    private String nomevendedor;
}
