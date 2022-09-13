package io.github.guimatech.solucao.lixoso.validate;

import io.github.guimatech.solucao.lixoso.dto.UsuarioDTO;
import io.github.guimatech.solucao.lixoso.service.UsuarioService;

import static io.github.guimatech.solucao.lixoso.util.Constantes.REGEX_EMAIL_VALIDO;
import static io.github.guimatech.solucao.lixoso.util.Constantes.REGEX_USUARIO_VALIDO;

public class UsuarioValidacao {

    private UsuarioService usuarioService = new UsuarioService();

    public String validarUsuarioDto(UsuarioDTO usuarioDTO) {
        if (usuarioDTO.getNome().isBlank())
            return "O usuário está vázio!";

        if (usuarioDTO.getSenha().isBlank())
            return "A senha está vázia!";

        if (!usuarioDTO.getSenha().equals(usuarioDTO.getSenhaRepetida()))
            return "As senhas informadas são diferentes!";

        if (usuarioDTO.getSenha().length() < 6)
            return "A senha deve ter mais de 5 caracteres!";

        if (usuarioDTO.getNome().length() > 65 && usuarioDTO.getNome().length() < 1)
            return "O nome de usuário deve ter entre 2 e 64 caracteres!";

        if (!UsuarioEstaValido(usuarioDTO))
            return "O nome de usuário deve ter somente (a-z, A-Z, 0-9)!";

        var user = usuarioService.buscarUsuario(usuarioDTO.getNome());

        if (user != null)
            return "Esse nome de usuário já existe!";

        if (usuarioDTO.getEmail().isBlank())
            return "O email não pode ser vázio!";

        if (usuarioDTO.getEmail().length() > 65)
            return "O email deve ter menos de 65 caracteres!";

        if (!EmailUsuarioEstaValido(usuarioDTO))
            return "Email inválido!";

        System.out.println("Agora você está registrado, o login será realizado automáticamente...");
        return "";
    }

    private static boolean EmailUsuarioEstaValido(UsuarioDTO usuarioDTO) {
        return usuarioDTO.getEmail().matches(REGEX_EMAIL_VALIDO);
    }

    private static boolean UsuarioEstaValido(UsuarioDTO usuarioDTO) {
        return usuarioDTO.getNome().matches(REGEX_USUARIO_VALIDO);
    }
}
