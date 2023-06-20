package person;

public class Guest{
	
	GuestID[] guest;
	
	public Guest() {
		
	}
	
	public GuestID get(int index) {
		if(index >= 0 && index < guest.length)
			return guest[index];
		return null;
	}
	public void add(Guest guest) {
		
	}
	public void remove(int index) {
		
	}
	
}
class GuestID extends Person implements Comparable<GuestID>{
		
	private final int id;
	private static int persons = 0;
	Person person;
		
	public GuestID(String vorname, String nachname, String adresse, int age) {
		super(vorname, nachname, adresse, age);
		this.id = persons++;
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

	/*@Override
	public int compareTo(GuestID guest) {
		return guest.getAge() > this.getAge() ? 1 : guest.getAge() < this.getAge() ? -1 : 0;
	}*/
	@Override
	public int compareTo(GuestID guest) {
		
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

}