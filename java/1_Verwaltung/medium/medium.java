package medium;

protected class medium{
	private String titel, untertitel, autor;
   	private int bestand, kennung, preis;
	private static int sammlung = 0;
	
	public medium(String titel, String autor, int preis){
		this.titel = titel;
		this.autor = autor;
		this.preis = preis;
		
		bestand = ++sammlung;
	}
	public medium(String titel, String untertitel, String autor, int preis){
		this(titel, autor, preis);
		this.untertitel = untertitel;
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
		return untertitel();
	}
	/*
	public void setKennung(int kennung){
		this.kennung = kennung;
	}*/
	public int getKennung(){
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
}
