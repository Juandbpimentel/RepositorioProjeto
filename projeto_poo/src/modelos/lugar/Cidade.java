package modelos.lugar;

import dao.lugar.DAOCidade;
import java.util.ArrayList;

public class Cidade {
    private int id;
    private String nome, uf;
    ArrayList<Bairro> bairros;

    public Cidade( String nome, String uf) {
        this.nome = nome;
        this.uf = uf;
        DAOCidade dao = new DAOCidade();
    }



    public String getUf() {
        return uf;
    }
    
    public void setUf(String uf) {
        this.uf = uf;
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

    public String toString(){
        return "(\'"+nome+"\', "+uf+"\')";
    }
}
