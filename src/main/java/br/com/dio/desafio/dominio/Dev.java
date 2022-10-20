package br.com.dio.desafio.dominio;

import java.util.LinkedHashSet;
import java.util.Optional;
import java.util.Set;

import br.com.dio.desafio.exception.BootcampDuplicado;
import br.com.dio.desafio.exception.ConteudoDuplicado;

public class Dev {

    private String nome;
    private Set<Conteudo> conteudosInscritos = new LinkedHashSet<>();
    private Set<Conteudo> conteudosConcluidos = new LinkedHashSet<>();

    public void inscreverBootcamp(Bootcamp bootcamp) throws BootcampDuplicado {

        // verifica já inscrito
        if (bootcamp.getDevsInscritos().contains(this)) {
            throw new BootcampDuplicado(bootcamp.getNome());
        }

        // não inclui conteúdo já concluído
        bootcamp.getConteudos().forEach(c -> {
            if (!this.conteudosConcluidos.contains(c)) {
                this.conteudosInscritos.add(c);
            }
        });

        bootcamp.getDevsInscritos().add(this);
    }

    public void inscreverConteudo(Conteudo conteudo) throws ConteudoDuplicado {

        if (conteudosInscritos.contains(conteudo) ||
            conteudosConcluidos.contains(conteudo)) {
            throw new ConteudoDuplicado(conteudo.getTitulo());
        }
        this.conteudosInscritos.add(conteudo);
    }

    private void doProgredir(Optional<Conteudo> conteudo, String erro) {
        conteudo.ifPresentOrElse(
            c -> {
                conteudosConcluidos.add(c);
                this.conteudosInscritos.remove(c);
            },
            () -> System.err.println(erro)
        );
    }

    public void progredir() {
        doProgredir(this.conteudosInscritos.stream().findFirst(), "Você não está matriculado em nenhum conteúdo!");
    }

    public void progredir(Conteudo conteudo) {
        doProgredir(this.conteudosInscritos.stream().filter(c -> c.equals(conteudo)).findFirst(), "Você não está matriculado neste conteúdo!");
    }

    public double calcularTotalXp() {
        return this.conteudosConcluidos.stream().mapToDouble(Conteudo::calculaXp).sum();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Set<Conteudo> getConteudosInscritos() {
        return conteudosInscritos;
    }

    public void setConteudosInscritos(Set<Conteudo> conteudosInscritos) {
        this.conteudosInscritos = conteudosInscritos;
    }

    public Set<Conteudo> getConteudosConcluidos() {
        return conteudosConcluidos;
    }

    public void setConteudosConcluidos(Set<Conteudo> conteudosConcluidos) {
        this.conteudosConcluidos = conteudosConcluidos;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((nome == null) ? 0 : nome.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Dev other = (Dev) obj;
        if (nome == null) {
            if (other.nome != null)
                return false;
        } else if (!nome.equals(other.nome))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Dev [nome=" + nome + ", conteudosInscritos=" + conteudosInscritos + ", conteudosConcluidos="
                + conteudosConcluidos + "]";
    }
    
}
