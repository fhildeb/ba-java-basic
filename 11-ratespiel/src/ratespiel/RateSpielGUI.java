package ratespiel;

import javafx.scene.layout.BorderPane;
import javafx.scene.control.*;

public class RateSpielGUI extends BorderPane {
	private Button versuchKnopf;
	private TextField versuchTF, nachrichtTF;
	private MenuBar menuBar;
	private Menu spielMenu;
	private MenuItem neuOpt, endeOpt;

	public RateSpielGUI() {

		versuchKnopf = new Button("Versuch");
		versuchTF = new TextField("Versuchszahl");
		nachrichtTF = new TextField("Kannst du eine Zahl zwischen 0 und 100 erraten?");

		// Deaktiviert Ergebnisfeld
		nachrichtTF.setDisable(true);

		// Positionieren
		setCenter(versuchTF);
		setRight(versuchKnopf);
		setBottom(nachrichtTF);

		// Vergroessern
		versuchKnopf.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		versuchTF.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		nachrichtTF.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);

		// Menue-Leiste
		menuBar = new MenuBar();
		// Positionieren
		setTop(menuBar);
		// Menue
		spielMenu = new Menu("Spiel");
		// Zur Leiste hinzufuegen
		menuBar.getMenus().add(spielMenu);
		// Menue-Elemente
		neuOpt = new MenuItem("Neues Spiel");
		endeOpt = new MenuItem("Ende");
		// Zum Menue hinzufuegen
		spielMenu.getItems().addAll(neuOpt, endeOpt);
	}

	/**
	 * Getter-Methode fuer den Button.
	 * 
	 * @return Button
	 */

	public Button getVersuchKnopf() {
		return versuchKnopf;
	}

	/**
	 * Getter-Methode fuer das "Neues-Spiel"-Menue;
	 * 
	 * @return Menue-Element
	 */

	public MenuItem getNeuOpt() {
		return neuOpt;
	}

	/**
	 * Getter-Methode fuer das "Ende"-Menue
	 * 
	 * @return Menue-Element
	 */

	public MenuItem getEndeOpt() {
		return endeOpt;
	}

	/**
	 * Getter-Methode fuer den aktuellen Text im Eingabefeld versuchTF.
	 * 
	 * @return Eingabe
	 */

	public String holeVersuch() {
		return versuchTF.getText();
	}

	/**
	 * Setter-Methode fuer den Text im Ausgabefeld nachrichtTF.
	 * 
	 * @param nachricht Aausgabe
	 */

	public void ausgabeNachricht(String nachricht) {
		nachrichtTF.setText(nachricht);
	}

	/**
	 * Hilfsmethode zum Aktivieren und Deaktivieren des Buttons und
	 * Eingabe-Textfeldes.
	 * 
	 * @param bool Aktivierung (true) oder Deaktivierung (false)
	 */

	public void setEnabled(boolean bool) {
		versuchKnopf.setDisable(!bool);
		versuchTF.setDisable(!bool);
	}
}