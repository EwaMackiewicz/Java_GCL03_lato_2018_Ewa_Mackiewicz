package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        Parent root = FXMLLoader.load(getClass().getResource("Budzik.fxml"));
        primaryStage.setTitle("BUDZIK");
        primaryStage.setScene(new Scene(root, 535, 800));
        primaryStage.show();

    }


    public static void main(String[] args) {
        launch(args);
    }

}
