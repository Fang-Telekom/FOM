package persons;

import persons.Persons.Person;

public class Guest extends Persons<Guest.GuestID>{
	
	
	public Guest() {
		this.persons = new GuestID[3];
	}
	
	class GuestID extends Person{

		public GuestID(String vorname, String nachname, String adresse, int age) {
			super(vorname, nachname, adresse, age);
			// TODO Auto-generated constructor stub
		}

		@Override
		public String viewInfo() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public String editInfo() {
			// TODO Auto-generated method stub
			return null;
		}
		
	}
	
	
}