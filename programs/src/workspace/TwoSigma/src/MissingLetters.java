import java.util.Arrays;


public class MissingLetters {

	public String getMissingLetters(String sentence){
		
		boolean[] exist = new boolean[26];
		Arrays.fill(exist, false);
		
		for(int i=0; i<sentence.length(); i++){
			char c = sentence.charAt(i);
			if(Character.isLetter(c)){
				exist[Character.toLowerCase(c)-'a']=true;
			}
		}
		
		StringBuffer result = new StringBuffer();
		for (int i = 0; i < exist.length; i++) {
			if(!exist[i]){
				result.append((char)('a'+i));
			}
		}
		
		return result.toString();
	}
	
}
