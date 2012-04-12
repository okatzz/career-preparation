
public class Class9_3 {
	
	public int getMagicIndex(int[] array, int begin, int end){
		if(begin<0 || end>=array.length || begin>end)
			return -1;
		int mid = (begin+end)/2;
		if(array[mid]==mid)
			return mid;
		if(array[mid]<mid)
			return getMagicIndex(array, mid+1, end);
		else
			return getMagicIndex(array, begin, mid-1);
		
	}
	
}
