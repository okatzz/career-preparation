import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;


public class Class1_3 {
	
	public static boolean isAnagram1(String s1, String s2){
		if(s1.length() != s2.length())
			return false;
		int[] counters = new int[256];
		for (int i = 0; i < s1.length(); i++) {
			char c = s1.charAt(i);
			counters[c]++;
		}
		for (int i=0; i<s2.length(); i++){
			char c = s2.charAt(i);
			if (counters[c] == 0)
				return false;
			counters[c]--;
		}
		for (int i : counters) {
			if(i!=0)
				return false;
		}
		return true;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String s1="naked";
		String s2="kaden";
		System.out.print(isAnagram1(s1, s2));
		
		ArrayList<Integer> aList = new ArrayList<Integer>();
		LinkedList<Integer> lList = new LinkedList<Integer>();
		Stack<Integer> stack = new Stack<Integer>();
		
	}

}
