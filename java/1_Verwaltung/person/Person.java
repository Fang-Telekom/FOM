package person;

public abstract class Person {

	private String vorname, nachname, adresse, date;
	private int age;
	
	private int credit;
	private String comment;
	
	private final int id;
	private static int persons = 0; 
	
	public Person(String vorname, String nachname, String adresse, int age) {
		this.vorname = vorname;
		this.nachname = nachname;
		this.adresse = adresse;
		this.age = age;
		
		id = persons++;
	}
	
	public abstract String viewInfo();
	public abstract String editInfo();

	public String getVorname() {
		return vorname;
	}

	public void setVorname(String vorname) {
		this.vorname = vorname;
	}

	public String getNachname() {
		return nachname;
	}

	public void setNachname(String nachname) {
		this.nachname = nachname;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getCredit() {
		return credit;
	}

	public void setCredit(int credit) {
		this.credit = credit;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public static int getPersons() {
		return persons;
	}

	public static void setPersons(int persons) {
		Person.persons = persons;
	}

	public int getId() {
		return id;
	}
	
	
	

}
