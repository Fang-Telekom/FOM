package gui;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import medium.Stack;

public class Gui {
	
	private AddItem add;
	private LookItem look;
	
	private JButton addingItem;
	private JButton addUser;
	private JButton lookItem;
	private JButton lookUser;
	
	private JFrame frame;
	
	public Gui(ActionListener listener) {
		frame = new JFrame();
		//UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		addingItem =  new JButton("Add Item");
		addUser =  new JButton("Add User");
		lookItem =  new JButton("Look for Item");
		lookUser =  new JButton("Look up User");
		
		frame.setLayout(new FlowLayout());
		
		frame.add(addingItem);
		frame.add(addUser);
		frame.add(lookItem);
		frame.add(lookUser);	
		
		addingItem.addActionListener(listener);
		addUser.addActionListener(listener);
		lookItem.addActionListener(listener);
		lookUser.addActionListener(listener);
		
		//auto calculate size
		frame.pack();
		//frame.setSize(600, 1000);
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
	    int x = (int) ((dimension.getWidth() - frame.getWidth()) / 2);
	    int y = (int) ((dimension.getHeight() - frame.getHeight()) / 2);
	    frame.setLocation(x, y);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
	public void addItem(String[] categories, String[] sub, ActionListener listener) {
		add = new AddItem(categories, sub, listener);
	}
	public void lookItem(Stack<?>[] stack) {
		look = new LookItem(stack);
	}

	public AddItem getAdd() {
		return add;
	}

	public LookItem getLook() {
		return look;
	}

	public JButton getAddingItem() {
		return addingItem;
	}

	public JButton getAddUser() {
		return addUser;
	}

	public JButton getLookItem() {
		return lookItem;
	}

	public JButton getLookUser() {
		return lookUser;
	}

	public JFrame getFrame() {
		return frame;
	}
	
}
