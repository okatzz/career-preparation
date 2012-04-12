
public class Class5_3 {

	/*
	 * 1. set the bit to the left of the rightmost block of 1s
	 * 2. discard one 1 bit and move the block of 1s to the right as far as possible
	 */
	public int getNextLarge(int num){
		int c0=0, c1=0;
		int mask=1;
		while((mask!=0)&&((num&mask)==0)){
			c0++;
			mask<<=1;
		}
		if(mask==0)
			return -1;
		while((num&mask)!=0){
			c1++;
			mask<<=1;
		}
		if(mask==0)
			return -1;
		num|=mask;
		num&=~(mask-1);
		num|=(1<<(c1-1))-1;
		return num;
	}
	/*
	 * 1. clear the bit to the left of the rightmost block of 0s, p
	 * 2. set all the bits to the right of bit p
	 * 3. clear least significant c0 bit
	 */
	public int getNextSmall(int num){
		int c0=0, c1=0;
		int mask=1;
		while((num&mask)!=0){
			c1++;
			mask<<=1;
		}
		if(mask==0)
			return -1;
		while((mask!=0)&&(num&mask)==0){
			c0++;
			mask<<=1;
		}
		if(mask==0)
			return -1;
		num&=~mask;
		num|=mask-1;
		num&=~((1<<(c0-1))-1);
		return num;
	}
	
}
