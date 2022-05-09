package Hello_World;

public class Hello_Keyboard
{
	@SuppressWarnings("resource")
	public static void main(String[] args)
	{
		// Ausgabe Zeichenkette und Ein- sowie Ausgabe einer String-Variable
		System.out.println("Eingabe:");
		String eingabe = new java.util.Scanner(System.in).nextLine();
		System.out.println(eingabe);
	}
}