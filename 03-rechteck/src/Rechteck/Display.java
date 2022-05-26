package rechteck;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

/**
 * die Klasse Display
 * liefert eine Grafikanzeige mit Koordinatensystem und kann
 * Objekte der Klassen Punkt und Rechteck darstellen
 *
 * 
 */

public class Display extends Frame {

    private static final long serialVersionUID = 2706861880458796149L;

    /**
     * Dimensionen des Anzeigebereichs
     */
    int width;
    int height;

    /**
     * Durchmesser fuer Punkte und Achsenmarkierungen
     */
    int pixnum = 4;

    /**
     * Hintergrundbild zur Doppelpufferung
     */
    Image dbimage;

    /**
     * Hintergrund-Graphikkontext
     */
    Graphics dbgraphics;

    /**
     * darzustellende Punkte
     */
    Vector<Punkt> punkte;

    /**
     * darzustellende Rechtecke
     */

    Vector<Rechteck> rechtecke;

    /**
     * Konstruktor
     *
     * @param width  Breite der Anzeige
     * @param height Hoehe der Anzeige
     */
    public Display(int width, int height) {
        this.width = width;
        this.height = height;

        // Groesse setzen
        setSize(width, height);
        // keine Groessen-Aenderung zulassen
        setResizable(false);
        // Titeltext
        setTitle("Rechteck-Anzeige");
        // sichtbar machen
        setVisible(true);
        // Hintergrundbild erzeugen
        dbimage = createImage(width, height);
        // Hintergrundgrafik holen
        dbgraphics = dbimage.getGraphics();
        // Darstellung anfordern

        punkte = new Vector<Punkt>();
        rechtecke = new Vector<Rechteck>();

        // Listener fuer Fensterereignisse
        addWindowListener(
                // anonymer WindowAdapter
                new WindowAdapter() {
                    /**
                     * Reaktion auf Ereignis "Fenster schliessen"
                     *
                     * @param e WindowsEvent
                     */
                    public void windowClosing(WindowEvent e) {
                        setVisible(false);
                        dispose();
                        System.exit(0);
                    }
                });
    }

    /**
     * update() wird als Reaktion auf repaint() aufgerufen
     *
     * @param g Grahpik-Kontext
     */
    public void update(Graphics g) {
        paint(g);
    }

    /**
     * Zeichnen des Frames
     *
     * @param g Grafik-Kontext
     */
    public void paint(Graphics g) {
        if (dbimage == null) {
            return;
        }

        // auf Hintergrundbild: alles loeschen
        dbgraphics.clearRect(0, 0, width, height);

        // auf Hintergrundbild: alle Punkte zeichnen
        Punkt p;
        Enumeration<Punkt> ps = punkte.elements();

        while (ps.hasMoreElements()) {
            p = ps.nextElement();
            // 10-fache Vergroesserung
            int x = (int) (10 * p.getx());
            int y = (int) (10 * p.gety());

            // auf Hintergrundbild: "dicken" Punkt zeichnen und beschriften
            dbgraphics.drawString(p.toString(), width / 2 + (x + pixnum), height / 2 - (y + pixnum));
            dbgraphics.fillOval(width / 2 + (x - pixnum), height / 2 - (y + pixnum), 2 * pixnum, 2 * pixnum);

        }

        // auf Hintergrundbild: alle Rechtecke zeichnen
        Rechteck r;
        Enumeration<Rechteck> rs = rechtecke.elements();

        while (rs.hasMoreElements()) {
            r = rs.nextElement();
            // 10-fache Vergroesserung der Koordinaten der linken oberen Ecke des Rechtecks
            int x = (int) (10 * r.getStartpunkt().getx());
            int y = (int) (10 * (r.getStartpunkt().gety() + r.getHoehe()));

            int b = (int) (10 * r.getBreite());
            int h = (int) (10 * r.getHoehe());

            // auf Hintergrundbild Rechteck zeichnen
            dbgraphics.drawRect(width / 2 + x, height / 2 - y, b, h);

            // 10-fache Vergroesserung des Startpunktes (linke untere Ecke)
            int startx = (int) (10 * r.getStartpunkt().getx());
            int starty = (int) (10 * r.getStartpunkt().gety());

            // Startpunkt "dick" darstellen
            dbgraphics.drawString(r.getStartpunkt().toString(), width / 2 + (startx + pixnum),
                    height / 2 - (starty + pixnum));
            dbgraphics.fillOval(width / 2 + (startx - pixnum), height / 2 - (starty + pixnum), 2 * pixnum, 2 * pixnum);

        }

        // auf Hintergrundbild: x-Achse zeichnen
        dbgraphics.drawLine(0, height / 2, width, height / 2);

        // auf Hintergrundbild: y-Achse zeichnen
        dbgraphics.drawLine(width / 2, 0, width / 2, height);

        // x-Achsen-Markierungen
        int i;
        for (i = 10; i <= width / 2; i = i + 10) {
            dbgraphics.drawLine(width / 2 + i, height / 2 - pixnum, width / 2 + i, height / 2 + pixnum);
            dbgraphics.drawLine(width / 2 - i, height / 2 - pixnum, width / 2 - i, height / 2 + pixnum);
        }

        // y-Achsen-Markierungen
        for (i = 10; i <= height / 2; i = i + 10) {
            dbgraphics.drawLine(width / 2 + pixnum, height / 2 - i, width / 2 - pixnum, height / 2 - i);
            dbgraphics.drawLine(width / 2 + pixnum, height / 2 + i, width / 2 - pixnum, height / 2 + i);
        }

        // Hintergrundbild im Anzeigefenster zeigen
        g.drawImage(dbimage, 0, 0, this);
    }

    /**
     * Punkt anzeigen
     *
     * @param p der anzuzeigende Punkt
     */
    public void show(Punkt p) {
        if (p != null) {
            punkte.insertElementAt(p, 0);
            repaint();
        }
    }

    /**
     * Rechteck anzeigen
     *
     * @param r das anzuzeigende Rechteck
     */
    public void show(Rechteck r) {
        if (r != null) {
            rechtecke.insertElementAt(r, 0);
            repaint();
        }
    }

    /**
     * Punkt verbergen
     *
     * @param p der zu verbergende Punkt
     */
    public void hide(Punkt p) {
        if (p != null) {
            punkte.removeElement(p);
            repaint();
        }
    }

    /**
     * Rechteck verbergen
     *
     * @param r das zu verbergende Rechteck
     */
    public void hide(Rechteck r) {
        if (r != null) {
            rechtecke.removeElement(r);
            repaint();
        }
    }
}
