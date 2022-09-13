package io.github.guimatech.solucao.lixoso.service;

import io.github.guimatech.solucao.lixoso.dto.UsuarioDTO;
import io.github.guimatech.solucao.lixoso.exception.ValidacaoException;
import io.github.guimatech.solucao.lixoso.model.Usuario;
import io.github.guimatech.solucao.lixoso.validate.UsuarioValidacao;

public class UsuarioService {

    public Usuario salvarUsuario(UsuarioValidacao usuarioValidacao, UsuarioDTO usuarioDTO) {
        var erro = usuarioValidacao.validarUsuarioDto(usuarioDTO);

        if (!erro.isBlank())
            throw new ValidacaoException(erro);

        return new Usuario(usuarioDTO);
    }

    public String buscarUsuario(String nomeUsuario) {
        var usuarioEncontrado = "lucas123";
        if (!nomeUsuario.equals(usuarioEncontrado))
            return null;

        return usuarioEncontrado;
    }
}
