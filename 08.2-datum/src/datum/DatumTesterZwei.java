package datum;

public class DatumTesterZwei {

	public static void main(String[] args) {

		int[] datum = { 1, 8, 1914 };
		Datum d1 = new Datum(datum);
		Datum d2 = new Datum("22.06.1941");

		Datum d3 = Datum.parseDatum("02.05.1945");

		System.out.println("Datum D4 eingeben: ");
		Datum d4 = Datum.readDatum();
		System.out.println();

		System.out.println("D1: " + d1.toString3());
		System.out.println("D2: " + d2.toString3());
		System.out.println("D3: " + d3.toString3());
		System.out.println("D4: " + d4.toString3());
		System.out.println();

		System.out.println("D1 ist der wievielte Tag diesem Jahr?");
		System.out.println(d1.tagnummerImJahr());
		System.out.println();

		System.out.println("Anzahl der Tage zwischen D1 und D3: ");
		System.out.println(d2.anzahlTageBis(d3));

	}

}
