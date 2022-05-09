package Funktionen;

class WuerfelTest
{
	public static void main(String[] args)
	{
		int wuerfelVersuche = 500;
		int[] ergebnisse = new int[ wuerfelVersuche ];
		int[] haeufigkeit = new int[6];
		int sum = 0;
		double avg = 0.0;
		double varianz = 0.0;
		double standardAbweichung = 0.0;

		for( int i = 0; i < wuerfelVersuche; i++ )
		{
			ergebnisse[i] = (int)(Math.random()*6+1);

			haeufigkeit[ ergebnisse[i]-1 ]++;	//Haeufigkeit der gewürfelten Zahl hochzählen.

			sum += ergebnisse[i];
		}
		System.out.println();
		
		//nach double casten um sicherzustellen, dass er keine Ganzzahlige Division durchführt
		avg = (double)sum/(double)wuerfelVersuche;

		System.out.println("Summe: " + sum);
		System.out.println("Durchschnitt: " + avg);
		
		System.out.println();
		for( int i = 0; i < 6; i++ )
		{
			System.out.println("Haeufigkeit von " + (i+1) + ": " + haeufigkeit[i] );
			System.out.println("rel. Haeufigkeit: " + ((double)haeufigkeit[i]/(double)wuerfelVersuche) );
			System.out.println();
		}
		System.out.println();

		long varsum = 0;
		for(int i = 0; i < wuerfelVersuche; i++)
		{
			varsum += Math.pow(ergebnisse[i] - avg, 2);	//pow(x,y) == x^y
		}

		varianz = 1.0/(double)(wuerfelVersuche-1)*varsum;
		standardAbweichung = Math.sqrt( varianz );

		System.out.println("Varianz: " + varianz);
		System.out.println("Standardabweichung: " + standardAbweichung);

	}

	//Wissenschaftliche Ergebnisse:
	//Durchschnitt wird sich bei ~3.5 einpendeln
	//rel. Haeufigkeit bei etwa 1/6

}
