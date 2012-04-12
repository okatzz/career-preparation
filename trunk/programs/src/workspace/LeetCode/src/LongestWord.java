import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;


public class LongestWord {
	
	class LengthComparator implements Comparator<String>{
		@Override
		public int compare(String sa, String sb){
			return sa.length()-sb.length();
		}
	}

	public String getLongestWord(String[] arr){
		Arrays.sort(arr, new LengthComparator());
		HashMap<String, Boolean> map = new HashMap<String, Boolean>();
		for(String s: arr){
			map.put(s, true);
		}
		
		for(String s: arr){
			if(canBuildWord(s, map, true)){
				System.out.println(s);
				return s;
			}
		}
		return null;
	}
	
	private boolean canBuildWord(String s, HashMap<String, Boolean> map, boolean isOriginal){
		
		if(!isOriginal && map.containsKey(s))
			return map.get(s);
		
		for(int i=1; i<s.length(); i++){
			String left=s.substring(0, i);
			String right=s.substring(i);
			if(map.containsKey(left)&&map.get(left)&&canBuildWord(right, map, false)){
				map.put(s, true);
				return true;
			}
		}
		map.put(s, false);
		return false;
	}
	
}
