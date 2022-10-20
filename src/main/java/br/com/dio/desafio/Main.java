package br.com.dio.desafio;

import java.time.LocalDate;

import br.com.dio.desafio.dominio.Curso;
import br.com.dio.desafio.dominio.Mentoria;

public class Main {

    public static void main(String[] args) {

        Curso java = new Curso();
        java.setTitulo("Java");
        java.setDescricao("Curso de Java");
        java.setCargaHoraria(10);

        Curso js = new Curso();
        js.setTitulo("JavaScript");
        js.setDescricao("Curso de JavaScript");
        js.setCargaHoraria(12);

        Mentoria mentoria = new Mentoria();
        mentoria.setTitulo("Mentoria de Java");
        mentoria.setDescricao("Mentoria de Java");
        mentoria.setData(LocalDate.now());

        System.out.println(java);
        System.out.println(js);
        System.out.println(mentoria);

    }

}
