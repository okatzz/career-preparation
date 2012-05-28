import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class LengthOfLastWord {

	
	    public int lengthOfLastWord(String s) {
	        // Start typing your Java solution below
	        // DO NOT write main() function
	    	int end=s.length()-1;
	    	while(end>=0 && s.charAt(end)==' ')
	    		end--;
	        int count=0;
	        for(int i=end; i>=0; i--){
	            if(s.charAt(i)!=' ')
	                count++;
	            else
	                break;
	        }
	        return count;
	    }
	    
	    public static void main(String[] args) throws IOException{
	    	BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	    	String string=in.readLine();
	    	System.out.println(new LengthOfLastWord().lengthOfLastWord(string));
	    }
	
}
