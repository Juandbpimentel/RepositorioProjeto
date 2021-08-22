package modelos.empresa;

public class Categoria {
    private int id, carga_horaria;
    private String nome,descricao, cnpj_empresa;
    private Double salario;

    public Categoria(int id, int carga, String nome, String descricao2, double salario2, String cnpj) {
        this.id = id;
        this.carga_horaria = carga;
        this.nome = nome;
        this.descricao = descricao2;
        this.salario = salario2;
        this.cnpj_empresa = cnpj;
    }

    public Categoria(int salario2, int carga2, String nome2, String cnpj, int carga, String descricao2) {
    }

    public String getCnpj_empresa() {
        return cnpj_empresa;
    }
    
    public void setCnpj_empresa(String cnpj_empresa) {
        this.cnpj_empresa = cnpj_empresa;
    }

    
    public void setCarga_horaria(int carga_horaria) {
        this.carga_horaria = carga_horaria;
    }

    public int getCarga_horaria() {
        return carga_horaria;
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }
}
