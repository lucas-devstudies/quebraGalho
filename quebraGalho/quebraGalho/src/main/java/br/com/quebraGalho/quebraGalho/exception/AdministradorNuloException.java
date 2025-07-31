package br.com.quebraGalho.quebraGalho.exception;

public class AdministradorNuloException extends RuntimeException {
    public AdministradorNuloException() {
        super("Administrador nulo");
    }
}
