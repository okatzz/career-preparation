import java.util.Stack;


public class SimplifyPath {
	    public String simplifyPath(String path) {
	        // Start typing your Java solution below
	        // DO NOT write main() function
	        Stack<String> stack=new Stack<String>();
	        String[] dirs=path.trim().split("/+");
	        for(int i=0; i<dirs.length; i++){
	            if(dirs[i].equals("..") && !stack.isEmpty()){
	                stack.pop();
	            }else if(!dirs[i].equals(".")&&!dirs[i].isEmpty()){
	                stack.push(dirs[i]);
	            }
	        }
	        Stack<String> other=new Stack<String>();
	        while(!stack.isEmpty()){
	            other.push(stack.pop());
	        }
	        StringBuilder out=new StringBuilder();
	        if(other.isEmpty()){
	            out.append('/');
	        }else{
	            while(!other.isEmpty()){
	                out.append('/');
	                out.append(other.pop());
	            }
	        }
	        return out.toString();
	}
}
