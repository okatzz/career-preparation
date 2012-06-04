
public class InPlaceArrayOperation {

	public int[] inplaceMerge(int[] a, int[] b){
		int p=a.length-1;
		int pb=b.length-1;
		int pa=a.length-b.length-1;
		
		while(pa>=0 && pb>=0){
			if(a[pa]>b[pb]){
				a[p]=a[pa];
				pa--;
			}else{
				a[p]=b[pb];
				pb--;
			}
			p--;
		}
		while(pa>=0){
			a[p]=a[pa];
			pa--;
			p--;
		}
		while(pb>=0){
			a[p]=b[pb];
			p--;
			pb--;
		}
		
		return a;
	}
	
	public int[] inplaceRemoveDuplicates(int[] a){
		int fast=0, slow=0;
		while(fast<a.length){
			int e=a[fast];
			while(fast<a.length && a[fast]==e)
				fast++;
			a[slow++]=e;
		}
		while(slow<a.length)
			a[slow++]=0;
		return a;
	}
	
}
