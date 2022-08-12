package io.github.guimatech.problema;

import java.util.Scanner;

public class Lixoso {

    private static final Scanner sc = new Scanner(System.in);

    static class Usuario {
        public String nome;
        public String email;
        public String senha;
    }

    public static void main(String[] args) {
        preecherUsuario();
        System.exit(0);
    }

    private static void preecherUsuario() {
        String msg = "Cadastrar usuário: \n";
        do {
            Usuario u = new Usuario();
            System.out.println(msg);
            System.out.println("Informe o Nome:");
            u.nome = sc.next();
            System.out.println("Informe o Email:");
            u.email = sc.next();
            System.out.println("Informe a Senha:");
            u.senha = sc.next();
            System.out.println("Informe a Senha novamente:");
            msg = cadastroLixoso(u.nome, u.email, u.senha, sc.next());
        } while (!msg.isBlank());
    }

    public static String cadastroLixoso(String user_name, String user_email,
                         String user_password_new, String user_password_repeat) {
        String msg = "";
        if (!user_name.equals("")) {
            if (!user_password_new.equals("")) {
                if (user_password_new.equals(user_password_repeat)) {
                    if (user_password_new.length() > 5) {
                        if (user_name.length() < 65 && user_name.length() > 1) {
                            if (user_name.matches("^[a-z\\d]{2,64}$")) {
                                var user = read_user(user_name);
                                if (user == null) {
                                    if (!user_email.equals("")) {
                                        if (user_email.length() < 65) {
                                            if (user_email.matches("^((?!\\.)[\\w-_.]*[^.])(@\\w+)(\\.\\w+(\\.\\w+)?[^.\\W])$")) {
                                                System.out.println("Agora você está registrado, então, por favor, faça o login...");
                                                login();
                                            } else msg = "Você deve informar um endereço de email válido!";
                                        } else msg = "O email deve ter menos de 65 caracteres!";
                                    } else msg = "O email não pode ser vázio!";
                                } else msg = "Esse nome de usuário já existe!";
                            } else msg = "O nome de usuário deve ter somente (a-z, A-Z, 0-9)!";
                        } else msg = "O nome de usuário deve ter entre 2 e 64 caracteres!";
                    } else msg = "A senha deve ter mais de 5 caracteres!";
                } else msg = "As senhas informadas são diferentes!";
            } else msg = "A senha está vázia!";
        } else msg = "O usuário está vázio!";
        return msg;
    }

    private static String read_user(String user_name) {
        if (user_name.equals("lucas123")) {
            return user_name;
        }
        else {
            return null;
        }
    }

    private static void login() {
        System.out.println("Login realizado!");
    }
}