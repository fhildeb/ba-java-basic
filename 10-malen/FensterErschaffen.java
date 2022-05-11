package Malen;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.scene.layout.VBox;

public class FensterErschaffen extends Application {
	public static void main(String[] args) {
		Application.launch();
	}

	public void start(Stage fenster) {
		fenster.setTitle("Piep");
		fenster.setResizable(true);

		Label text1 = new Label("Erste Zeile");
		VBox fensterVBox = new VBox();

		fensterVBox.getChildren().add(text1);

		Scene buehne = new Scene(fensterVBox, 400, 400);
		fenster.setScene(buehne);
		fenster.show();
	}
}
