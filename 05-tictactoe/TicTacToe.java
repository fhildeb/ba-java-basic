package TicTacToe;

public class TicTacToe
{
	//Deklarieren von Variablen
	@SuppressWarnings("unused")
	private int spielzuege = 0;
	private char[] feld = new char[9];
	private char LEER = '-';
	
	//Felder zu Beginn auf Null setzen
	public TicTacToe()
	{
		spielzuege = 0;
		for(int i = 0; i < 9; i++)
		{
			feld[i] = LEER;
		}
	}
	
	//Feld auswaehlen
	public void setFeld(int nummer, char zeichen)
	{
		feld[nummer] = zeichen;
	}
	
	//Pruefung ob Feld LEER ist
	public boolean istFrei(int nummer)
	{
		return feld[nummer] == LEER;
	}
	
	//Spielfeld malen
	public void ausgeben()
	{
		System.out.println( "[" + feld[0] + "] [" + feld[1] + "] [" + feld[2] + "]" );
		System.out.println( "[" + feld[3] + "] [" + feld[4] + "] [" + feld[5] + "]" );
		System.out.println( "[" + feld[6] + "] [" + feld[7] + "] [" + feld[8] + "]" );
	}
	
	 public void initialisiereSpielfeld()
    {
		spielzuege = 0;
		for(int i = 0; i < 9; i++)
        {
            feld[i] = LEER;
        }
    }

	//Überprüfung aller Möglichkeiten für GameOver
	public boolean istGameOver()
	{
		//Reihe 1
		if(feld[0]!=LEER && feld[0]==feld[1] && feld[1]==feld[2]) return true;

		//Reihe 2
		if(feld[3]!=LEER && feld[3]==feld[4] && feld[4]==feld[5]) return true;

		//Reihe 3
		if(feld[6]!=LEER && feld[6]==feld[7] && feld[7]==feld[8]) return true;

		//Spalte 1
		if(feld[0]!=LEER && feld[0]==feld[3] && feld[3]==feld[6]) return true;

		//Spalte 1
		if(feld[1]!=LEER && feld[1]==feld[4] && feld[4]==feld[7]) return true;

		//Spalte 1
		if(feld[2]!=LEER && feld[2]==feld[5] && feld[5]==feld[8]) return true;

		//Diagonale 1
		if(feld[0]!=LEER && feld[0]==feld[4] && feld[4]==feld[8]) return true;

		//Diagonale 2
		if(feld[2]!=LEER && feld[2]==feld[4] && feld[4]==feld[6]) return true;


		//ansonsten
		return false;
	}
	
	//Auswahl eines Feldes durch Spieler
	public void zugSpieler()
	{
		int eingabe = -1;
		spielzuege++;
		
		do{
			System.out.print("Waehle ein Feld (1-9): ");
			eingabe = Keyboard.readInt();
		}
		while( !istFrei(eingabe-1) );

		setFeld(eingabe-1, 'X');
		ausgeben();
	}
	
	//Auswahl eines Feldes durch Computer
	public void zugComputer()
	{
		int eingabe = -1;
		spielzuege++;
		
		do 
		{
			//Zufallszahl zwischen 0-8
			eingabe = (int)(Math.random() * 9);
		} 
		while ( !istFrei(eingabe) );

		setFeld(eingabe, 'O');
		int wahlFeld = eingabe+1;
		System.out.println("Computer wählte Feld " + wahlFeld );
		ausgeben();
	}
}