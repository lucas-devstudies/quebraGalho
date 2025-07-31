package br.com.quebraGalho.quebraGalho.exception;

public class ClienteNuloException extends RuntimeException {
    public ClienteNuloException() {
        super("Cliente nulo");
    }
}
