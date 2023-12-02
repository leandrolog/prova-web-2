package org.senai.ecommerce.dto;

import lombok.Data;

@Data
public class NovoUsuario {

    private String nome;
    private String email;
    private String senha;
    private String permissao;
}
