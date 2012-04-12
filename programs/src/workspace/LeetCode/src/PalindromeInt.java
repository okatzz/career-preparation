class PalindromeInt{
	public boolean isPalindrome(int num){
		if(num<0)
			return false;
		int div=1;
		while(num/(div*10)>0){
			div*=10;
		}
		
		while(num>0){
			int r=num%10;
			int l=num/div;
			if(r!=l)
				return false;
			num%=div;
			num/=10;
			div/=100;
		}
		return true;
	}
}