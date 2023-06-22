package gui;

import java.awt.FlowLayout;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JTable;

import medium.Stack;

public class Table {
	
	ActionListener listener;
	
	public Table(ActionListener listener) {
		this.listener = listener;
	}
	private void table(String[] column, Object[][] data) {
	
		JFrame frame = new JFrame("Add Item");
		frame.setLayout(new FlowLayout());
		frame.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		frame.setAlwaysOnTop(true);
	
		JTable table = new JTable(data, column);
		table.setEnabled(false);
		frame.add(table);
	
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
	
	public void itemTable(Stack<?>[] stack) {
		String column[] = {"Category", "Subtype", "Title", "Subtitle", "Price", "Stock"};
		Object[][] data;
		
		data = new Object[stack.length + 1][column.length];
		data[0] = column;
		for(int i = 0; i < stack.length; i++){
			for(int s = 0; s < stack[i].getStack().length; s++) {
				Object[] tps = {stack[i].getStack()[s].getCategory(),
						stack[i].getStack()[s].getSub(),
						stack[i].getStack()[s].getTitel(),
						stack[i].getStack()[s].getUntertitel(),
						stack[i].getStack()[s].getPreis(),
						stack[i].getStack()[s].getBestand()};
				data[i + 1] = tps;			
			}
		}
		
		table(column, data);
	}

}
