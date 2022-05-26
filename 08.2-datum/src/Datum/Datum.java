package Datum;

class Datum {
	private int tag = 0, monat = 0, jahr = 0;

	public Datum(int tag, int monat, int jahr) {
		if (istDatumGueltig(tag, monat, jahr) == true) {
			this.tag = tag;
			this.monat = monat;
			this.jahr = jahr;
		}
	}

	public int getTag() {
		return this.tag;
	}

	public int getMonat() {
		return this.monat;
	}

	public int getJahr() {
		return this.jahr;
	}

	public String toString() {
		return this.getTag() + "." + this.getMonat() + "." + this.getJahr();
	}

	public boolean equals(Datum d) {
		return ((this.getTag() == d.getTag()) &&
				(this.getMonat() == d.getMonat()) &&
				(this.getJahr() == d.getJahr()));
	}

	public boolean vor(Datum d) {
		if (this.getJahr() < d.getJahr()) {
			return true;
		}

		else if (this.jahr == d.jahr) {
			if (this.monat < d.monat) {
				return true;
			} else if (this.monat == d.monat) {
				if (this.tag < d.tag) {
					return true;
				}
			}
		}

		return false;
	}

	public static boolean vor(Datum d1, Datum d2) {
		if (d1.jahr < d2.jahr) {
			return true;
		}

		else if (d1.jahr == d2.jahr) {
			if (d1.monat < d2.monat) {
				return true;
			} else if (d1.monat == d2.monat) {
				if (d1.tag < d2.tag) {
					return true;
				}
			}
		}

		return false;
	}

	public static boolean istDatumGueltig(int tag, int monat, int jahr) {
		if (jahr < 0) {
			return false;
		}

		if (monat < 1 || monat > 12) {
			return false;
		}

		if (tag < 1 || tag > anzahlTageImMonat(monat, jahr)) {
			return false;
		}

		else {
			return true;
		}
	}

	private static int anzahlTageImMonat(int monat, int jahr) {
		if (monat < 1 || monat > 12) {
			return 0;
		} else if (monat == 2) {
			if (istSchaltjahr(jahr)) {
				return 29; // Februar im Schaltjahr
			}
			return 28; // Februar normalerweise
		} else if (monat < 8) {
			if (monat % 2 == 0) {
				return 30; // April, Juni
			}
			return 31; // Januar, Maerz, Mai, Juli
		} else {
			if (monat % 2 == 0) {
				return 31; // August, Oktober, Dezember
			}
			return 30; // September, November
		}
	}

	private static boolean istSchaltjahr(int jahr) {
		if (jahr % 100 == 0) {
			if (jahr % 400 == 0) {
				return true;
			}
		}

		else if (jahr % 4 == 0) {
			return true;
		}

		return false;
	}

	/* ZUSATZ */

	public int tagnummerImJahr() {
		int result = tag; // starte mit aktuellem tag.
		int temp_monat = monat - 1; // der wievielte Tag im jetzigen Monat das ist, wissen wir schon! ^oben

		while (temp_monat > 0) // temp monat <= 0 heisst wir sind im Dez. letzten Jahres, also nicht mehr
								// zaehlen
		{
			result += anzahlTageImMonat(temp_monat, jahr); // addiere Anzahl Tage im Monat
			temp_monat--;
		}

		return result;
	}

	public int anzahlTageBis(Datum d) {
		int result = d.tagnummerImJahr() - this.tagnummerImJahr(); // wie viele tage zwischen den Daten liegen, waeren
																	// sie im selben Jahr
		int jahre = d.jahr - this.jahr; // wie viele jahre liegen dazwischen?

		while (jahre > 0) // d liegt in der Zukunft
		{
			result += 365;

			// wenn das Jahr, das wir gerade zaehlen ein schaltjahr ist, brauchen wir einen
			// extra tag
			if (istSchaltjahr(d.jahr - jahre)) {
				result += 1;
			}

			jahre--;
		}

		while (jahre < 0) // d liegt in der Vergangenheit
		{
			result -= 365;

			if (istSchaltjahr(d.jahr + jahre))

				jahre++;
		}

		return result;
	}

	/* Praktikum 8a */

	public Datum(int[] datumszahlen) {
		this.tag = datumszahlen[0];
		this.monat = datumszahlen[1];
		this.jahr = datumszahlen[2];
	}

	public Datum(String s) {
		this(zerlegeString(s));
	}

	public static int[] zerlegeString(String s) {

		String[] tokens = new String[3]; // wir brauchen nur 3 Strings "tt", "mm", "jjjj"
		tokens[0] = s.substring(0, s.indexOf(".")); // vom ersten zeichen bis zum ersten punkt (exklusive punkt)
		tokens[1] = s.substring(s.indexOf(".") + 1, s.lastIndexOf(".")); // vom ersten bis letzten Punkt
		tokens[2] = s.substring(s.lastIndexOf(".") + 1); // vom letzten Punkt bis ende

		int[] datum = new int[3];
		datum[0] = Integer.parseInt(tokens[0]);
		datum[1] = Integer.parseInt(tokens[1]);
		datum[2] = Integer.parseInt(tokens[2]);

		return datum;
	}

	public static Datum parseDatum(String s) {
		int[] datum = zerlegeString(s);
		return new Datum(datum);
	}

	public static Datum readDatum() {
		String s = Keyboard.readString();
		return parseDatum(s);
	}

	// Variable
	static final String[] monatsnamen = {
			"Januar", "Februar", "Maerz", "April", "Mai", "Juni", "Juli",
			"August", "September", "Oktober", "November", "Dezember"
	};

	public String toString2() {
		return this.tag + ". " + monatsnamen[this.monat - 1] + " " + this.jahr;
	}

	/* ZUSATZ! */

	static final String[] wochentagsnamen = {
			"Sonntag", "Montag", "Dienstag", "Mittwoch", "Donnerstag", "Freitag", "Samstag"
	};

	public int wochentagNr() {
		int m = (monat + 9) % 12 + 1;
		int y = jahr % 1000;
		int c = (jahr - y) / 100;

		if (monat == 1 || monat == 2) {
			y = (y + 99) % 100;
			c = (jahr - y - 1) / 100;
		}

		return (((int) (tag + (2.6 * m - 0.2) + y + (y / 4) + (c / 4)) - 2 * c) % 7);
	}

	public String toString3() {
		return wochentagsnamen[wochentagNr()] + ", der " + tag + ". " + monatsnamen[monat - 1] + " " + jahr;
	}

}