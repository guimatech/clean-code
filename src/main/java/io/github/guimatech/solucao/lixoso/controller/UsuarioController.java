package io.github.guimatech.solucao.lixoso.controller;

import io.github.guimatech.solucao.lixoso.dto.UsuarioDTO;
import io.github.guimatech.solucao.lixoso.model.Usuario;
import io.github.guimatech.solucao.lixoso.service.UsuarioService;
import io.github.guimatech.solucao.lixoso.validate.UsuarioValidacao;

public class UsuarioController {

    private UsuarioService usuarioService = new UsuarioService();

    public Usuario salvarUsuario(UsuarioDTO usuarioDTO) {
        return usuarioService.salvarUsuario(new UsuarioValidacao(), usuarioDTO);
    }

}
