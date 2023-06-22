package persons;

public abstract class Persons <P extends Persons.Person>{
	
	P [] persons;
	public Persons() {
		
	}
	public P get(int index) {
		if(index >= 0 && index < persons.length)
			return persons[index];
		return null;
	}
	public void add(P newP) {
		if(persons != null){
			P temp[] = (P[])(new Object [persons.length + 1]);
			for(int i = 0; i < persons.length; i++)
				temp[i] = persons[i];
			temp[persons.length] = newP;
			persons = temp;
		}
		else{
			persons = (P[]) new Object [1];
			persons[0] =newP;
		}
	}
	public void remove(int index) {
		//TODO
	}
	
	public abstract class Person implements Comparable<Person>{
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
	/*@Override
	public int compareTo(GuestID guest) {
		return guest.getAge() > this.getAge() ? 1 : guest.getAge() < this.getAge() ? -1 : 0;
	}*/
	@Override
		public int compareTo(Person guest) {
		
			int length, l = 0;
			if(guest.getNachname().length() > this.getNachname().length()) {
				length = guest.getNachname().length();
				l = 1;
			}
			else if (guest.getNachname().length() == this.getNachname().length())
				length = this.getNachname().length();
			else {
				length = this.getNachname().length();
				l = -1;
			}
		
			for(int i = 0; i < length; i++) {
				if(guest.getNachname().charAt(i) > this.getNachname().charAt(i))
					return 1;
				else if(guest.getNachname().charAt(i) < this.getNachname().charAt(i))
					return -1;
			}
			return l;
		}


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
	

}
