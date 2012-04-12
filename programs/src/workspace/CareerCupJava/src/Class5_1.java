
public class Class5_1 {

	public int insertM2N(int n, int m, int j, int i){
		int mask=~(((1<<(j-i+1))-1)<<i);
		n&=mask;
		m<<=i;
		return n|m;
	}
	
}
