package gui;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class AddItem {
	
	private JFrame frame;
	private JComboBox<String> categoryList;
	
	private JComboBox<String> subList;
	private JCheckBox newSub;
	private JButton create;
	private JButton cancel;
	
	private JTextField[] addItem = new JTextField[6];
	/* 0 subtype;
		1 author;
		2 title;
		3 subtitle;
		4 price;
		5 stock;*/
	
	public AddItem(String[] categories, String[] sub, ActionListener listener) {
		frame = new JFrame("Add Item");
		frame.setSize(300, 400);
		frame.setLayout(null);
		frame.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		frame.setResizable(false);
	    frame.setLocationRelativeTo(null);
	    
	    JLabel[] label = new JLabel[8];
		categoryList = new JComboBox<String>(categories);
		categoryList.setBounds(25, 20, 250, 25);
		label[1] = new JLabel("Categories");
		label[1].setBounds(25, 7, 250, 15);
		newSub = new JCheckBox();
		newSub.setBounds(25, 52, 15, 15);
		label[0] = new JLabel("A new Subtype?");
		label[0].setBounds(50, 52, 250, 15);
		
		for(int y = 0; y < addItem.length; y++) {
			addItem[y] = new JTextField();
			addItem[y].setBounds(25, y * 40 + 90, 250, 25);
			label[y+2] = new JLabel();
			label[y+2].setBounds(25, y * 40 + 77, 250, 15);
		}
		label[2].setText("Subtyp");
		label[3].setText("Author");
		label[4].setText("Title");
		label[5].setText("Subtitle");
		label[6].setText("Price");
		label[7].setText("Stock");
		
		if(sub != null) {
			 subList = new JComboBox<String>(sub);			
		}else {
			 subList = new JComboBox<String>();
			 newSub.setEnabled(false);
			 newSub.setSelected(true);
		}
		subList.setBounds(25, 90, 250, 25);
		
		create = new JButton("Create");
		cancel = new JButton("Cancel");
		cancel.setBounds(25, 330, 120, 25);
		create.setBounds(155, 330, 120, 25);
		
		frame.add(categoryList);
		frame.add(newSub);
		if(newSub.isSelected())
			frame.add(addItem[0]);
		else
			frame.add(subList);
		
		for(int i = 1; i < addItem.length; i++)
			frame.add(addItem[i]);
		for(int i = 0; i < label.length; i++)
			frame.add(label[i]);
		
		frame.add(create);
		frame.add(cancel);
		
		newSub.addActionListener(listener);
		create.addActionListener(listener);
		cancel.addActionListener(listener);
	    
	    frame.setVisible(true);
	}
	
	public void dispose() {
		frame.dispose();
	}
	
	public void switchSub() {
		if(getNewSub().isSelected()) {
			frame.remove(subList);
			frame.add(addItem[0]);
		}else {
			frame.remove(addItem[0]);
			frame.add(subList);
		}

		frame.repaint();
	}

	public JComboBox<String> getCategoryList() {
		return categoryList;
	}

	public JComboBox<String> getSubList() {
		return subList;
	}

	public JCheckBox getNewSub() {
		return newSub;
	}

	public JButton getCreate() {
		return create;
	}

	public JButton getCancel() {
		return cancel;
	}

	public JTextField[] getAddItem() {
		return addItem;
	}
	
}
