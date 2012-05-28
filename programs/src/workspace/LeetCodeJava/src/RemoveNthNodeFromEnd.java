
public class RemoveNthNodeFromEnd {
	class ListNode{
		int val;
		ListNode next;
	}
	public ListNode removeNthFromEnd(ListNode head, int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(n==0)
            return head;
        
        ListNode pa=head, pb=head;
        int i=0;
        for(i=0; i<n+1; i++){
            if(pb!=null)
                pb=pb.next;
            else
                break;
        }
        if(i==n){
            head=head.next;
            pa.next=null;
        }else if(i==n+1){
            while(pb!=null){
                pb=pb.next;
                pa=pa.next;
            }
            pa.next=pa.next.next;
        }
        
        return head;
        
    }
}
