/*
 * Given a sorted array of n integers that has been rotated an unknown number of times, give an O(log n) algorithm that finds an element in the array.
 * You may assume the array is originally sorted in increasing order.
 */

public class class10_3 {

	
	public static int searchInRotatedArray(int[] array, int x){
		return searchInRotatedArray(array, x, 0, array.length-1);
	}
	
	public static int searchInRotatedArray(int[] a, int x, int start, int end){
		while(start<=end){
			int mid=(start+end)/2;
			if(x==a[mid])
				return mid;
			if(a[start]<a[mid]){
				if(x>=a[start] && x<a[mid])
					end=mid-1;
				else
					start=mid+1;
			}else if(a[start]>a[mid]){
				if(x>a[mid] && x<=a[end])
					start=mid+1;
				else
					end=mid-1;
			}else{
				if(a[start]!=a[end])
					start=mid+1;
				else{
					start++;
					end--;
				}
			}
		}
		return -1;
	}
	
	public static void main(String[] args){
		int[] a = { 2, 3, 2, 2, 2, 2, 2, 2 , 2 , 2 };
		System.out.println(searchInRotatedArray(a, 3));
		System.out.println(searchInRotatedArray(a, 8));
		System.out.println(searchInRotatedArray(a, 2));
		System.out.println(searchInRotatedArray(a, 1));
		System.out.println(searchInRotatedArray(a, 4));
	}
	
}
