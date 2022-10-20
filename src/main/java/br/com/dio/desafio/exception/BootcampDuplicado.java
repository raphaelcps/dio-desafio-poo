package br.com.dio.desafio.exception;

public class BootcampDuplicado extends Exception {

    public BootcampDuplicado(String nome) {
        super("Bootcamp duplicado: " + nome);
    }

}
