package br.com.quebraGalho.quebraGalho.exception;

public class ProfissaoObrigatoriaException extends RuntimeException{
    public ProfissaoObrigatoriaException(){
        super("Vendedor deve ter ao menos uma profissao");
    }
}
