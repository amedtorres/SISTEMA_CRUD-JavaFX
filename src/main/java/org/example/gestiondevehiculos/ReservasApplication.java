package org.example.gestiondevehiculos;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ReservasApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(ReservasApplication.class.getResource("vistaPrincipal.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            stage.setTitle("GESTION DE VEHICULOS");
            stage.setScene(scene);
            stage.show();
        }catch (Exception e){
            e.getMessage();
        }
    }

    public static void main(String[] args) {
        launch();
    }
}
