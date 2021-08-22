package modelos.empresa;

import modelos.usuarios.Estagiario;
import modelos.usuarios.Funcionario;
import modelos.usuarios.Gerente;

import java.util.ArrayList;

public class Setor {
    private Double orcamento;
    private String nome;
    private int id;
    private String cnpj_empresa;
    private ArrayList<Funcionario> funcionarios;
    private ArrayList<Estagiario> estagiario;
    private Gerente gerente;

    public Setor(Double orcamento, String nome, int id, String cnpj_empresa) {
        this.orcamento = orcamento;
        this.nome = nome;
        this.id = id;
        this.cnpj_empresa = cnpj_empresa;
        /*
        this.funcionarios = funcionarios;
        this.estagiario = estagiario;
        this.gerente = gerente;
        */
    }



    public String getCnpj_empresa() {
        return cnpj_empresa;
    }

    public void setCnpj_empresa(String cnpj_empresa) {
        this.cnpj_empresa = cnpj_empresa;
    }

    public Double getOrcamento() {
        return orcamento;
    }

    public void setOrcamento(Double orcamento) {
        this.orcamento = orcamento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(ArrayList<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }

    public ArrayList<Estagiario> getEstagiario() {
        return estagiario;
    }

    public void setEstagiario(ArrayList<Estagiario> estagiario) {
        this.estagiario = estagiario;
    }

    public Gerente getGerente() {
        return gerente;
    }

    public void setGerente(Gerente gerente) {
        this.gerente = gerente;
    }
}
