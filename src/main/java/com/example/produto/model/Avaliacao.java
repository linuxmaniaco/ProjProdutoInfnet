package com.example.produto.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Avaliacao {

    private Long id;
    private Long produtoId;
    private String avaliacao;
}
