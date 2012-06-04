import java.util.Stack;


public class ValidParenthese {
	    public boolean isValid(String s) {
	        // Start typing your Java solution below
	        // DO NOT write main() function
	        Stack<Character> stack= new Stack<Character>();
	        
	        for(int i=0; i<s.length(); i++){
	            char c=s.charAt(i);
	            switch(c){
	                case '(':
	                case '[':
	                case '{':
	                    stack.push(c);
	                    break;
	                case ')':
	                    if(stack.isEmpty() || !((Character)stack.peek()).equals(Character.valueOf('(')))
	                        return false;
	                    stack.pop();
	                    break;
	                case ']':
	                    if(stack.isEmpty() || !((Character)stack.peek()).equals(Character.valueOf('[')))
	                        return false;
	                    stack.pop();
	                    break;
	                case '}':
	                    if(stack.isEmpty() || !((Character)stack.peek()).equals(Character.valueOf('{')))
	                        return false;
	                    stack.pop();
	                    break;
	            
	            }
	        }
	        if(stack.isEmpty())
	            return true;
	        return false;
	    }
}
