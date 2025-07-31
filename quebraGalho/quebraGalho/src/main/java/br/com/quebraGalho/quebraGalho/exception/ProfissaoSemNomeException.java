package br.com.quebraGalho.quebraGalho.exception;

public class ProfissaoSemNomeException extends RuntimeException {
    public ProfissaoSemNomeException() {
        super("Preencha os campos corretamente");
    }
}
