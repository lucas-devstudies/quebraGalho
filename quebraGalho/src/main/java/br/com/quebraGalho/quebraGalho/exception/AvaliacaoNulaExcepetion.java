package br.com.quebraGalho.quebraGalho.exception;

public class AvaliacaoNulaExcepetion extends RuntimeException {
    public AvaliacaoNulaExcepetion() {
        super("Vendedor não deve ter avaliação ao ser criado");
    }
}
