package classes.local;

import java.util.Collection;

public class Bairro {
    private int id;
    private String nome;
    Collection<Endereco> enderecos;

    public Bairro(int id, String nome, Collection<Endereco> enderecos) {
        this.id = id;
        this.nome = nome;
        this.enderecos = enderecos;
    }

    public Collection<Endereco> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(Collection<Endereco> enderecos) {
        this.enderecos = enderecos;
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
