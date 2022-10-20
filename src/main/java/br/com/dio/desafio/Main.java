package br.com.dio.desafio;

import java.time.LocalDate;

import br.com.dio.desafio.dominio.Bootcamp;
import br.com.dio.desafio.dominio.Curso;
import br.com.dio.desafio.dominio.Dev;
import br.com.dio.desafio.dominio.Mentoria;
import br.com.dio.desafio.exception.BootcampDuplicado;
import br.com.dio.desafio.exception.ConteudoDuplicado;

public class Main {

    public static void main(String[] args) throws BootcampDuplicado, ConteudoDuplicado {

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

        Bootcamp bootcamp = new Bootcamp();
        bootcamp.setNome("Bootcamp Java");
        bootcamp.setDescricao("Bootcamp Java");
        bootcamp.getConteudos().add(java);
        bootcamp.getConteudos().add(js);
        bootcamp.getConteudos().add(mentoria);

        System.out.println(bootcamp);

        Dev maria = new Dev();
        maria.setNome("Maria");
        maria.inscreverBootcamp(bootcamp);
        System.out.println("Maria XP: " + maria.calcularTotalXp() + ", maria: " + maria);
        maria.progredir();
        System.out.println("Maria XP: " + maria.calcularTotalXp() + ", maria: " + maria);
        maria.progredir();
        System.out.println("Maria XP: " + maria.calcularTotalXp() + ", maria: " + maria);

        System.out.println("--------------------");

        Dev joao = new Dev();
        joao.setNome("João");
        joao.inscreverBootcamp(bootcamp);
        System.out.println("João XP: " + joao.calcularTotalXp() + ", João: " + joao);
        joao.progredir();
        System.out.println("João XP: " + joao.calcularTotalXp() + ", João: " + joao);
        joao.progredir();
        System.out.println("João XP: " + joao.calcularTotalXp() + ", João: " + joao);
        joao.progredir();
        System.out.println("João XP: " + joao.calcularTotalXp() + ", João: " + joao);
        joao.progredir();

        System.out.println("--------------------");

        Dev monica = new Dev();
        monica.setNome("Monica");
        monica.inscreverBootcamp(bootcamp);
        System.out.println("Monica XP: " + monica.calcularTotalXp() + ", Monica: " + monica);
        
        monica.progredir(js);
        System.out.println("Monica XP: " + monica.calcularTotalXp() + ", Monica: " + monica);

        Curso flutter = new Curso();
        flutter.setTitulo("Flutter");
        flutter.setDescricao("Curso de Flutter");
        flutter.setCargaHoraria(15);

        monica.progredir(flutter);
        System.out.println("Monica XP: " + monica.calcularTotalXp() + ", Monica: " + monica);

        monica.inscreverConteudo(flutter);
        System.out.println("Monica XP: " + monica.calcularTotalXp() + ", Monica: " + monica);
        monica.progredir(flutter);
        System.out.println("Monica XP: " + monica.calcularTotalXp() + ", Monica: " + monica);

        try {
            monica.inscreverConteudo(flutter);
        } catch (ConteudoDuplicado e) {
            System.err.println(e);
        }

        try {
            monica.inscreverBootcamp(bootcamp);
        } catch (BootcampDuplicado e) {
            System.err.println(e);
        }

    }

}
