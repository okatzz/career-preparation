import java.util.HashMap;

public class Class9_1 {
	
	public int countWays(int n, HashMap<Integer, Integer> cache){
		if(cache.containsKey(n))
			return cache.get(n).intValue();
		if(n<0)
			return 0;
		int q=0;
		if(n==0)
			q=1;
		else
			q=countWays(n-1, cache)+countWays(n-2, cache)+countWays(n-3, cache);
		cache.put(n, q);
		return q;
	}
	
}
