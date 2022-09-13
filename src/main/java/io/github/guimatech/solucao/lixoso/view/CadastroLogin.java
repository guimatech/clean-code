package io.github.guimatech.solucao.lixoso.view;

import io.github.guimatech.solucao.lixoso.controller.UsuarioController;
import io.github.guimatech.solucao.lixoso.dto.UsuarioDTO;
import io.github.guimatech.solucao.lixoso.exception.ValidacaoException;
import io.github.guimatech.solucao.lixoso.model.Usuario;
import io.github.guimatech.solucao.lixoso.service.UsuarioService;

import java.util.Scanner;

public class CadastroLogin {

    private static final Scanner entradaTexto = new Scanner(System.in);

    private final UsuarioController usuarioController;

    public CadastroLogin() {
        usuarioController = new UsuarioController();
    }

    public Usuario cadastrarUsuario() {
        System.out.println("Cadastrar usuário: \n");
        var usuarioDto = obterUsuarioDto();
        try {
            return usuarioController.salvarUsuario(usuarioDto);
        } catch (ValidacaoException exception) {
            System.out.println(exception.getMessage());
            return cadastrarUsuario();
        }
    }

    private static UsuarioDTO obterUsuarioDto() {
        UsuarioDTO usuarioDTO = new UsuarioDTO();
        System.out.println("Informe o Nome:");
        usuarioDTO.setNome(entradaTexto.next());
        System.out.println("Informe o Email:");
        usuarioDTO.setEmail(entradaTexto.next());
        System.out.println("Informe a Senha:");
        usuarioDTO.setSenha(entradaTexto.next());
        System.out.println("Informe a Senha novamente:");
        usuarioDTO.setSenhaRepetida(entradaTexto.next());
        return usuarioDTO;
    }
}
