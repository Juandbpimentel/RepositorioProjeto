package interfaces.gui;

public interface DonoGUI extends PessoaGUI{
    public abstract void administrarEmpresa();
    public abstract void administrarDiretores();
    public abstract void administrarFuncionarios(int id);
    public abstract void administrarEstagiarios();
    public abstract void administrarSetores(String cnpjEmpresa);

}
