package model;

import java.net.URL;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ListaReceita extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        URL url = getClass().getResource("/view/ListaReceita.fxml");
        Parent root = FXMLLoader.load(url); 
        Scene scene = new Scene(root);
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
    
}
