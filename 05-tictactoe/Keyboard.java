package TicTacToe;

import java.util.Scanner;




/**
 * Einfache Klasse zur Tastatur-Eingabe von Zeichen und Zahlen. 
 * 
 */

public class Keyboard {


	private static Scanner input = new Scanner(System.in);
	
  
	/**
 	 *  Liest ein Zeichen von der Standard-Eingabe.
	 */
	public static char readChar(){

		return input.next().charAt(0);

	}
	
	/**
	 *  Liest die naechste Ganzzahl von der Standard-Eingabe und
         *  gibt dieses zurueck.
	 */
	public static int readInt(){
		
		return Integer.valueOf(input.nextInt());
	}
	
}
