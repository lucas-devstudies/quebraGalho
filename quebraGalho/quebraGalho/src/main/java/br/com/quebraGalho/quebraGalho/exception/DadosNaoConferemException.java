package br.com.quebraGalho.quebraGalho.exception;

public class DadosNaoConferemException extends RuntimeException {
    public DadosNaoConferemException() {
        super("Dados não conferem");
    }
}
