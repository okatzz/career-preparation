/*
 * A circus is designing a tower routine consisting of people standing atop one another’s shoulders. For practical and aesthetic reasons, each person must be both shorter and lighter than the person below him or her. Given the heights and weights of each person in the circus, write a method to compute the largest possible number of people in such a tower.
 */
import java.util.ArrayList;
import java.util.Collections;

public class class10_7 {

	public ArrayList<HtWt> longestIncreasingSequence(ArrayList<HtWt> items){
		Collections.sort(items);
		
		ArrayList<HtWt>[] solutions = new ArrayList[items.size()];
		for(int i=0; i<items.size(); i++){
			ArrayList<HtWt> best_sequence=null;
			for(int j=0; j<i; j++){
				if(items.get(j).isBefore(items.get(i))){
					if(best_sequence==null|| best_sequence.size()<solutions[j].size())
						best_sequence=solutions[j];
				}
			}
			solutions[i]=new ArrayList<HtWt>();
			if(best_sequence!=null)
				solutions[i].addAll(best_sequence);
			solutions[i].add(items.get(i));
		}
		
		ArrayList<HtWt> best_sequence=null;
		for(int i=0; i<solutions.length; i++)
			if(best_sequence==null|| best_sequence.size()<solutions[i].size())
				best_sequence=solutions[i];
		return best_sequence;
	}
	
}

class HtWt implements Comparable{
	private int height;
	private int weight;
	
	public HtWt(int h, int w){
		height=h;
		weight=w;
	}
	
	@Override
	public int compareTo(Object obj){
		HtWt other=(HtWt)obj;
		if(this.height==other.height)
			return new Integer(this.weight).compareTo(new Integer(other.weight));
		else
			return new Integer(this.height).compareTo(new Integer(other.height));
	}
	
	public boolean isBefore(HtWt other){
		return this.height<=other.height && this.weight<=other.weight;
	}
}