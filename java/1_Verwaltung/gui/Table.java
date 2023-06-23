package gui;

import java.awt.FlowLayout;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JTable;

import medium.Stack;
import persons.Persons;

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
	public void personTable(Persons persons) {
		String column[] = {"ID", "Vorname", "Nachname", "Geburtstag", "Alter", "Adresse", "Credit", "Kommentar"};
		int size = 1;
		size += persons.get().length;
		Object[][] data = new Object[size][column.length];
		
		data[0] = column;
		for(int i = 0; i < persons.get().length; i++) {
			Object[] temp = {persons.get(i).getId(), persons.get(i).getVorname(),
					persons.get(i).getNachname(), persons.get(i).getDate(), persons.get(i).getAge(),
					persons.get(i).getAdresse(), persons.get(i).getCredit(), persons.get(i).getComment()};
			data[i + 1] = temp;
		}
		table(column, data);
	}
	public void itemTable(Stack<?>[] stack) {
		String column[] = {"Category", "Subtype", "Title", "Subtitle", "Price", "Stock"};
		Object[][] data;
		int size = 1;
		for(int i = 0; i < stack.length; i++)
			size += stack[i].get().length;
		data = new Object[size][column.length];
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
