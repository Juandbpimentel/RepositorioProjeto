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

    opens Java.classes.empresa to javafx.fxml,javafx.graphics,javafx.controls;
    exports Java.classes.empresa;

    opens Java.classes.usuarios to javafx.fxml,javafx.graphics,javafx.controls;
    exports Java.classes.usuarios;

    opens Java.classes.local to javafx.fxml,javafx.graphics,javafx.controls;
    exports Java.classes.local;


    exports Java.interfaces.gui;

    exports Java.interfaces.alterDB;
    exports Java.classes.usuarios.pessoa;
    opens Java.classes.usuarios.pessoa to javafx.controls, javafx.fxml, javafx.graphics;
}
