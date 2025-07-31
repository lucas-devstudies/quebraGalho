package br.com.quebraGalho.quebraGalho.exception;

public class RepeticaoDeDadosException extends RuntimeException {
    public RepeticaoDeDadosException() {

        super("Impossivel realizar a alteração de dados repetidos");
    }
}
