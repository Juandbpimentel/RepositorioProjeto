package Java.classes.sistema;

import javafx.application.Platform;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class ControladorMenuLogin {
    @FXML
    private Label lblPrincipal;

    @FXML
    private javafx.scene.control.Button closeButton;

    @FXML
    protected void onHelloButtonClick() {

        lblPrincipal.setText("Parabéns, você é foda pra carai!!!!");
    }

    @FXML
    protected void clearMessage() {

        lblPrincipal.setText("Clique no botão do mal para ver uma mensagem");
    }

    @FXML
    protected void onExitButtonClick() {
        Platform.exit();
    }
}