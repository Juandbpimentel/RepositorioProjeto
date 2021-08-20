package classes.local;

import java.util.ArrayList;

public class Bairro {
    private int id;
    private String nome;
    ArrayList<Endereco> enderecos;

    public Bairro(int id, String nome, ArrayList<Endereco> enderecos) {
        this.id = id;
        this.nome = nome;
        this.enderecos = enderecos;
    }

    public ArrayList<Endereco> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(ArrayList<Endereco> enderecos) {
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
