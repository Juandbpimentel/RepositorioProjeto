package modelos.lugar;

public class Endereco {
        private int id, numero, id_bairro;
        private String cep, rua, complemento;

    public Endereco( int numero, String cep, String rua, String complemento, int id_bairro) {
        this.numero = numero;
        this.cep = cep;
        this.rua = rua;
        this.complemento = complemento;
        this.id_bairro = id_bairro;
    }
    

    public int getId_bairro() {
        return id_bairro;
    }
    
    public void setId_bairro(int id_bairro) {
        this.id_bairro = id_bairro;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }
}
