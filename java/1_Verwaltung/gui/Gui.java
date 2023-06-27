package gui;

import java.awt.FlowLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Gui {
	
	private Add add;
	private Table look;
	
	private JButton addingItem;
	private JButton addUser;
	private JButton lookItem;
	private JButton lookUser;
	
	private JFrame frame;
	
	public Gui(ActionListener listener) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		look = new Table(listener);
		add = new Add(listener);
		
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
		frame.setLocationRelativeTo(null);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
	/*public void addItem(String[] categories, String[] sub) {
		add.addItem(categories, sub);
	}
	/**public void look(Stack<?>[] stack) {
		look.itemTable(stack);
	}*/

	public Add getAdd() {
		return add;
	}

	public Table getTable() {
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
