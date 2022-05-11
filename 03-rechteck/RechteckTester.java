package Rechteck;

public class RechteckTester {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		// Anlegen von Variablen
		Punkt p1 = new Punkt(1, 2);
		Rechteck r1 = new Rechteck(p1, 3, 4);
		Rechteck r2 = new Rechteck(1, 2, 3, 4);
		Rechteck r3 = new Rechteck(5, 6, 7, 8);
		Rechteck r4 = new Rechteck();

		// Anzeigen der Werte der Rechtecke
		System.out.println("Startwerte Rechteck 1: " + r1.toString());
		System.out.println("Startwerte Rechteck 2: " + r2.toString());
		System.out.println("Startwerte Rechteck 3: " + r3.toString());
		System.out.println("Startwerte Rechteck 4: " + r4.toString());
		System.out.println();

		// Rechteck versetzen
		System.out.println("Rechteck 1 versetzen nach (5|6)");
		r1.versetzen(5, 6);
		System.out.println("Werte Rechteck 1: " + r1.toString());
		System.out.println();

		// Rechteck verschieben
		System.out.println("Rechteck 1 verschieben um (-4|-4)");
		r1.verschieben(-4, -4);
		System.out.println("Werte Rechteck 1: " + r1.toString());
		System.out.println();

		// Vergleich Rechteck
		System.out.println("Vergleich Rechteck R1 mit R2:");
		if (r1.equals(r2)) {
			System.out.println("Rechteck R1 gleich R2");
		} else {
			System.out.println("Rechteck R1 ungleich R2");
		}
		System.out.println();

		/*
		 * / Zusatz
		 */

		// Eckpunkte des Rechtecks berechnen und ausgeben
		System.out.println("Eckpunkte Rechteck R1: ");
		System.out.println(r1.eckpunkte());
		System.out.println();

		// Rechteck spiegeln
		System.out.println("Spiegeln Rechteck R3: ");
		r3.spiegeln();
		System.out.println("Werte Rechteck R3: " + r3.toString());
		System.out.println();

		// Rechteckspunkte vergleichen
		System.out.println("Vergleich Rechteck R1 mit R2: ");

		boolean rechteckswerteErgebnis[] = r1.gemeinsamePunkte(r2);

		if (rechteckswerteErgebnis[0] == true) {
			System.out.println("Punkt Alpha gleich");
		}

		else {
			System.out.println("Punkt Alpha ungleich");
		}

		if (rechteckswerteErgebnis[1] == true) {
			System.out.println("Punk Beta gleich");
		}

		else {
			System.out.println("Punkt Beta ungleich");
		}

		if (rechteckswerteErgebnis[2] == true) {
			System.out.println("Punkt Gamma gleich");
		}

		else {
			System.out.println("Punkt Gamma ungleich");
		}

		if (rechteckswerteErgebnis[3] == true) {
			System.out.println("Punkt Delta gleich");
		}

		else {
			System.out.println("Punkt Delta ungleich");
		}

		// Rechtecke mit GUI anzeigen
		System.out.println("Zum anzeigen der GUI bestaetige mit y");
		String gui = new java.util.Scanner(System.in).nextLine();
		String guiActive = "y";
		if (gui.equals(guiActive)) {
			Display d = new Display(400, 500);
			d.show(r1);
			d.show(r2);
			d.show(r3);
			d.show(r4);
		} else {
			System.out.println("Vorgang abgebrochen");
		}
	}
}
