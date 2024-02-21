package org.example.ui;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.Background;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.example.ui.Components.Button;
import org.example.ui.Components.LinkText;

public class HelloApplication extends Application {

    public static void main(String[] args) {
        launch();
    }



    @Override
    public void start(Stage stage) {
        // Crea un contenedor VBox
        VBox vbox = new VBox();

        // Crea un botón "Mi botón"
        LinkText miBoton = new LinkText(true, "Registrar usuario", true);


        // Agrega el botón al contenedor

        vbox.getChildren().add(miBoton);

        vbox.setAlignment(Pos.BASELINE_CENTER);

        // Crea la escena y la muestra
        Scene scene = new Scene(vbox, 300, 200);
        stage.setScene(scene);
        stage.setMaximized(true);
        stage.show();
    }
}