package interaction;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;

import medium.*;

public class Interaction implements ActionListener{
	
	private Save save;
	private Messages message;
	
	private JFrame frame;
	private JButton addingItem;
	private JButton addUser;
	private JButton lookItem;
	private JButton lookUser;
	
	private String[] sub = null;
	
	private JFrame addItemModal;
	
	private String[] categories = { "Buch" };
	private JComboBox<String> categoryList;
	
	private JCheckBox newSub;
	private JComboBox<String> subList;
	private JTextField[] addItem = new JTextField[6];
	/* 0 subtype;
		1 author;
		2 title;
		3 subtitle;
		4 price;
		5 stock;*/
	
	private JButton create;
	private JButton cancel;
	
	private JFrame tableModal;
	
	@SuppressWarnings("rawtypes")
	private Stack[] stack;
	
	public Interaction() {
		this("./verwaltung/", "verwaltung.txt", "meta.txt");
	}
	public Interaction(String path, String file, String meta) {
		
		save = new Save(path, file, meta);
		message = new Messages();
		load();
	}
	public void load() {
		//load
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
		System.out.println("Argh, there something\n Files has been found");
		} catch(Exception e){
			stack = new Stack[0];
			System.out.println("No File can be Found");
			//e.printStackTrace();
		}
	}
	public void start() throws IOException {
		
		if(stack.length != 0) {
			sub = new String[stack.length];
			for(int i = 0; i < stack.length; i++)
				sub[i] = stack[i].getStack()[0].getSub();
		}
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
		
		this.addingItem.addActionListener(this);
		this.addUser.addActionListener(this);
		this.lookItem.addActionListener(this);
		this.lookUser.addActionListener(this);
		
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

	public void lookItem() {
		/*if(stack.length == 0)
			return;*/	
		
		tableModal = new JFrame("Add Item");
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
	public void addItem() {
		addItemModal = new JFrame("Add Item");
		addItemModal.setSize(300, 400);
		addItemModal.setLayout(null);
		addItemModal.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		addItemModal.setResizable(false);
	    addItemModal.setLocationRelativeTo(null);
	    
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
		
		addItemModal.add(categoryList);
		addItemModal.add(newSub);
		if(newSub.isSelected())
			addItemModal.add(addItem[0]);
		else
			addItemModal.add(subList);
		
		for(int i = 1; i < addItem.length; i++)
			addItemModal.add(addItem[i]);
		for(int i = 0; i < label.length; i++)
			addItemModal.add(label[i]);
		
		addItemModal.add(create);
		addItemModal.add(cancel);
		
		newSub.addActionListener(this);
		create.addActionListener(this);
		cancel.addActionListener(this);
	    
	    addItemModal.setVisible(true);
	}
	
	public int duplicate(Stack<?> stack[], String subtype) {
		
		for(int i = 0; i < stack.length; i++) {
			if(subtype.equals(stack[i].getStack()[0].getSub())) {
				return i;
			}
		}
		return -1;
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == this.addingItem) {
			addItem();
			
		} else if(e.getSource() == this.addUser) {
			//modal = new JDialog(this.frame, "Add User", true);
		} else if(e.getSource() == this.lookItem) {
			this.lookItem();
		} else if(e.getSource() == this.lookUser) {
			
		} else if(e.getSource() == this.newSub) {
			if(newSub.isSelected()) {
				addItemModal.remove(subList);
				addItemModal.add(addItem[0]);
			}else {
				addItemModal.remove(addItem[0]);
				addItemModal.add(subList);
			}
			
			addItemModal.repaint();
					
		} else if(e.getSource() == this.cancel) {
			addItemModal.dispose();
		} else if(e.getSource() == this.create) {
			try {
				create();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
		
	}
	public void create() throws IOException {
		String st = addItem[0].getText(), t = addItem[2].getText(), a = addItem[1].getText();
		float p;
		int s;
		try {
			p = Float.parseFloat(addItem[4].getText());
			s = Integer.parseInt(addItem[5].getText());
		} catch(Exception ex) {
			message.Message("Please, tip in Numbers in Price and Stocks", addItemModal);
			return;
		}
		if(t.equals("")) {
			message.Message("Please, give a Title", addItemModal);
			return;
		} else if(a.equals("")) {
			message.Message("Please, give an Author", addItemModal);
			return;
		}
		
		if(newSub.isSelected()) {
			if(st.equals("")) {
				message.Message("please give Subtype", addItemModal);
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
			
			
			switch(categories[categoryList.getSelectedIndex()]) {
			case "Buch":
				stack[stack.length - 1] = new Stack<Buch>(new Buch("Buch", st, t, addItem[3].getText(), a, p, s));
				
				save.add(stack[stack.length - 1].getKennung(), stack[stack.length - 1]);
				message.Message("Sucess", addItemModal);
				addItemModal.dispose();
				break;
			}
		} else {
			int selected = subList.getSelectedIndex();
			switch(categories[categoryList.getSelectedIndex()]) {
			case "Buch":
				stack[selected].push(new Buch("Buch", st, t, addItem[3].getText(), a,p, s));
				save.add(stack[selected].getKennung(), stack[selected]);
				message.Message("Sucess", addItemModal);
				addItemModal.dispose();
				break;
			}
		}
		
	}
			
/*	public Stack<?>[] push(Stack<?>[] s) {
		if(stack != null){
			Stack<?> temp[] = new Stack [s.length + 1];
			for(int i = 0; i < s.length; i++)
				temp[i] = s[i];
			return temp;
		}
		else{
			return stack = new Stack[1];
		}
	}*/
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
