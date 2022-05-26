package funktionen;

class Fibonacci {

	// static noetig, weil wir nur statische methoden haben
	static long[] fib = new long[20];

	public static void main(String[] args) {
		for (int i = 0; i < 20; i++) {
			fib[i] = fibonacci(i);
			System.out.println(fib[i]);
		}

	}

	private static long fibonacci(int n) {
		if (n == 1 || n == 2)
			return 1L;
		else if (n >= 3) {
			return fib[n - 1] + fib[n - 2];
		}
		return 0L; // sollte nie passieren
	}

	// bei n > 90 erhalten wir negative Zahlen
	// dieses Problem nennt sich "Integer Overflow"
	// ein int (oder bei uns eben long) wird als binaere Zahl gespeichert
	// Das allererste Bit ist das VORZEICHEN
	// Bei 90+ findet ein Ueberlauf statt und das Vorzeichen wird als Zahl
	// ueberschrieben

}
