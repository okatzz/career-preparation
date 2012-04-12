import java.util.ArrayList;

public class PowerSet {
	
	ArrayList<ArrayList<Integer>> powerSet(ArrayList<Integer> set, int index){
		ArrayList<ArrayList<Integer>> allSubsets = new ArrayList<ArrayList<Integer>>();
		if(index==0){
			ArrayList<Integer> emptySet=new ArrayList<Integer>();
			allSubsets.add(emptySet);
		}else{
			allSubsets=powerSet(set, index-1);
			ArrayList<ArrayList<Integer>> moreSubsets = new ArrayList<ArrayList<Integer>>();
			int element = set.get(index);
			for(ArrayList<Integer> subset:allSubsets){
				ArrayList<Integer> newSubset = new ArrayList<Integer>();
				newSubset.addAll(subset);
				newSubset.add(element);
				moreSubsets.add(newSubset);
			}
			allSubsets.addAll(moreSubsets);
		}
		return allSubsets;
	}
	
}
