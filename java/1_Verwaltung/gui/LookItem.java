package gui;

import java.awt.FlowLayout;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JTable;

import medium.Stack;

public class LookItem {

	public LookItem(Stack<?>[] stack) {
		/*if(stack.length == 0)
			return;*/	
		
		JFrame tableModal = new JFrame("Add Item");
		tableModal.setSize(800, 300);
		tableModal.setLayout(new FlowLayout());
		tableModal.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		
		tableModal.setLocationRelativeTo(null);
		
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
		JTable table = new JTable(data, column);
		//table.setMinimumSize(new Dimension(800, 300));
		
		//table.setBounds(0, 0, 800, 300);
		table.setEnabled(false);
		//t
		tableModal.add(table);
		tableModal.pack();
		tableModal.setVisible(true);
	}

}
