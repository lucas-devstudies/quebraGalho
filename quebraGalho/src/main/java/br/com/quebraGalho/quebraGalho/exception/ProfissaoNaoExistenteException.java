package br.com.quebraGalho.quebraGalho.exception;

public class ProfissaoNaoExistenteException extends RuntimeException {
    public ProfissaoNaoExistenteException() {
        super("Profissão não encontrada");
    }
}
