import java.util.ArrayList;
public class Class9_5 {
	
	ArrayList<String> permutate(String s){
		ArrayList<String> permutations = new ArrayList<String>();
		if(s.length()==1){
			permutations.add(new String(s));
		}else{
			permutations=permutate(s.substring(0, s.length()-2));
			String lastChar=s.substring(s.length(), s.length());
			ArrayList<String> moreStrings = new ArrayList<String>();
			for(String str:permutations){
				for(int i=0; i<str.length(); i++){
					String newString = new String();
					newString.concat(str.substring(0, i)).concat(lastChar).concat(str.substring(i+1, str.length()));
					moreStrings.add(newString);
				}
			}
		}
		return permutations;
	}
	
}
