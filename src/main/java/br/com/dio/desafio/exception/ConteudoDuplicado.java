package br.com.dio.desafio.exception;

public class ConteudoDuplicado extends Exception {

    public ConteudoDuplicado(String nome) {
        super("Conteúdo duplicado: " + nome);
    }
    
}
