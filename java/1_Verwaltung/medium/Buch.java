package medium;

public class Buch extends Medium{

	private static int sammlung = 0;
	public Buch(String titel, String autor, int preis, int bestand){
		super(titel, autor, preis, bestand);
		sammlung++;
	}
	public Buch(String titel, String untertitel, String autor, int preis, int bestand){
		super(titel, untertitel, autor, preis, bestand);
		sammlung++;
	}


}
