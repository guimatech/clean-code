package io.github.guimatech.solucao.lixoso;

import io.github.guimatech.solucao.lixoso.model.Usuario;
import io.github.guimatech.solucao.lixoso.view.CadastroLogin;

public class Main {

    public static void main(String[] args) {
        CadastroLogin cadastroLogin = new CadastroLogin();
        var usuario = cadastroLogin.cadastrarUsuario();
        login(usuario);
        System.exit(0);
    }

    private static void login(Usuario usuario) {
        System.out.printf("Olá %s, login realizado com sucesso!%n", usuario.getNome());
    }
}