import java.util.ArrayList;

public class PhoneWords{
	public static void printPhoneWordsRecursive(int[] number){
		int length=number.length;
		char[] out=new char[length];
		phoneWordsRecursive(number, out, 0, length);
	}
	
	public static void phoneWordsRecursive(int[] number, char[] out, int currDigit, int length){
		if(currDigit==length){
			System.out.println(out);
			return;
		}
		
		for(int i=1; i<=3; i++){
			out[currDigit]=getCharKey(number[currDigit], i);
			phoneWordsRecursive(number, out, currDigit+1, length);
			if(number[currDigit]==0||number[currDigit]==1)
				return;
		}
	}
	
	public static void printPhoneWordsNonRecursive(int[] number){
		int length=number.length;
		char[] out=new char[length];
		
		for(int i=0; i<length; i++)
			out[i]=getCharKey(number[i], 1);
			
		while(true){
			System.out.println(out);
			
			for(int i=length-1; i>=-1; i--){
				if(i==-1)
					return;
				
				if(out[i]==getCharKey(number[i], 1)){
					out[i]=getCharKey(number[i], 2);
					break;
				}else if(out[i]==getCharKey(number[i], 2)){
						out[i]=getCharKey(number[i], 3);
						break;
				}else{
					out[i]=getCharKey(number[i], 1);
				}
			}
		}
	}
	
	public static ArrayList<char[]> phoneWordsNonRecursive2(int[] num){
		char[] word=new char[num.length];
		for(int i=0; i<num.length; i++){
			word[i]=getCharKey(num[i], 1);
		}
		
		ArrayList<char[]> result = new ArrayList<char[]>();
		
		while(true){
			result.add(word);
			int i;
			for(i=num.length-1; i>=0; i--){
				if(word[i]==getCharKey(num[i], 3) || num[i]==0 || num[i]==1){
					word[i]=getCharKey(num[i], 1);
				}else if(word[i]==getCharKey(num[i], 1)){
					word[i]=getCharKey(num[i], 2);
					break;
				}else{
					word[i]=getCharKey(num[i], 3);
					break;
				}
			}
			if(i==-1)
				return result;
		}
	}
	
	public static char getCharKey(int num, int seq){ return '0';}
}