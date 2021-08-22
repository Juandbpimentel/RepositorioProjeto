package modelos.lugar;

import java.util.ArrayList;

public class Bairro {
    private int id;
    private String nome;
    private int id_cidade;
    ArrayList<Endereco> enderecos;

    public Bairro(int id, String nome, int id_cidade) {
        this.id = id;
        this.nome = nome;
        this.id_cidade = id_cidade;
        //this.enderecos = enderecos;
    }



    public int getId_cidade() {
        return id_cidade;
    }

    public void setId_cidade(int id_cidade) {
        this.id_cidade = id_cidade;
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
