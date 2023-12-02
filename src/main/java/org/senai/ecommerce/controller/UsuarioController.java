package org.senai.ecommerce.controller;

import org.senai.ecommerce.dto.NovoUsuario;
import org.senai.ecommerce.entity.Usuario;
import org.senai.ecommerce.service.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping("/add")
    public ResponseEntity<?> salvar(@RequestBody NovoUsuario usuario){
        Usuario usuarioCriado = usuarioService.salvar(usuario);
        return new ResponseEntity(usuarioCriado, HttpStatus.CREATED);
    }
}
