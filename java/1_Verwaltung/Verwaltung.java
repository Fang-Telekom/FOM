/**
 * 
 */

import java.io.IOException;

import interaction.Interaction;

/**
 * @author cupido
 *
 */
public class Verwaltung {
	/**
	 * @param args
	 */
	public Verwaltung() {
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Interaction interact = new Interaction();
		
		try {
			interact.start();
			/*while() {
			}*/
		} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}
	
}