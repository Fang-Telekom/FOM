package medium;

import java.io.Serializable;

public class Stack<M extends Medium> implements Serializable{
	
	private Object stack[];
	private final String kennung;
	private static int ser = 0;
	
	public Stack(M... medium){
		stack = medium;
		kennung = medium[0].getKennung() + "_" + (ser++);
	}

	public Object get(int i){
		if(i<0)
			return stack[0];
		else if(i>stack.length)
			return stack[stack.length-1];
		return stack[i];
	}
	public void push(M ob){
		if(stack != null){
			Object temp[] = new Object [stack.length + 1];
			for(int i = 0; i < stack.length; i++)
				temp[i] = stack[i];
			temp[stack.length] = ob;
			stack = temp;
		}
		else{
			stack = new Object [1];
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

