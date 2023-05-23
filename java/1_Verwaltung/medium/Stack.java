package medium;

public class Stack<M extends medium>{
	
	private Object stack[];

	public Stack(nt size){
		stack = new Object[size];
	}

	public void get(int i){
		if(i<0)
			return stack[0];
		else if(i>stack.length)
			return stack[stack.length-1];
		return stack[i];
	}
	public void push(M ob){
		Object temp[] = new Object [stack.length + 1];
		for(int i = 0; i < stack.length; i++)
			temp[i] = stack[i];
		temp=[stack.length]=ob;
		stack = temp;
	}
	public int size(){
		return stack.length;
	}

