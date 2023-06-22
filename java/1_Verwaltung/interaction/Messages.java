package interaction;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JWindow;

public class Messages {
	private JDialog dialog;
	public Messages() {
		// TODO Auto-generated constructor stub
	}
	
	public void Message(String message, JFrame frame) {
		dialog = new JDialog(frame, "Error", true);
		dialog.setLayout(new FlowLayout());
		dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		dialog.setResizable(false);
		JLabel label = new JLabel(message);
		dialog.add(label);
		dialog.pack();
		dialog.setLocationRelativeTo(null);
		
		dialog.setVisible(true);
	}
	public void toast(String message, JFrame frame) {
		JWindow toast = new JWindow();
		toast.setLayout(new FlowLayout());
		
		JLabel label = new JLabel(message);
		toast.add(label);
		toast.pack();
		toast.setLocation(frame.getX() + frame.getWidth() - toast.getWidth(), frame.getY());
		toast.setAlwaysOnTop(true);
		
		toast.setVisible(true);
		
		try {
			Thread.sleep(2000);
			for(float i = 0; i < 0.9; i+=0.1) {
				Thread.sleep(100);
				toast.setOpacity(1 - i);;
			}
		} catch(Exception e){
			
		}
		toast.dispose();
	}
	
	

}
