package interaction;

import java.io.IOException;
import java.util.Scanner;

import medium.*;

public class Interaction{
	private final String path;
	private final String file;
	private final String meta;
	
	private Save save;
	public Interaction() {
		path = "";
		file = "verwaltung.txt";
		meta = "meta.txt";
		
		save = new Save(path, file, meta);
	}
	public Interaction(String path, String file, String meta) {
		this.path = path;
		this.file = file;
		this.meta = meta;
		
		save = new Save(path, file, meta);
	}
	public Object[] load() {
		Object[] object = new Object[save.getDataFiles().length];
		int c = 0;
		for(String f : save.getDataFiles()) {
			object[c] = save.getData(f, c);
			c++;
		}
		
		return object;
	}
	
	public boolean start(Stack[] stack) throws IOException {
		System.out.println("Hello, Mate!\nWhat do you want here in my library?");
		System.out.println("1: add Item ; 2: add User ; 3: Look for Item ; 4: Look up User ; 5: exit");
		
		Scanner scan = new Scanner (System.in);
		switch(scan.nextInt()) {
		case 1:
			String category, subtype;
			System.out.println("Please choose the category: ");
			
			System.out.println("Buch has been choosen for you");
			//TODO implemt different categories
			scan.nextLine();
			System.out.print("Speciy subtype: ");
			subtype = scan.nextLine();
			int d = this.duplicate(stack, subtype);
			if(d != -1) {
				stack[d].push(this.create(scan, "Buch", subtype));
				save.add(stack[d].getKennung(), stack[d]);			
			}else {
				Stack[] temp = new Stack[stack.length + 1];
				for(int i = 0; i < stack.length; i++){
					temp[i] = stack[i];
				}
				stack = temp;
				stack[stack.length - 1] = new Stack<Buch>(this.create(scan, "Buch", subtype));
				save.add(stack[stack.length - 1].getKennung(), stack[stack.length - 1]);
			}
			
			break;
		case 2:
			System.out.println("This Function hasn't been implemented yet");
			break;
		case 3:
			if(stack == null)
				break;
			System.out.println("What are you looking for?\n1: Filter by Category 2: Filter by Title 3 sub 4 Autor 5 Preis 6 auf lager");
			// show all
			for(int i = 0; i < stack.length; i++){
				for(int s = 0; s < stack[i].getStack().length; s++)
					System.out.println("\t" + stack[i].getStack()[s].getCategory() + " " +
							stack[i].getStack()[s].getSub() + ": " + 
							stack[i].getStack()[s].getTitel() + " - " +
							stack[i].getStack()[s].getUntertitel() +" : " +
							stack[i].getStack()[s].getPreis() + "€ ; Auf Lager: " +
							stack[i].getStack()[s].getBestand());
			}
			//FIlter
			scan.nextLine();
			switch (Integer.parseInt(scan.nextLine())) {
			
				case 1:
					System.out.print("Filter Category: ");
					boolean[] is = filterCategory(stack, scan.nextLine());
					for(int i = 0; i < is.length; i++){
						if(is[i]) {
							for(int s = 0; s < stack[i].getStack().length; s++)
								System.out.println("\t" + stack[i].getStack()[s].getCategory() + " " +
										stack[i].getStack()[s].getSub() + ": " + 
										stack[i].getStack()[s].getTitel() + " - " +
										stack[i].getStack()[s].getUntertitel() +" : " +
										stack[i].getStack()[s].getPreis() + "€ ; Auf Lager: " +
										stack[i].getStack()[s].getBestand());
						}
					}
				break;
				case 2:
					System.out.println("This hasn't been implemented yet");
				break;
				
			}
			
			break;
		case 4:
			System.out.println("There a no User currently");
			break;
		case 5:
			return false;
		default:
			System.out.println("Mate, I am not sure what you want to do");
			break;
			
		}
		return true;
	}
	public boolean[] filterCategory(Stack[] stack, String category) {
		boolean[] is = new boolean[stack.length];
		for(int i = 0; i < stack.length; i++) {
			if(stack[i].getStack()[0].getCategory().contains(category))
				is[i] = true;
			else
				is[i] = false;
		}
		return is;
	}
	public int duplicate(Stack stack[], String subtype) {
		
		for(int i = 0; i < stack.length; i++) {
			if(subtype.equals(stack[i].getStack()[0].getSub())) {
				return i;
			}
		}
		return -1;
	}
	public Buch create(Scanner scan, String category, String sub) {
		String author, title, subtitle;
		int price, stock; 
		System.out.print("Author: ");
		author = scan.nextLine();
		System.out.print("Title: ");
		title = scan.nextLine();
		System.out.print("Subtitle: ");
		subtitle = scan.nextLine();
		System.out.print("Price(in €): ");
		price = scan.nextInt();
		System.out.print("Stock: ");
		stock = scan.nextInt();
		
		if(subtitle.equals(""))
			return new Buch(category, sub, author, title, price, stock);
		return new Buch(category, sub, author, title, subtitle, price, stock);
		
	}
	
	public String[] getFiles() {
		return save.getDataFiles();
	}
	
	public Save save() {
		return save;
	}
	
}
