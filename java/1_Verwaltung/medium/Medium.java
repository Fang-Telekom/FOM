package medium;

import java.io.Serializable;

import persons.Guest;

public class Medium implements Serializable{
	private String titel, untertitel, autor;
	private int bestand = 0;
	private float preis;
//	private static int sammlung = 0;
	private String kennung;
	private final String category, sub;
	
	private Guest ausleiher = null;
	
	public Medium(String category, String sub, String titel, String autor, float preis, int bestand){
		this.titel = titel;
		this.autor = autor;
		this.preis = preis;
		this.bestand = bestand;
		this.category = category;
		this.sub = sub;
		
		kennung = this.category + "_" + this.sub;
//		sammlung++;
	}
	public Medium(String category, String sub, String titel, String untertitel, String autor, float preis, int bestand){
		this(category, sub, titel, autor, preis, bestand);
		this.untertitel = untertitel;
	}
	
	public void setAusleiher(Guest ausleiher) throws Exception {
		if(ausleiher != null)
			throw new Exception("Es gibt bereits ein Ausleiher");
		this.ausleiher = ausleiher;
	}
	public boolean isAvailable() {
		if(ausleiher != null)
			return false;
		return true;
	}
	public void returned() throws Exception {
		if(ausleiher == null)
			throw new Exception("Es gibt kein Ausleiher");
		this.ausleiher = null;
	}
	
	public void setTitel(String titel){
		this.titel = titel;
	}
	public String getTitel(){
		return titel;
	}
	public void setUntertitel(String untertitel){
		this.untertitel = untertitel;
	}
	public String getUntertitel(){
		return untertitel;
	}
	public void setKennung(String kennung){
		this.kennung = kennung;
	}
	public String getKennung(){
		return kennung;
	}
	public void setAutor(String autor){
		this.autor = autor;
	}
	public String getAutor(){
		return autor;
	}
	public int getBestand(){
		return bestand;
	}
	public float getPreis() {
		return preis;
	}
	public void setPreis(int preis) {
		this.preis = preis;
	}
/*	public static int getSammlung() {
		return sammlung;
	}*/
	public String getCategory() {
		return category;
	}
	public String getSub() {
		return sub;
	}
	
}
