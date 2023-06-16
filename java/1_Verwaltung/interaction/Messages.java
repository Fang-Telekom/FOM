package interaction;

import javax.swing.JDialog;
import javax.swing.JFrame;

public class Messages {
	private JDialog dialog;
	public Messages() {
		// TODO Auto-generated constructor stub
	}
	
	public void Message(String message, JFrame frame) {
		dialog = new JDialog(frame, message, true);
		dialog.setSize(300, 400);
		dialog.setLayout(null);
		dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		dialog.setResizable(false);
		dialog.setLocationRelativeTo(null);
		dialog.setVisible(true);
	}
	
	

}
