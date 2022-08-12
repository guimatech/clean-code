package io.github.guimatech.solucao.lixoso;

import lombok.Data;

import java.util.Scanner;

public class Main {

    private static final Scanner entradaTexto = new Scanner(System.in);
    public static final String REGEX_USUARIO_VALIDO = "^[a-z\\d]{2,64}$";
    public static final String REGEX_EMAIL_VALIDO = "^((?!\\.)[\\w-_.]*[^.])(@\\w+)(\\.\\w+(\\.\\w+)?[^.\\W])$";

    @Data
    static class UsuarioDTO {
        private String nome;
        private String email;
        private String senha;
        private String senhaRepetida;
    }

    @Data
    static class Usuario {
        private String nome;
        private String email;
        private String senha;

        public Usuario(UsuarioDTO usuarioDTO) {
            nome = usuarioDTO.getNome();
            email = usuarioDTO.getEmail();
            senha = usuarioDTO.getSenha();
        }
    }

    public static void main(String[] args) {
        var usuario = cadastrarUsuario();
        login(usuario);
        System.exit(0);
    }

    private static Usuario cadastrarUsuario() {
        System.out.println("Cadastrar usuário: \n");
        var usuarioDto = obterUsuarioDto();
        var msg = validarUsuarioDto(usuarioDto);
        System.out.println(msg);

        if (!msg.isBlank())
            return cadastrarUsuario();

        return new Usuario(usuarioDto);
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

    public static String validarUsuarioDto(UsuarioDTO usuarioDTO) {
        if (usuarioDTO.getNome().equals(""))
            return "O usuário está vázio!";

        if (usuarioDTO.getSenha().equals(""))
            return "A senha está vázia!";

        if (!usuarioDTO.getSenha().equals(usuarioDTO.getSenhaRepetida()))
            return "As senhas informadas são diferentes!";

        if (usuarioDTO.getSenha().length() < 6)
            return "A senha deve ter mais de 5 caracteres!";

        if (usuarioDTO.getNome().length() > 65 && usuarioDTO.getNome().length() < 1)
            return "O nome de usuário deve ter entre 2 e 64 caracteres!";

        if (!UsuarioEstaValido(usuarioDTO))
            return "O nome de usuário deve ter somente (a-z, A-Z, 0-9)!";

        var user = buscarUsuario(usuarioDTO.getNome());

        if (user != null)
            return "Esse nome de usuário já existe!";

        if (!usuarioDTO.getEmail().equals(""))
            return "O email não pode ser vázio!";

        if (usuarioDTO.getEmail().length() > 65)
            return "O email deve ter menos de 65 caracteres!";

        if (!EmailUsuarioEstaValido(usuarioDTO))
            return "Email inválido: exemplo email válido!";

        System.out.println("Agora você está registrado, o login será realizado automáticamente...");
        return "";
    }

    private static boolean EmailUsuarioEstaValido(UsuarioDTO usuarioDTO) {
        return usuarioDTO.getEmail().matches(REGEX_EMAIL_VALIDO);
    }

    private static boolean UsuarioEstaValido(UsuarioDTO usuarioDTO) {
        return usuarioDTO.getNome().matches(REGEX_USUARIO_VALIDO);
    }

    private static String buscarUsuario(String nomeUsuario) {
        var usuarioEncontrado = "lucas123";
        if (!nomeUsuario.equals(usuarioEncontrado))
            return null;

        return usuarioEncontrado;
    }

    private static void login(Usuario usuario) {
        System.out.printf("Olá %s, login realizado com sucesso!%n", usuario.getNome());
    }
}