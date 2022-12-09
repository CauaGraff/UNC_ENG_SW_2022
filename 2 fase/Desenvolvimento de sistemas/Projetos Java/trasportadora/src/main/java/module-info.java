module br.edu.caua.projetotransportadora.trasportadora {
    requires javafx.controls;
    requires javafx.fxml;
	requires javafx.base;
	requires java.sql;

    opens br.edu.caua.projetotransportadora.trasportadora to javafx.fxml;
    
    exports br.edu.caua.projetotransportadora.trasportadora.entidades;

    exports br.edu.caua.projetotransportadora.trasportadora;
}
