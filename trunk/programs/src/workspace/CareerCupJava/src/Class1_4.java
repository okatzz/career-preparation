
public class Class1_4 {
	
	public static void replaceSpace(char[] str, int length){
		int num_space = 0;
		for(int i=0; i<length; i++){
			if(str[i]==' ')
				num_space++;
		}
		int newLength = length+num_space*2;
		str[newLength] = '\0';
		int newPos = newLength-1;
		for(int i=length-1; i>=0; i--){
			if(str[i]==' '){
				str[newPos-2]='%';
				str[newPos-1]='0';
				str[newPos]='2';
				newPos-=3;
			}else{
				str[newPos]=str[i];
				newPos--;
			}
		}
		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
