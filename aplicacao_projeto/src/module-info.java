module aplicacao_projeto {
    requires java.sql;
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;


    opens classes.usuarios to javafx.fxml;
    exports classes.usuarios;
}