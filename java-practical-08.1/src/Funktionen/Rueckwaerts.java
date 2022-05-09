package Funktionen;

public class Rueckwaerts 
{
	public static void main(String[] args) {
		for (int i = args.length - 1; i >= 0; i--) 
		{
			System.out.print(umdrehen(args[i]) + " ");												
		}
		
		System.out.println("streawkceuR avaj");

	}
	
	private static String umdrehen(String eingabe) {
		String rueckwaerts = "";
		for (int zeichenkette = eingabe.length() - 1; zeichenkette >= 0; zeichenkette--) 
		{
			rueckwaerts = rueckwaerts + eingabe.charAt(zeichenkette);
		}
		return rueckwaerts;
	}

}