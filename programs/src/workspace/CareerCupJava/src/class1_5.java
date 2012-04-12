/*
 * Implement a method to perform basic string compression using the counts of repeated characters. For example, the string aabcccccaaa would become a2b1c5a3. If the "compressed" string would not become smaller than the 
 * original string, your method should return the original string.
 */


public class class1_5 {

	// no temporary parameter
	static String compressedBetter(String str){
		StringBuffer myStr = new StringBuffer();
		int count=1;
		for(int i=1; i<str.length(); i++){
			if(str.charAt(i)!=str.charAt(i-1)){
				myStr.append(str.charAt(i-1));
				myStr.append(count);
				count=1;
			}else{
				count++;
			}
		}
		
		myStr.append(str.charAt(str.length()-1));
		myStr.append(count);
		
		String compressedStr=myStr.toString();
		if(compressedStr.length()>=str.length())
			return str;
		else
			return compressedStr;
	}
	
	static String compressedBetter(String str){
		
	}
	
	public static void main(String[] args){
		System.out.println(compressedBetter(new String("aabcccccaaa")));
	}
	
}
