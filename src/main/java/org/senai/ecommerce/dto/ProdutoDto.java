package org.senai.ecommerce.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProdutoDto {
    private String nome;
    private String descricao;
    private double preco;
    private int estoque;
}
