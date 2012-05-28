import java.util.ArrayList;
import java.util.Arrays;


public class Class9_4 {

	public ArrayList<int[]> getSubsets(int[] set){
		ArrayList<int[]> powerSet= new ArrayList<int[]>();
		getSubsets(powerSet, set, set.length-1);
		return powerSet;
	}
	
	private void getSubsets(ArrayList<int[]> powerSet, int[] set, int n){
		if(n==-1){
			int[] temp=new int[0];
			powerSet.add(temp);
			return;
		}
		getSubsets(powerSet, set, n-1);
		int size=powerSet.size();
		for(int i=0; i<size; i++){
			int[] temp=powerSet.get(i);
			int[] newSet = Arrays.copyOf(temp, temp.length+1);
			newSet[temp.length]=set[n];
		}
	}
	
	public ArrayList<ArrayList<Integer>> getSubsets(ArrayList<Integer> set){
		ArrayList<ArrayList<Integer>> allSubsets = new ArrayList<ArrayList<Integer>>();
		int max = 1<<set.size();
		for(int i=0; i<max; i++){
			ArrayList<Integer> subset = convertInt2Set(i, set);
			allSubsets.add(subset);
		}
		return allSubsets;
	}
	
	private ArrayList<Integer> convertInt2Set(int i, ArrayList<Integer> set){
		ArrayList<Integer> subset = new ArrayList<Integer>();
		for(int j=0; j<set.size(); j++){
			if((i&(1<<j))>0)
				subset.add(set.get(j));
		}
		return subset;
	}
	
}
