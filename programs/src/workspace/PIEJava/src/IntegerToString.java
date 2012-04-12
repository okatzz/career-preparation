
public class IntegerToString {

	public static final int MAX_DIGITS=10;
	public static String integerToString(int num){
		boolean negative=false;
		if(num<0){
			negative=true;
			num=-num;
		}
		char[] temp=new char[MAX_DIGITS];
		int i=0;
		do{
			temp[i++]=(char)(num%10+'0');
			num/=10;
		}while(num!=0);
		
		StringBuilder result= new StringBuilder();
		if(negative){
			result.append('-');
		}
		while(i>0){
			result.append(temp[--i]);
		}
		
		return result.toString();
		
	}
	

	public static void main(String[] args){
		System.out.println((char)('0'+9));
	}
	
}
