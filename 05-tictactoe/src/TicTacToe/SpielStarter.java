package tictactoe;

/**
 * Die Klasse dient zum Start des Spiels TicTacToe.
 * 
 * @author Dirk Pawlaszczyk
 * @version 1.0
 */
public class SpielStarter {

	/**
	 * In diesem Attribut wird abgelegt, ob das Spiel bereits
	 * beendet ist bzw. ob weiter gespielt werden soll.
	 */
	private boolean gameOver;

	/**
	 * Zum Spielen wird ein Objekt der Klasse TicTacToe benoetigt.
	 */
	private TicTacToe spielplan = new TicTacToe();

	/**
	 * Standard-Konstruktor der Klasse SpielStarter.
	 */
	SpielStarter() {
		gameOver = false;
	}

	/**
	 * Eigentliche Start-Methode des Spiels. Wird von
	 * <code>main</code> aufgerufen.
	 */
	public void start() {

		/* Auessere Schleife */
		do {
			System.out.println("Willkommen! Sie moechten gern eine Runde Tic-Tac-Toe spielen ?");
			System.out.println("Dann geht es jetzt los!");
			System.out.println();
			System.out.println("Ihr Zeichen lautet " + "X" + ". Das Zeichen des Computers lautet " + "O" + ".");
			System.out.println();
			spielplan.initialisiereSpielfeld();
			spielplan.ausgeben();

			/* innere Schleife */
			while (!gameOver) { // solange das Spiel nicht beendet ist

				spielplan.zugSpieler();
				if (spielplan.istGameOver()) {
					spielplan.ausgeben();
					System.out.println("Sie haben gewonnen!!!");
					break;
				}
				spielplan.zugComputer();
				if (spielplan.istGameOver()) {
					spielplan.ausgeben();
					System.out.println("Der Computer hat gewonnen. Schade.");
					break;
				}
			}

			System.out.println("Spiel beendet!");
			System.out.print("Moechten Sie noch einmal spielen (J/N)? ");
			if (Keyboard.readChar() == 'N') {
				gameOver = true;
			}
		} while (!gameOver);
	}

	/**
	 * Hauptprogramm.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		SpielStarter s = new SpielStarter();
		s.start();

	}
}