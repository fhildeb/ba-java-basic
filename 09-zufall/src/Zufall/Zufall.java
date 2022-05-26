package Zufall;

public class Zufall {
	long value = 0;

	static long a = 3421;
	static long c = 1;
	static long m = 65536;

	public Zufall(long start) {
		value = start;
	}

	public Zufall() {
		value = System.currentTimeMillis();
	}

	public double zufallsDouble() {
		value = (value * a + c) % m;

		return (double) value / (double) m;
	}

	public double zufallsDouble(double max) {
		return zufallsDouble() * max;
	}

	public int zufallsInt(int max) {
		return (int) (zufallsDouble() * max);
	}

	public String toString() {
		return "";
	}

}
