package malen;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.scene.canvas.*;
import javafx.scene.input.*;
import javafx.scene.paint.*;
import javafx.scene.image.*;
import javafx.geometry.Point2D;
import javafx.event.*;

public class MausMalen extends Application {

	private Point2D aktuellerPunkt, vorherigerPunkt;
	private Color zeichenFarbe;

	public static void main(String[] args) {
		Application.launch(args); // startet die Anwendung
	}

	public void start(Stage primaryStage) {

		primaryStage.setTitle("Maus-Malen");
		primaryStage.setResizable(false);

		Canvas canvas = new Canvas(300, 250);
		GraphicsContext gc = canvas.getGraphicsContext2D();
		canvas.addEventHandler(MouseEvent.MOUSE_PRESSED, e -> setAktuellerPunkt(e, gc));
		canvas.addEventHandler(MouseEvent.MOUSE_DRAGGED, e -> neuerAktuellerPunkt(e, gc));

		ColorPicker cp = new ColorPicker(Color.BLUE);
		cp.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		cp.addEventHandler(ActionEvent.ACTION, e -> setZeichenfarbe(cp.getValue()));

		ImageView imageView = new ImageView(new Image("./pics/radiergummi.png")); // dafuer muss das Bild im aktuellen
																					// Verzeichnis sein

		Button button = new Button("Clear", imageView); // sonst gibt es eine Fehlermeldung
		button.addEventHandler(ActionEvent.ACTION, e -> loeschen(canvas, gc));
		button.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);

		zeichenFarbe = cp.getValue();

		VBox root = new VBox();

		root.getChildren().addAll(canvas, cp, button);

		Scene scene = new Scene(root);

		primaryStage.setScene(scene);

		primaryStage.show();
	}

	public void setAktuellerPunkt(MouseEvent e, GraphicsContext gc) {
		aktuellerPunkt = new Point2D(e.getX(), e.getY());
		vorherigerPunkt = aktuellerPunkt;
		paintLinie(gc);
	}

	public void neuerAktuellerPunkt(MouseEvent e, GraphicsContext gc) {
		vorherigerPunkt = aktuellerPunkt;
		aktuellerPunkt = new Point2D(e.getX(), e.getY());
		paintLinie(gc);
	}

	public void paintLinie(GraphicsContext gc) {
		gc.setFill(zeichenFarbe);
		gc.setStroke(zeichenFarbe);
		gc.strokeLine(vorherigerPunkt.getX(), vorherigerPunkt.getY(), aktuellerPunkt.getX(), aktuellerPunkt.getY());
	}

	public void setZeichenfarbe(Color FarbeNeu) {
		zeichenFarbe = FarbeNeu;
	}

	public void loeschen(Canvas canvas, GraphicsContext gc) {
		gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
	}
}
