
public class Class5_6 {

	public int swapEvensOdds(int num){
		return ((num<<1)&0xaaaaaaaa)|((num>>>1)&0x55555555);
	}
	
}
