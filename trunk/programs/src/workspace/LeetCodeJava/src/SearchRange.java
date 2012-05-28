
public class SearchRange {
	public int[] searchRange(int[] A, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int[] range=new int[2];
        int start=0, end=A.length-1;
        while(start<=end){
            int mid=start+(end-start)/2;
            
            if(target<A[mid])
                end=mid-1;
            else if(target>A[mid])
                start=mid+1;
            else{
                range[0]=range[1]=mid;
                while(range[0]>=0 && A[range[0]]==target)
                    range[0]--;
                range[0]++;
                while(range[1]<A.length && A[range[1]]==target)
                    range[1]++;
                range[1]--;
                
                return range;
            }
        }
        
        range[0]=range[1]=-1;
        return range;
    }
}
