
public class Class3_1 {
	
	int stackCapacity = 100;
	int[] stacks = new int[stackCapacity*3];
	int[] tops = {0, 0, 0};
	
	public boolean push(int stackNum, int data) throws Exception{
		if(tops[stackNum]==stackCapacity)
			throw new Exception("Full stack!");
		int index = stackCapacity*stackNum+tops[stackNum];
		stacks[index]=data;
		tops[stackNum]++;
		return true;
	}
	
	public int pop(int stackNum) throws Exception{
		if(tops[stackNum]==0)
			throw new Exception("Empty stack!");
		tops[stackNum]--;
		int index = stackCapacity*stackNum+tops[stackNum];
		return stacks[index];
	}
	
	public boolean isEmpty(int stackNum){
		return tops[stackNum]==0;
	}
	
}
