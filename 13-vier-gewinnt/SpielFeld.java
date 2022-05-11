package VierGewinnt;

import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

public class SpielFeld extends BorderPane {

    private Spiel spiel;
    private HBox labelBox, buttonBox;
    private GridPane gridPanel;
    private Button[] button;
    private Label[] field;
    private Label display;
    private Button neuesSpiel, hilfe;
    private Image user, red, green, gray;
    private final int ROT, GRUEN;

    /**
     * Konstruktormethode zur Einrichtung des Spielfeldes.
     */

    public SpielFeld() {
        // spiel enthaelt die Spiellogik
        spiel = new Spiel(this);

        // Arrays fuer Auswahl-Buttons und die Spielsteine
        button = new Button[7];
        field = new Label[42];

        // Bilder fuer Auswahl-Button, Spieler1, Spieler2 und "leere Steine"
        user = new Image("./pics/user.gif");
        red = new Image("./pics/red.gif");
        green = new Image("./pics/green.gif");
        gray = new Image("./pics/grau.gif");

        // Spieler1 ist rot, Spieler2 gruen
        ROT = 1;
        GRUEN = 2;

        // Initialisierung des Labels am oberen Rand
        display = new Label("Rot beginnt!");
        labelBox = new HBox(display);
        labelBox.setAlignment(Pos.CENTER);
        labelBox.setStyle("-fx-background-color: red;");
        this.setTop(labelBox);

        // Initialisierung des Spielfeldes in der Mitte
        gridPanel = new GridPane();
        gridPanel.setAlignment(Pos.CENTER);
        gridPanel.setStyle("-fx-background-color: black;");
        gridPanel.setPadding(new Insets(3));
        // Hinzufuegen der Auswahlknoepfe mit Event-Handlern
        for (int i = 0; i < 7; i++) {
            button[i] = new Button("", new ImageView(user));
            button[i].setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
            button[i].addEventHandler(ActionEvent.ACTION, e -> spiel.waehleSpalte(e));
            gridPanel.add(button[i], i, 0);
        }
        // Hinzufuegen der "Spielsteine"
        for (int i = 0; i < 42; i++) {
            field[i] = new Label("", new ImageView(gray));
            field[i].setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
            field[i].setStyle("-fx-border-color: white;");
            gridPanel.add(field[i], i % 7, i / 7 + 1);
        }
        this.setCenter(gridPanel);

        // Initialisierung der "Menue-Buttons" am unteren Rand
        buttonBox = new HBox(20);
        buttonBox.setAlignment(Pos.CENTER);
        buttonBox.setPadding(new Insets(5));
        neuesSpiel = new Button("Neues Spiel");
        neuesSpiel.addEventHandler(ActionEvent.ACTION, e -> spiel.clean());
        hilfe = new Button("Hilfe");
        hilfe.addEventHandler(ActionEvent.ACTION, e -> new HilfeDialog().showAndWait());
        buttonBox.getChildren().addAll(neuesSpiel, hilfe);
        this.setBottom(buttonBox);
    }

    /**
     * Getter-Methode fuer den Button der i-ten Spalte.
     * 
     * @param i Spaltennummer (- 1)
     * @return Butten in der i(- 1)ten Spalte
     */

    public Button getButton(int i) {
        return button[i];
    }

    /**
     * Setter-Methode fuer den i-ten Spielstein.
     * 
     * @param i     Spielsteinnummer (- 1)
     * @param farbe Farbe des neuen Spielsteins
     */

    public void setGraphic(int i, int farbe) {
        if (farbe == ROT) {
            field[i].setGraphic(new ImageView(red));
        } else {
            if (farbe == GRUEN) {
                field[i].setGraphic(new ImageView(green));
            } else {
                field[i].setGraphic(new ImageView(gray));
            }
        }
    }

    /**
     * Aendert das display-Label entsprechend dem aktuellen Spieler.
     * Dabei wird ausserdem die Farbe des Labels angepasst.
     * 
     * @param farbe Farbe des derzeitigen Spielers
     */

    public void amZug(int farbe) {
        if (farbe == ROT) {
            display.setText("Rot ist am Zug");
            labelBox.setStyle("-fx-background-color: red;");
        } else {
            display.setText("Gruen ist am Zug");
            labelBox.setStyle("-fx-background-color: green;");
        }
    }

    /**
     * Reagiert auf den Sieg eines Spiels * Das display-Label wird entsprechend der
     * Farbe gesetzt und die
     * Buttons gesperrt.
     * Wenn gleich viele Farben rot und gruen sind wird
     * das Label weiss gefaerbt und "Unentschieden" angezeigt.
     * 
     * @param farbe Farbe des Gewinners
     */

    public void gewonnen(int farbe) {
        if (farbe == ROT) {
            display.setText("Rot hat gewonnen!");
        } else {
            if (farbe == GRUEN) {
                display.setText("Gruen hat gewonnen!");
            } else {
                display.setText("Unentschieden!");
                labelBox.setStyle("-fx-background-color: white;");
            }
        }
        // zum Deaktivieren der Buttons
        for (int i = 0; i < 7; i++) {
            button[i].setDisable(true);
        }
    }

    /**
     * Bereitet ein neues Spiel vor. Das display-Label wird zurueckgesetzt, die
     * Buttons entsperrt
     * und die Spieldelder grau gefaerbt.
     */

    public void neuesSpiel() {
        display.setText("Rot beginnt");
        labelBox.setStyle("-fx-background-color: red;");
        // aktiviert die Buttons wieder
        for (int i = 0; i < 7; i++) {
            button[i].setDisable(false);
        }
        // setzt das Spielfeld zurueck
        for (int i = 0; i < 42; i++) {
            this.setGraphic(i, 0);
        }
    }

    /**
     * Gibt eine Fehler auf dem display-Label aus.
     * 
     * @param fehlermeldung auszugebende Fehlermeldung
     */

    public void meldeFehler(String fehlermeldung) {
        display.setText(fehlermeldung);
    }

}