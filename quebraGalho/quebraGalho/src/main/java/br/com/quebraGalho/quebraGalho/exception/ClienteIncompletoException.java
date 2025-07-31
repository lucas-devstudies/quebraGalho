package br.com.quebraGalho.quebraGalho.exception;

public class ClienteIncompletoException extends RuntimeException{
    public ClienteIncompletoException(){
        super("Preencha todos os dados corretamente");
    }
}
