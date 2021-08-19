package classes.local;

import java.util.Collection;

public class Estado {
    private int id;
    private String nome;
    Collection<Cidade> cidades;

    public Estado(int id, String nome, Collection<Cidade> cidades) {
        this.id = id;
        this.nome = nome;
        this.cidades = cidades;
    }

    public Collection<Cidade> getCidades() {
        return cidades;
    }

    public void setCidades(Collection<Cidade> cidades) {
        this.cidades = cidades;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
