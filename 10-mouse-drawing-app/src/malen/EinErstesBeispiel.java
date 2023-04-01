package malen;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.layout.VBox;

public class EinErstesBeispiel extends Application {
    public static void main(String[] args) {
        // launch() startet die Anwendung

        Application.launch(args);
    }

    public void start(Stage punktZeichnen) {

        punktZeichnen.setTitle("Ein JavaFX Beispiel");
        punktZeichnen.setResizable(true);

        Label label = new Label("Ein erstes JavaFX Beispiel!");
        Button button = new Button("Button");

        VBox root = new VBox();

        root.getChildren().add(label);
        root.getChildren().add(button);

        Scene scene = new Scene(root);

        punktZeichnen.setScene(scene);

        punktZeichnen.show();
    }
}