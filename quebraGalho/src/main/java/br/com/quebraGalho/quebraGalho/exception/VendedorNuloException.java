package br.com.quebraGalho.quebraGalho.exception;

public class VendedorNuloException extends RuntimeException {
    public VendedorNuloException() {
        super("Vendedor nulo");
    }
}
