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
	
	public static char getCharKey(int num, int seq){ return '0';}
}