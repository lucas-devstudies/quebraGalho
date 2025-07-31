package br.com.quebraGalho.quebraGalho.exception;

public class AdministradorIncompletoException extends RuntimeException {
    public AdministradorIncompletoException() {
        super("Preencha todos os dados corretamente");
    }
}
