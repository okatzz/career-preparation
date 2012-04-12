
public class SieveOfEratosthenes {

	
	boolean[] sieveOfEratosthenes(int max){
		boolean[] flags=new boolean[max+1];
		
		for(int i=0; i<flags.length; i++)
			flags[i]=true;
		flags[0]=false;
		flags[1]=false;
		
		int prime=2;
		while(prime<= max){
			crossOff(flags, prime);
			getNextPrime(flags, prime);
		}
		
		return flags;
		
	}
	
	void getNextPrime(boolean[] flags, int prime){
		while(!flags[++prime]&&prime<flags.length);
	}
	
	void crossOff(boolean[] flags, int prime){
		for(int i=prime*prime; i<flags.length; i+=prime)
			flags[i]=false;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
