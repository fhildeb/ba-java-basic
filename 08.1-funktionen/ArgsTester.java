package Funktionen;

class ArgsTester {
	public static void main(String[] args) {
		if (args.length <= 0)
			System.out.println("keine Parameter vorhanden");
		else {

			for (int i = 0; i < args.length; i++) {
				System.out.println(args[i]);
			}

		}

	}
}