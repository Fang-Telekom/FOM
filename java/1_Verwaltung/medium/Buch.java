package medium;

import java.io.Serializable;

public class Buch extends Medium implements Serializable{

	//private static int sammlung = 0;
	private final String category;
	
	public Buch(String category, String sub, String titel, String untertitel, String autor, float preis, int bestand) {
		this(category, sub, titel, autor, preis, bestand);
		super.setUntertitel(untertitel);
	}
	
	public Buch(String category, String sub, String titel, String autor, float preis, int bestand){
		super(category, sub, titel, autor, preis, bestand);
		this.category = category;
//		sammlung++;
		
	}

	public String getCategory() {
		return category;
	}

	/*public static int getSammlung() {
		return sammlung;
	}*/
	
}
