package classes.empresa;

import classes.usuarios.Diretor;

import java.util.Collection;

public class Empresa {
    private String nome;
    private Double orcamento;
    private String cnpj;
    Collection<Setor> setores;
    Collection<Diretor> diretores;

    public Empresa(String nome, Double orcamento, String cnpj, Collection<Setor> setores, Collection<Diretor> diretores) {
        this.nome = nome;
        this.orcamento = orcamento;
        this.cnpj = cnpj;
        this.setores = setores;
        this.diretores = diretores;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getOrcamento() {
        return orcamento;
    }

    public void setOrcamento(Double orcamento) {
        this.orcamento = orcamento;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public Collection<Setor> getSetores() {
        return setores;
    }

    public void setSetores(Collection<Setor> setores) {
        this.setores = setores;
    }

    public Collection<Diretor> getDiretores() {
        return diretores;
    }

    public void setDiretores(Collection<Diretor> diretores) {
        this.diretores = diretores;
    }
}
