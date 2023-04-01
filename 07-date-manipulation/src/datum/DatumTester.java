package datum;

class DatumTester {

	public static void main(String[] args) {
		Datum d2 = new Datum(25, 10, 1917);
		Datum d1 = new Datum(11, 9, 1973);

		System.out.println("D1 Tag: " + d1.getTag());
		System.out.println("D1 Monat: " + d1.getMonat());
		System.out.println("D1 Jahr: " + d1.getJahr());
		System.out.println();

		System.out.println("D2: " + d2.toString());
		System.out.println();

		System.out.println("Vergleich D1 mit D2: ");
		if (d1.equals(d2)) {
			System.out.println("D1 ist gleich D2!");
		} else {
			System.out.println("Unterschiedliche Daten!");
		}
		System.out.println();

		System.out.println("Vergleich D1 mit D2 auf dem Zeitstrahl: ");
		if (d2.vor(d1))
			System.out.println("D2 war vor D1!");
		System.out.println();
		System.out.println("Vergleich D2 mit D1 auf dem Zeitstrahl: ");
		if (Datum.vor(d2, d1))
			System.out.println("D2 war vor D1!");
		System.out.println();

		System.out.println("Pruefen des Datums 42.13.-1892");
		if (!Datum.istDatumGueltig(42, 13, -1892))
			System.out.println("Datum nicht gueltig");

	}

}