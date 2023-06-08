/**
 * 
 */
import medium.*;

import java.io.IOException;
import java.util.Scanner;

import interaction.*;
/**
 * @author cupido
 *
 */
public class Verwaltung {
	/**
	 * @param args
	 */
	public Verwaltung() {
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Interaction interact = new Interaction();
		Stack stack[] = null;
			//load
		try {	
			//for(int i = 0; i < stack.length; i++)
			Object[] load = interact.load();
			stack = new Stack[load.length];
			for(int i = 0; i < load.length; i++) {	
				switch(interact.getFiles()[i].split("_")[0]) {
				case "Buch":
					stack[i] = (Stack<Buch>) load[i];
					break;
				}
				
			}
				
			//stack = (Stack[]) interact.load();
			System.out.println("Argh, there something");
			//stack = new Stack[interact.getFiles().length];
		} catch(Exception e){
			stack = new Stack[0];
			System.out.println("There is nothing here");
			e.printStackTrace();
		}
		try {
			while(interact.start(stack)) {
			
			}
		} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}
	public static Stack[] push(Stack[] stack){
		if(stack == null){
			return new Stack [1];
		}
		Stack temp[] = new Stack [stack.length + 1];
		for(int i = 0; i < stack.length; i++)
			temp[i] = stack[i];
		return temp;
	}
}