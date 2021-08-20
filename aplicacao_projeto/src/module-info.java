module aplicacao_projeto {
    requires java.sql;
    requires javafx.fxml;
    requires javafx.graphics;
    requires javafx.controls;
    requires javafx.base;
    requires javafx.media;
    requires javafx.swing;
    requires javafx.web;

    opens Java.classes.sistema to javafx.fxml,javafx.graphics,javafx.controls;
    exports Java.classes.sistema;
}