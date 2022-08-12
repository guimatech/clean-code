package io.github.guimatech.solucao.lixoso.validate;

public interface Validator<T> {
    void validar(T objeto);
}