package io.github.guimatech.solucao.lixoso.model;

import io.github.guimatech.solucao.lixoso.dto.UsuarioDTO;
import lombok.Data;

@Data
public class Usuario {
    private String nome;
    private String email;
    private String senha;

    public Usuario(UsuarioDTO usuarioDTO) {
        nome = usuarioDTO.getNome();
        email = usuarioDTO.getEmail();
        senha = usuarioDTO.getSenha();
    }
}
