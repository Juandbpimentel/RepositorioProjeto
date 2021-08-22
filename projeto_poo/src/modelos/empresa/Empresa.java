package modelos.empresa;

import modelos.usuarios.Diretor;

import java.util.ArrayList;

public class Empresa {
    private String nome;
    private Double orcamento;
    private String cnpj;
    private String cpf_dono;
    ArrayList<Setor> setores;
    ArrayList<Diretor> diretores;

    public Empresa(String nome, Double orcamento, String cnpj/*, ArrayList<Setor> setores, ArrayList<Diretor> diretores*/) {
        this.nome = nome;
        this.orcamento = orcamento;
        this.cnpj = cnpj;
        /*
        this.setores = setores;
        this.diretores = diretores;
        */
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getOrcamento() { return orcamento;  }

    public void setOrcamento(Double orcamento) {
        this.orcamento = orcamento;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public ArrayList<Setor> getSetores() {
        return setores;
    }

    public void setSetores(ArrayList<Setor> setores) {
        this.setores = setores;
    }

    public ArrayList<Diretor> getDiretores() {
        return diretores;
    }

    public void setDiretores(ArrayList<Diretor> diretores) {
        this.diretores = diretores;
    }
}
