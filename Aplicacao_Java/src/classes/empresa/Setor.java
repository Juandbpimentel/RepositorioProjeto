package classes.empresa;

import classes.usuarios.Estagiario;
import classes.usuarios.Funcionario;
import classes.usuarios.Gerente;

import java.util.Collection;

public class Setor {
    private Double orcamento;
    private String nome;
    private int id;
    private Collection<Funcionario> funcionarios;
    private Collection<Estagiario> estagiario;
    private Gerente gerente;

    public Setor(Double orcamento, String nome, int id, Collection<Funcionario> funcionarios, Collection<Estagiario> estagiario, Gerente gerente) {
        this.orcamento = orcamento;
        this.nome = nome;
        this.id = id;
        this.funcionarios = funcionarios;
        this.estagiario = estagiario;
        this.gerente = gerente;
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

    public Collection<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(Collection<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }

    public Collection<Estagiario> getEstagiario() {
        return estagiario;
    }

    public void setEstagiario(Collection<Estagiario> estagiario) {
        this.estagiario = estagiario;
    }

    public Gerente getGerente() {
        return gerente;
    }

    public void setGerente(Gerente gerente) {
        this.gerente = gerente;
    }
}
