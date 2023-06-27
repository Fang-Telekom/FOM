package interaction;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.UnsupportedLookAndFeelException;

import gui.Gui;
import medium.*;
import persons.Guest;

public class Interaction implements ActionListener{
	
	private Save save;
	private Messages message;
	private Gui gui;
	private Guest guest;
	
	private String[] categories = { "Buch" };

	private Stack[] stack;
	
	public Interaction() {
		this("./verwaltung/", "verwaltung.txt", "meta.txt");
	}
	public Interaction(String path, String file, String meta) {
		save = new Save(path, file, meta);
		message = new Messages();
		guest = new Guest(path, "guest.txt");
	}
	public void start() {
		try {
			gui = new Gui(this);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		load();
		
	}
	public void load() {
		try {
			
			Object[] load = new Object[save.getDataFiles().length];
			int c = 0;
			for(String f : save.getDataFiles()) {
				load[c] = save.getData(f, c);
				c++;
			}
			stack = new Stack[load.length];
			for(int i = 0; i < load.length; i++) {	
				switch(getFiles()[i].split("_")[0]) {
				case "Buch":
					stack[i] = (Stack<Buch>) load[i];
					break;
				}
			
			}
			message.toast("Files has been found!", gui.getFrame());
		} catch(Exception e){
			stack = new Stack[0];
			message.toast("No Files can be found!", gui.getFrame());
			//e.printStackTrace();
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == gui.getAddingItem()) {
			if(stack.length != 0) {
				String[] sub = new String[stack.length];
				for(int i = 0; i < stack.length; i++)
					sub[i] = stack[i].getStack()[0].getSub();
				gui.getAdd().addItem(categories, sub);
			}
			else
				gui.getAdd().addItem(categories, null);
			
		} else if(e.getSource() == gui.getAddUser()) {
			gui.getAdd().addPerson(guest.get().length);
		} else if(e.getSource() == gui.getLookItem()) {
			gui.getTable().itemTable(stack);
		} else if(e.getSource() == gui.getLookUser()) {
			gui.getTable().personTable(guest);
		} else if(e.getSource() == gui.getAdd().getNewSub()) {
			gui.getAdd().switchSub();
		} else if(e.getSource() == gui.getAdd().getCancel()) {
			gui.getAdd().dispose();
		} else if(e.getSource() == gui.getAdd().getCreateItem()) {
			try {
				createItem();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} else if(e.getSource() == gui.getAdd().getCreatePerson()) {
			createPerson();
		}
		
	}
	public void createPerson() {
		/* 0 ID
		 * 1 Vorname
		 * 2 Nachname
		 * 3 Geburtstag
		 * 4 Alter
		 * 5 Adresse
		 * 6 Credit
		 * 7 Kommentar
		 */
		String vor = gui.getAdd().getAddPerson()[1].getText(),
				nach = gui.getAdd().getAddPerson()[2].getText(),
				date = gui.getAdd().getAddPerson()[3].getText(),
				adresse = gui.getAdd().getAddPerson()[5].getText(),
				comment = gui.getAdd().getAddPerson()[7].getText();
		int age;
		float credit;
		try {
			credit = Float.parseFloat(gui.getAdd().getAddPerson()[6].getText());
			age = Integer.parseInt(gui.getAdd().getAddPerson()[4].getText());
		} catch(Exception ex) {
			message.Message("Please, tip in Numbers in age and credit", null);
			return;
		}
		guest.add(vor, nach, adresse, date, age, credit, comment);
		gui.getAdd().dispose();
	}
	public void createItem() throws IOException {
		String st = gui.getAdd().getAddItem()[0].getText(), t = gui.getAdd().getAddItem()[2].getText(),
				a = gui.getAdd().getAddItem()[1].getText();
		float p;
		int s;
		try {
			p = Float.parseFloat(gui.getAdd().getAddItem()[4].getText());
			s = Integer.parseInt(gui.getAdd().getAddItem()[5].getText());
		} catch(Exception ex) {
			message.Message("Please, tip in Numbers in Price and Stocks", null);
			return;
		}
		if(t.equals("")) {
			message.Message("Please, give a Title", null);
			return;
		} else if(a.equals("")) {
			message.Message("Please, give an Author", null);
			return;
		}
		
		if(gui.getAdd().getNewSub().isSelected()) {
			if(st.equals("")) {
				message.Message("please give Subtype", null);
				return;
			}
			if(stack != null || stack.length == 0){
				Stack<?> temp[] = new Stack [stack.length + 1];
				for(int i = 0; i < stack.length; i++)
					temp[i] = stack[i];
				stack = temp;
			}
			else{
				stack = new Stack[1];
			}
			
			
			switch(categories[gui.getAdd().getCategoryList().getSelectedIndex()]) {
			case "Buch":
				stack[stack.length - 1] = new Stack<Buch>(new Buch("Buch", st, t, gui.getAdd().getAddItem()[3].getText(), a, p, s));
				
				save.add(stack[stack.length - 1].getKennung(), stack[stack.length - 1]);
				message.Message("Sucess", null);
				gui.getAdd().dispose();
				break;
			}
		} else {
			int selected = gui.getAdd().getSubList().getSelectedIndex();
			switch(categories[gui.getAdd().getCategoryList().getSelectedIndex()]) {
			case "Buch":
				stack[selected].push(new Buch("Buch", st, t, gui.getAdd().getAddItem()[3].getText(), a,p, s));
				save.add(stack[selected].getKennung(), stack[selected]);
				message.Message("Sucess", null);
				gui.getAdd().dispose();
				break;
			}
		}
		
	}
			
	public boolean[] filterCategory(Stack<?>[] stack, String category) {
		boolean[] is = new boolean[stack.length];
		for(int i = 0; i < stack.length; i++) {
			if(stack[i].getStack()[0].getCategory().contains(category))
				is[i] = true;
			else
				is[i] = false;
		}
		return is;
	}
	public String[] getFiles() {
		return save.getDataFiles();
	}
	
	public Save save() {
		return save;
	}
	
}
