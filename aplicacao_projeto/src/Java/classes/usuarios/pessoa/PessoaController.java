package Java.classes.usuarios.pessoa;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import javax.swing.text.html.ImageView;

public class PessoaController {
    private String login = "",senha = "";
    private ImageView logoHEAD;
    @FXML
    protected Label lblRegister;

    @FXML
    protected Label lblErrorPassword;

    @FXML
    protected Label lblErrorLogin;

    @FXML
    protected TextField loginTextField;
    @FXML
    protected TextField passwordTextField;

    @FXML
    protected javafx.scene.control.Button loginButton;

    @FXML
    protected javafx.scene.control.Button closeButton;

    @FXML
    protected void onLoginButtonClick() {
        boolean errorLogin = false, errorPassword = false;
        if (loginTextField.getText().length() == 0) {
            showErrorLogin();
            errorLogin = true;
        }
        if (passwordTextField.getText().length() == 0) {
            showErrorPassword();
            errorPassword = true;
        }
        if (errorLogin == false)
            clearErrorLogin();
        if (errorPassword == false)
            clearErrorPassword();
        if (errorLogin == true || errorPassword == true) {
            return;
        }

        setSenha(passwordTextField.getText());
        setLogin(loginTextField.getText());

        System.out.println(this.login + this.senha);
    }

    protected void showErrorLogin(){
        this.lblErrorLogin.setText("O campo Login não pode estar vazio.");
    }

    protected void showErrorPassword(){
        this.lblErrorPassword.setText("O campo Password não pode estar vazio.");
    }

    protected void clearErrorLogin(){
        this.lblErrorLogin.setText("");
    }


    protected void clearErrorPassword(){
        this.lblErrorPassword.setText("");
    }

    @FXML
    protected void onCloseButtonClick(){
        Platform.exit();
    }

    @FXML
    protected void lblRegisterClick(){
        System.out.println("Click Register");
    }

    public String getLogin() {
        return login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setLogin(String login) {
        this.login = login;
    }
}