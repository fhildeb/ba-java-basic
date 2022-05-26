package rechteck;

public class Rechteck {
	// Deklarieren der Variablen
	private Punkt startpunkt;
	private double hoehe;
	private double breite;

	// Konstrucktor ohne Parameter
	public Rechteck() {
		this.startpunkt = new Punkt(0, 0);
		this.hoehe = 0;
		this.breite = 0;
	}

	// Konstruktor mit 3 Parametern
	public Rechteck(Punkt start, double h, double b) {
		this.startpunkt = start;
		this.hoehe = h;
		this.breite = b;
	}

	// Konstruktor mit 4 Parametern
	public Rechteck(double xstart, double ystart, double h, double b) {
		this.startpunkt = new Punkt(xstart, ystart);
		this.hoehe = h;
		this.breite = b;
	}

	// Ausgabe Wert Startpunkt
	public Punkt getStartpunkt() {
		return this.startpunkt;
	}

	// Ausgabe Wert Hoehe
	public double getHoehe() {
		return this.hoehe;
	}

	// Ausgabe Wert Breite
	public double getBreite() {
		return this.breite;
	}

	// Rechteck Flaeche berechnen
	public double berechneFlaeche() {
		return (this.breite * this.hoehe);
	}

	// Rechteck Umfang berechnen
	public double berechneUmfang() {
		return (2 * (this.breite + this.hoehe));
	}

	// Rechteck versetzen
	public void versetzen(double xNeu, double yNeu) {
		this.startpunkt.versetzen(xNeu, yNeu);
	}

	// Rechteck verschieben
	public void verschieben(double dx, double dy) {
		this.startpunkt.verschieben(dx, dy);
	}

	// String Ausgabe
	public String toString() {
		return "Startpunkt: " + this.startpunkt.toString() +
				", Hoehe: " + this.getHoehe() +
				", Breite: " + this.getBreite();
	}

	// Vergleich Rechteck
	public boolean equals(Rechteck r) {
		return ((this.startpunkt.equals(r.startpunkt)) &&
				(this.hoehe == r.hoehe) &&
				(this.breite == r.breite));
	}

	/*
	 * / Zusatz
	 */

	// Eckpunkte des Rechtecks berechnen und ausgeben
	public String eckpunkte() {
		Punkt alphaA = new Punkt((this.startpunkt.getx()), (this.startpunkt.gety()));
		Punkt betaA = new Punkt((this.startpunkt.getx()), (this.startpunkt.gety() + this.breite));
		Punkt gammaA = new Punkt((this.startpunkt.getx() + this.hoehe), (this.startpunkt.gety() + this.breite));
		Punkt deltaA = new Punkt((this.startpunkt.getx() + this.hoehe), (this.startpunkt.gety()));

		return "Alpha: " + alphaA.toString() +
				", Beta: " + betaA.toString() +
				", Gamma: " + gammaA.toString() +
				", Delta: " + deltaA.toString();
	}

	// Rechteck spiegeln
	public void spiegeln() {
		this.startpunkt.spiegeln();
		startpunkt.versetzen((this.startpunkt.getx() - this.breite), (this.startpunkt.gety() - this.hoehe));
	}

	// Auf gemeinsame Punkte vergleichen
	public boolean[] gemeinsamePunkte(Rechteck r) {
		// Referenzpunkte anlegen
		Punkt alphaB = new Punkt((r.getStartpunkt().getx()), (r.getStartpunkt().gety()));
		Punkt betaB = new Punkt((r.getStartpunkt().getx()), (r.getStartpunkt().gety() + r.breite));
		Punkt gammaB = new Punkt((r.getStartpunkt().getx() + r.hoehe), (r.getStartpunkt().gety() + r.breite));
		Punkt deltaB = new Punkt((r.getStartpunkt().getx()) + r.hoehe, (r.getStartpunkt().gety()));

		Punkt alphaA = new Punkt((this.startpunkt.getx()), (this.startpunkt.gety()));
		Punkt betaA = new Punkt((this.startpunkt.getx()), (this.startpunkt.gety() + this.breite));
		Punkt gammaA = new Punkt((this.startpunkt.getx() + this.hoehe), (this.startpunkt.gety() + this.breite));
		Punkt deltaA = new Punkt((this.startpunkt.getx() + this.hoehe), (this.startpunkt.gety()));

		// Punkte der Rechtecke vergleichen
		boolean alphaGleich = alphaA.equals(alphaB);
		boolean betaGleich = betaA.equals(betaB);
		boolean gammaGleich = gammaA.equals(gammaB);
		boolean deltaGleich = deltaA.equals(deltaB);

		return new boolean[] { alphaGleich, betaGleich, gammaGleich, deltaGleich };

	}

}
