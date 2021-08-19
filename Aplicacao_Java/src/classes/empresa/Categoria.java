package classes.empresa;

public class Categoria {
    private int id,cargaHoraria;;
    private String nome,descricao;
    private Double salario;

    public Categoria(int id, int cargaHoraria, String nome, String descricao, Double salario) {
        this.id = id;
        this.cargaHoraria = cargaHoraria;
        this.nome = nome;
        this.descricao = descricao;
        this.salario = salario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
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