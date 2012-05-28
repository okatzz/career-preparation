
public class LongestCommonPrefix {
	    public String longestCommonPrefix(String[] strs) {
	        // Start typing your Java solution below
	        // DO NOT write main() function
	        if(strs.length==0)
	            return new String();
	        if(strs.length==1)
	            return new String(strs[0]);
	        
	        StringBuilder prefix=new StringBuilder();
	        for(int i=0; i<strs[0].length(); i++){
	            char c=strs[0].charAt(i);
	            for(int j=1; j<strs.length; j++){
	                if(i>=strs[j].length() || strs[j].charAt(i)!=c)
	                    return prefix.toString();
	            }
	            prefix.append(c);
	        }
	        return prefix.toString();
	    }
}
