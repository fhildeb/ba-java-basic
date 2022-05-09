package Stapel;

//Importieren der Klasse ArrayList aus dem Paket java.util
import java.util.ArrayList;

public class Stapel
{	
	//Array der Klasse Object
	private ArrayList<Object> stapelobjekte;
	
	//Konstruktor
	public Stapel()
	{
		stapelobjekte = new ArrayList<Object>();
	}
	
	//Hinzufügen eines Elements
	public void push(Object element)
	{
		this.stapelobjekte.add(element);
	}
	
	//Entfernen des letzten Elements
	public Object pop()
	{
		if (this.stapelobjekte.isEmpty())
		{
			return null;
		}
		else
		{
			return this.stapelobjekte.remove(stapelobjekte.size() -1);
		}
	}
	
	//Prüfen auf Leere Menge
	public boolean isEmpty()
	{
		return this.stapelobjekte.isEmpty();
	}
	
	//String-Ausgabe
	public String toString()
	{
		String stringausgabe = "[ ";
		
		for(int i = 0; i < this.stapelobjekte.size(); i++)
		{
			stringausgabe += stapelobjekte.get(i).toString();
			
			if(i+1 < stapelobjekte.size())
			{
				stringausgabe += ", ";
			}
		}
		
		stringausgabe += " ]";
		
		return stringausgabe;
	}
	
	//Prüfen auf Gleichheit
	public boolean equals(String s)
	{
		return this.toString().equals(s.toString());
	}
}