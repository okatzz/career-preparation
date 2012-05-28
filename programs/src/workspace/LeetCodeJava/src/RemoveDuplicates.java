
public class RemoveDuplicates {
	
	class ListNode{
		int val;
		ListNode next;
	}
	
	public int removeDuplicates(int[] A) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if(A.length==0)
			return 0;
		int idx = 0;
		for(int i=0; i<A.length; i++){
			if(A[i]!=A[idx]){
				A[++idx]=A[i];
			}
		}
		return (idx+1);
	}
	    public int removeDuplicatesThanTwice(int[] A) {
	        // Start typing your Java solution below
	        // DO NOT write main() function
	        if(A.length==0)
	            return 0;
	        if(A.length==1)
	            return 1;
	        
	        int idx=0;
	        boolean isSecond=false;
	        for(int i=1; i<A.length; i++){
	            if(A[i]==A[idx] && !isSecond){
	                A[++idx]=A[i];
	                isSecond=true;
	            }else if(A[i]!=A[idx]){
	                A[++idx]=A[i];
	                isSecond=false;
	            }
	        }
	        return (idx+1);
	    }
	    
	    public ListNode deleteDuplicates(ListNode head) {
	        // Start typing your Java solution below
	        // DO NOT write main() function
	        if(head==null)
	            return null;
	        
	        ListNode slow=head, fast=head;
	        
	        while(fast!=null){
	            if(fast.val==slow.val)
	                fast=fast.next;
	            else{
	                slow.next=fast;
	                slow=fast;
	            }
	        }
	        slow.next=fast;
	        
	        return head;
	        
	    }
	    
	    public ListNode deleteDuplicates2(ListNode head) {
	        // Start typing your Java solution below
	        // DO NOT write main() function
	        while(true){
	            
	            if(head!=null && head.next!=null && head.val==head.next.val){
	                int temp=head.val;
	                while(head!=null && head.val==temp)
	                    head=head.next;
	            }else
	                break;
	        }
	        
	        
	        ListNode slow=head, fast;
	        if(head==null)
	            return head;
	        fast=head.next;
	        while(true){
	            
	            
	            if(fast!=null && fast.next!=null && fast.val==fast.next.val){
	                int temp=fast.val;
	                while(fast!=null && fast.val==temp)
	                    fast=fast.next;
	            }else{
	                slow.next=fast;
	                slow=slow.next;
	                if(fast!=null)
	                    fast=fast.next;
	                else
	                    return head;
	            }
	        
	        }
	    }
	    
	    public int removeElement(int[] A, int elem) {
	        // Start typing your Java solution below
	        // DO NOT write main() function
	        int i=0, j=A.length-1;
	        while(true){
	            while(i<A.length && A[i]!=elem)
	                i++;
	            while(j>=0 && A[j]==elem)
	                j--;
	            if(j<i)
	                return (j+1);
	            A[i]=A[j];
	            i++;
	            j--;
	        }
	    }
}
