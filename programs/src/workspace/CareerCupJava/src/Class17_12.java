import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Class17_12 {

	//O(n)
	public void printPairSums(int[] a, int sum){
		Map<Integer, Boolean> map = new HashMap<Integer, Boolean>();
		
		for(int i=0; i<a.length; i++){
			if(map.get(sum-i))
				System.out.println("("+i+", "+(sum-i)+")");
			map.put(i, true);
		}
	}
	
	//O(nlogn)
	public void printPairSums2(int[] a, int sum){
		Arrays.sort(a);
		int head=0, rear=a.length-1;
		while(head<rear){
			if((a[head]+a[rear])==sum){
				System.out.println("("+a[head]+", "+a[rear]+")");
				head++;
			}else if((a[head]+a[rear])<sum){
				head++;
			}else
				rear++;
		}
	}

	
}
