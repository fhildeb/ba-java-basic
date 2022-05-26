package display;

public class PunktTester {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		// Anlegen neuer Punkte
		Punkt p1 = new Punkt(1, 2);
		Punkt p2 = new Punkt(1, 2);
		Punkt p3 = new Punkt(3, 4);
		Punkt p4 = new Punkt();

		// Ausgabe von Punkten
		System.out.println("Startwert Punkt 1: " + p1.toString() + "X: " + p1.getx() + "| Y: " + p1.gety());
		System.out.println("Startwert Punkt 2: " + p2.toString() + "X: " + p1.getx() + "| Y: " + p1.gety());
		System.out.println("Startwert Punkt 3: " + p3.toString() + "X: " + p1.getx() + "| Y: " + p1.gety());
		System.out.println("Startwert Punkt 4: " + p4.toString() + "X: " + p1.getx() + "| Y: " + p1.gety());
		System.out.println();

		// Versetzen des Punktes
		System.out.println("Versetzen P1 nach (5|6):");
		p1.versetzen(5, 6);
		System.out.println("Wert Punkt 1: " + p1.toString());
		System.out.println();

		// Verschieben des Punktes
		System.out.println("Verschieben P1 mit (-4|-4):");
		p1.verschieben(-4, -4);
		System.out.println("Wert Punkt 1: " + p1.toString());
		System.out.println();

		// Vergleichen
		System.out.println("Vergleichen P1 mit P2:");
		if (p1.equals(p2)) {
			System.out.println("Beide Punkte sind identisch");
		} else {
			System.out.println("Die Punkte sind unterschiedlich");
		}
		System.out.println();

		/**
		 * Zusatz
		 */

		// Ein- und Ausgabe eines neuen Punktes
		System.out.println("Geben sie bitte einen X-Wert fuer P5 an: ");
		double x5 = new java.util.Scanner(System.in).nextDouble();
		System.out.println("Geben sie bitte einen Y-Wert fuer P5 an: ");
		double y5 = new java.util.Scanner(System.in).nextDouble();
		System.out.println();

		Punkt p5 = new Punkt(x5, y5);
		System.out.println("Wert Punkt 1: " + p5.toString());
		System.out.println();

		// Punkt P5 spiegeln
		System.out.println("Spiegeln Punkt p5");
		p5.spiegeln();
		System.out.println("Wert Punkt 5: " + p5.toString());
		System.out.println();

		// Abstand P4 zum Ursprung
		System.out.println("Abstand P3 zum Koordinatenursprung");
		System.out.println(p3.abstandUrsprung());
		System.out.println();

		// Winkel P4 zur X-Achse
		System.out.println("Winkel P3 zur X-Achse");
		System.out.println(p3.winkelXAchse());
		System.out.println();

		// Aufrufen einer GUI-Oberflaeche und Anzeigen aller angelegter Punkte
		System.out.println("Zum anzeigen der GUI bestaetige mit y");
		String gui = new java.util.Scanner(System.in).nextLine();
		String guiActive = "y";
		if (gui.equals(guiActive)) {
			Display d1 = new Display(400, 500);
			d1.show(p1);
			d1.show(p2);
			d1.show(p3);
			d1.show(p4);
			d1.show(p5);
		} else {
			System.out.println("Vorgang abgebrochen");
		}
	}
}
