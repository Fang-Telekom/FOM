package medium;

import java.io.Serializable;

public class Stack<M extends Medium> implements Serializable{
	
	private M stack[];
	private final String kennung;
	private static int ser = 0;
	
	public Stack(M... medium){
		stack = medium;
		kennung = medium[0].getKennung() + "_" + (ser++);
	}

	public M get(int i){
		if(i<0)
			return stack[0];
		else if(i>stack.length)
			return stack[stack.length-1];
		return stack[i];
	}
	public M[] get(){
		return stack;
	}
	public void push(M ob){
		if(stack != null){
			M temp[] = (M[]) (new Object [stack.length + 1]);
			for(int i = 0; i < stack.length; i++)
				temp[i] = stack[i];
			temp[stack.length] = ob;
			stack = temp;
		}
		else{
			stack = (M[]) new Object [1];
			stack[0] = ob;
		}
	}
	public int size(){
		return stack.length;
	}

	public M[] getStack() {
		return (M[]) stack;
	}

	public String getKennung() {
		return kennung;
	}
	
	
}

