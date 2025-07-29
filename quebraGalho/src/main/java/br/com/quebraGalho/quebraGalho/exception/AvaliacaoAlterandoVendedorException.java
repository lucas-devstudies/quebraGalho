package br.com.quebraGalho.quebraGalho.exception;

public class AvaliacaoAlterandoVendedorException extends RuntimeException {
    public AvaliacaoAlterandoVendedorException() {
        super("Impossível alterar o id do vendedor de uma avaliação");
    }
}
