import java.util.Stack;


public class Class3_6 {

	public Stack<Integer> sort(Stack<Integer> stack){
		Stack<Integer> tempStack = new Stack<Integer>();
		while(!stack.empty()){
			Integer top = stack.pop();
			while(!tempStack.empty()&& top<tempStack.peek()){
				stack.push(tempStack.pop());
			}
			tempStack.push(top);
		}
		while(!tempStack.empty())
			stack.push(tempStack.pop());
		return stack;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
