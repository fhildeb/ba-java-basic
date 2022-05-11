package Zufall;

import javax.swing.*;
import java.awt.*;

/**
 * Test-Fenster zur optischen Ueberpruefung der Guete eines
 * Zufallszahlen-Generators
 * 
 */

public class ZufallsTestFenster extends JFrame {

    /**
     * 
     */
    private static final long serialVersionUID = 3844516752929027959L;

    /**
     * der zu testende Zufallzahlen-Generator
     */
    private Zufall zufall;

    /**
     * die Breite des Fensters
     */
    private int breite;

    /**
     * die Hoehe des Fensters
     */
    private int hoehe;

    /**
     * der Konstruktor eines ZufallsTestFensters gibt Breite und Hoehe des
     * Fensters vor
     *
     * @param breite Breite des Fensters
     * @param hoehe  Hoehe des Fensters
     */
    public ZufallsTestFenster(int breite, int hoehe) {
        zufall = new Zufall();
        this.breite = breite;
        this.hoehe = hoehe;
        this.setSize(breite, hoehe); // Fenstergroesse fuer Frame setzen
        this.setVisible(true); // Fenster sichtbar machen
    }

    /**
     * Methode zur Darstellung des Fensters
     *
     * @param g Graphik-Kontext des Fensters
     */
    public void paint(Graphics g) {
        int i, x, y;
        for (i = 0; i < breite * hoehe; i = i + 1) {
            x = zufall.zufallsInt(breite);
            y = zufall.zufallsInt(hoehe);
            g.drawLine(x, y, x, y); // Punkt bei (x,y) setzen
        }
    }

    /**
     * Start-Methode
     *
     * @param args Kommandozeilen-Parameter
     */
    @SuppressWarnings("unused")
    public static void main(String[] args) {
        ZufallsTestFenster fenster = new ZufallsTestFenster(500, 500);

    }
}
