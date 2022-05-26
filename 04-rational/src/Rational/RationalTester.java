package Rational;

public class RationalTester {
	public static void main(String[] args) {
		// Erstellen von Rationalen Zahlen
		Rational r1 = new Rational(8, 2);
		Rational r2 = new Rational(8, 2);
		Rational r3 = new Rational(4, 3);
		Rational r4 = new Rational();

		// Angeben der Rationalen Zahl in Dezimalschreibweise
		System.out.println("R1 in Dezimalschreibweise: " + r1.doubleValue());

		// Rationale Zahl im String ausgeben
		System.out.println("R1 im String-Format: " + r1.toString());
		System.out.println();

		// Addition
		System.out.println("R2 plus R3 = " + r2.plus(r3));

		// Subtraktion
		System.out.println("R2 minus R3 = " + r2.minus(r3));

		// Multiplikation
		System.out.println("R2 mal R3 = " + r2.mal(r3));

		// Division
		System.out.println("R2 durch R3 = " + r2.durch(r3));
		System.out.println();

		// Vergleich r1 mit r2
		System.out.println("Vergleich R1 mit R2:");
		if (r1.equals(r2)) {
			System.out.println("R1 gleich R2");
		} else {
			System.out.println("R1 ungleich R2");
		}
		System.out.println();

		// Bruch kuerzen lassen
		System.out.println("R1 gekuerzt: " + r1.gekuerzterBruch());
		System.out.println();

		// Rechenoperationen mit Klassenmethoden
		System.out.println("R2 plus R3 = " + Rational.plus(r2, r3));
		System.out.println("R2 minus R3 = " + Rational.minus(r2, r3));
		System.out.println("R2 mal R3 = " + Rational.mal(r2, r3));
		System.out.println("R2 durch R3 = " + Rational.durch(r2, r3));

		// Vergleich ob R4 null ist
		System.out.println("Vergleich von R4 auf den Wert Null und Eins: ");
		if (r4.equals(Rational.NULL)) {
			System.out.println("R4 ist gleich Null");
		} else if (r4.equals(Rational.EINS)) {
			System.out.println("R4 ist gleich Eins");
		} else {
			System.out.println("R4 ist gleich " + r4.toString());
		}
	}
}
