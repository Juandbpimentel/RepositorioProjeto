package modelos.lugar;

import java.util.ArrayList;

public class Cidade {
    private int id;
    private String nome, 
                   id_estado;
    ArrayList<Bairro> bairros;

    public Cidade(int id, String nome, String id_estado) {
        this.id = id;
        this.nome = nome;
        this.id_estado = id_estado;
        //this.bairros = bairros;
    }



    public String getId_estado() {
        return id_estado;
    }
    
    public void setId_estado(String id_estado) {
        this.id_estado = id_estado;
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
