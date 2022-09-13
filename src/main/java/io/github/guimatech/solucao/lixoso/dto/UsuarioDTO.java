package io.github.guimatech.solucao.lixoso.dto;

import lombok.Data;

@Data
public class UsuarioDTO {

    private String nome;
    private String email;
    private String senha;
    private String senhaRepetida;
}
