package persons;

import medium.Medium;

public class Guest extends Persons{
	
	private Medium[] med = new Medium[0];
	public Guest() {
		this("verwaltung/", "Guest.txt");
	}
	public Guest(String path, String file) {
		super(path, file);
		
	}
	
	private void ausleihen(Medium med) throws Exception {
		if(med.isAvailable()){
			Medium temp[] = new Medium[this.med.length + 1];
			for(int i = 0; i < this.med.length; i++)
				temp[i] = this.med[i];
			temp[this.med.length] = med;
			this.med = temp;
			med.setAusleiher(this);
		}
	}
	private void rückgabe(Medium med) throws Exception {
		loop : for(int i = 0; i < this.med.length; i++) {
			if(this.med[i] == med) {
				med.returned();
				if(this.med.length >= 1) {
					this.med = new Medium[0];
					break loop;
				}
				Medium tem[] = new Medium[this.med.length - 1];
				for(int s = 0; s < i; s++)
					tem[s] = this.med[s];
				for(int s = i; s < this.med.length; s++)
					tem[s] = this.med[s + 1];
				this.med = tem;
				break loop;
			}
		}
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