package modelos.manutencao;

import java.sql.Timestamp;

public class LogInteracao {
    private Timestamp data;
    private String tipo,codigo,mensagem,login_pessoa;
    private int id;

    public LogInteracao(Timestamp data, String tipo, String codigo, String mensagem, int id, String login_pessoa) {
        this.data = data;
        this.tipo = tipo;
        this.codigo = codigo;
        this.mensagem = mensagem;
        this.id = id;
        this.login_pessoa = login_pessoa;
    }

    public Timestamp getData() {
        return data;
    }

    public void setData(Timestamp data) {
        this.data = data;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
