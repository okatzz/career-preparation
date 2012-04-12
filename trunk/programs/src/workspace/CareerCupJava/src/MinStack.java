import java.util.Stack;


public class MinStack {
	
	Stack<NodeWithMin> stack;
	
	public int min(){
		
		if(stack.empty())
			return Integer.MAX_VALUE;
		else
			return stack.peek().min;
	}
	public void push(int data){
		int min = Math.min(data, min());
		stack.push(new NodeWithMin(data, min));
	}
	
	public int pop(){
		return stack.pop().data;
	}
}

class NodeWithMin{
	int data;
	int min;
	NodeWithMin(int data, int min){
		this.data = data;
		this.min = min;
	}
}
