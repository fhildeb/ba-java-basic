package Rechteck;

public class Punkt {
	// Deklarieren der Variablen
	private double x;
	private double y;

	// Klassen-Konstruktor mit Parametern
	public Punkt(double xWert, double yWert) {
		this.x = xWert;
		this.y = yWert;
	}

	// Klassen-Konstruktor ohne Parameter
	public Punkt() {
		this.x = 0;
		this.y = 0;
	}

	// Auslesefunktion X-Wert
	public double getx() {
		return this.x;
	}

	// Auslesefunktion Y-Wert
	public double gety() {
		return this.y;
	}

	// Funktion zum Versetzen eines Punktes
	public void versetzen(double xNeu, double yNeu) {
		this.x = xNeu;
		this.y = yNeu;
	}

	// Funktion zum Verschieben eines Punktes
	public void verschieben(double dx, double dy) {
		this.x = this.x + dx;
		this.y = this.y + dy;
	}

	// Ausgabe des Objektes
	public String toString() {
		return "(" + this.x + "|" + this.y + ")";
	}

	// Vergleich zweier Objekte
	public boolean equals(Punkt p) {
		return ((this.getx() == p.getx()) && (this.gety() == p.gety()));
	}

	/**
	 * Zusatz
	 */

	// Spiegeln eines Punktes
	public void spiegeln() {
		this.x = -(this.x);
		this.y = -(this.y);
	}

	// Abstand zum Koordinatenursprung berechnen
	public double abstandUrsprung() {
		return Math.sqrt(((this.x) * (this.x)) + ((this.y) * (this.y)));
	}

	// Winkel zur X-Achse berechnen
	public String winkelXAchse() {
		// Cosinus berechnen
		double cos = ((this.x) / (this.abstandUrsprung()));
		// Radians berechnen
		double acos = Math.acos(cos);
		// Grad berechnen und ausgeben
		return Math.toDegrees(acos) + " Grad";
	}

}
