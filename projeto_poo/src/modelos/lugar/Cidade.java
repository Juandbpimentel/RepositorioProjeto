package modelos.lugar;

import java.util.ArrayList;

public class Cidade {
    private int id;
    private String nome;
    ArrayList<Bairro> bairros;

    public Cidade(int id, String nome/*, ArrayList<Bairro> bairros*/) {
        this.id = id;
        this.nome = nome;
        //this.bairros = bairros;
    }

    public ArrayList<Bairro> getBairros() {
        return bairros;
    }

    public void setBairros(ArrayList<Bairro> bairros) {
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
