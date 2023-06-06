package medium;

public class Stack<M extends medium>{
	
	private Object stack[];
	
	public Stack(){
		stack = null;
	}
	public Stack(M... medium){
		stack = medium;
	}

	public M get(int i){
		if(i<0)
			return stack[0];
		else if(i>stack.length)
			return stack[stack.length-1];
		return stack[i];
	}
	public void push(M ob){
		if(stack != null){
			Object temp[] = M [stack.length + 1];
			for(int i = 0; i < stack.length; i++)
				temp[i] = stack[i];
			temp=[stack.length]=ob;
			stack = temp;
		}
		else{
			stack = M [1];
			stack[0] = ob;
		}
	}
	public int size(){
		return stack.length;
	}

