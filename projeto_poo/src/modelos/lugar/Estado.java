package modelos.lugar;

import java.util.ArrayList;

public class Estado {
    private int id;
    private String nome;
    ArrayList<Cidade> cidades;

    public Estado(int id, String nome) {
        this.id = id;
        this.nome = nome;
        //this.cidades = cidades;
    }

    public ArrayList<Cidade> getCidades() {
        return cidades;
    }

    public void setCidades(ArrayList<Cidade> cidades) {
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
