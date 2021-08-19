package classes.local;

import java.util.Collection;

public class Cidade {
    private int id;
    private String nome;
    Collection<Bairro> bairros;

    public Cidade(int id, String nome, Collection<Bairro> bairros) {
        this.id = id;
        this.nome = nome;
        this.bairros = bairros;
    }

    public Collection<Bairro> getBairros() {
        return bairros;
    }

    public void setBairros(Collection<Bairro> bairros) {
        this.bairros = bairros;
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
