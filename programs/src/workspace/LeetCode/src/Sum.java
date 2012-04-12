import java.util.ArrayList;
import java.util.Arrays;


public class Sum {
	    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
	        // Start typing your Java solution below
	        // DO NOT write main() function
	        ArrayList<ArrayList<Integer>> set=new ArrayList<ArrayList<Integer>>();
	        
	        Arrays.sort(num);
	        for(int i=0; i<num.length; i++){
	            int j=i+1, k=num.length-1;
	            while(j<k){
	                int sum=num[i]+num[j]+num[k];
	                if(sum>0){
	                    k--;
	                }else if(sum<0){
	                    j++;
	                }else{
	                    ArrayList<Integer> triplet=new ArrayList<Integer>();
	                    triplet.add(num[i]);
	                    triplet.add(num[j]);
	                    triplet.add(num[k]);
	                    set.add(triplet);
	                    
	                    int temp=num[j];
	                    while((j<num.length) && (num[j]==temp))
	                        j++;
	                    temp=num[k];
	                    while((k>i) && (num[k]==temp))
	                        k--;
	                }
	            }
	            int temp=num[i];
	            while((i<num.length) && (num[i]==temp))
	                i++;
	            i--;
	        }
	        return set;
	    }
	    
	    public static void main(String[] args){
	    	
	    	ArrayList r =(new Sum()).threeSum(new int[]{-1, 0, 0, 1, 2, -1, -4});
	    	System.out.println(r);
	    }
}
