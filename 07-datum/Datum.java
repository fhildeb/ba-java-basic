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

	/**
	 * ZUSATZ
	 */

	public int tagnummerImJahr() {
		int result = tag; // starte mit aktuellem tag.
		int temp_monat = monat - 1; // der wievielte Tag im jetzigen Monat das ist, wissen wir schon von oben!
		// temp monat <= 0 heisst wir sind im Dez. letzten Jahres, also nicht mehr
		// zaehlen
		while (temp_monat > 0) {
			result += anzahlTageImMonat(temp_monat, jahr); // addiere Anzahl Tage im Monat
			temp_monat--;
		}

		return result;
	}

	public int anzahlTageBis(Datum d) {
		int result = d.tagnummerImJahr() - this.tagnummerImJahr(); // wie viele tage zwischen den Daten liegen, waeren
																	// sie im selben Jahr
		int jahre = d.jahr - this.jahr; // wie viele jahre liegen dazwischen?

		// d liegt in der Zukunft
		while (jahre > 0) {
			result += 365;

			// wenn das Jahr, das wir gerade zaehlen ein Schaltjahr ist, brauchen wir einen
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
}