package persons;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public abstract class Persons implements Serializable{
	
	private Person [] persons = new Person[0];
	private Save save;
	
	public Persons(String path, String file) {
		try {
			save = new Save(path, file);
			save.load(this);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public Person get(int index) {
		if(index >= 0 && index < persons.length)
			return persons[index];
		return null;
	}
	public Person[] get() {
		return persons;
	}
	public void set(Person[] persons) {
		this.persons = persons;
	}
	public void set(int index, Person person) {
		this.persons[index] = person;
	}
	public void add(String vorname, String nachname, String adresse, String date, int age, float credit, String comment) {
		try {
			add(new Person(vorname, nachname, adresse, date, age, credit, comment));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private void add(Person newP) throws IOException {
		if(persons != null){
			Person temp[] = new Persons.Person [persons.length + 1];
			for(int i = 0; i < persons.length; i++)
				temp[i] = persons[i];
			temp[persons.length] = newP;
			persons = temp;
		}
		else{
			persons = new Persons.Person [1];
			persons[0] =newP;
		}
		save.save(this);
	}
	public void remove(int index) {
		if(index >= 0 && index < persons.length)
			return;
		else if (persons.length <= 1)
			persons = (Person[]) new Object[0];;
		Person[] temp = new Person[persons.length - 1];
		for(int i = 0; i < index; i++)
			temp[i] = persons[i];
		for(int i = index; i < temp.length; i++)
			temp[i] = persons[i - 1];
		persons = temp;
	}
	
	public abstract String viewInfo();
	public abstract String editInfo();
	
	class Save implements Serializable{
		private final String file, path;
		public Save(String path, String file) throws IOException {
			this.file = file;
			this.path = path;
			
			File source = new File (path+file);
			if(!source.exists()) {
				if(!path.equals("") && path != null)
					source.getParentFile().mkdir();
				source.createNewFile();
			}
		}
		public void load(Persons persons) {		
			ObjectInputStream ois = null;
			try {
				ois = new ObjectInputStream(new FileInputStream(path + file));	
				do {
					Person person = (Person) ois.readObject();
					persons.add(person);
				}while(true);
			} catch (Exception e) {
				try {
					ois.close();
				}catch(Exception ex) {}
			}
			
		}
		public void save(Persons person) throws IOException {
			
			ObjectOutputStream ops = new ObjectOutputStream(new FileOutputStream(path + file));
			
			for(int i = 0; i < person.get().length; i++)
				ops.writeObject(person.get(i));
			ops.close();
		}
	}
	
	public class Person implements Comparable<Person>, Serializable{
		private String vorname, nachname, adresse, date;
		private int age;
		
		private float credit;
		private String comment;
	
		private final int id;
		private static int persons = 0; 
	
		public Person(String vorname, String nachname, String adresse, String date, int age, float credit, String comment) {
			this.vorname = vorname;
			this.nachname = nachname;
			this.adresse = adresse;
			this.date = date;
			this.age = age;
			this.credit = credit;
			this.comment = comment;
		
			id = persons++;
		}
	
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

		public float getCredit() {
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

