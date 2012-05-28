
public class RotateList {
	
	
	class ListNode{
		int value;
		ListNode next;
	}

	public ListNode rotateRight(ListNode head, int n){
        ListNode ahead = head;
        for(int i=0; i<n; i++){
            if(ahead==null)
                return null;
            ahead=ahead.next;
        }
        if(ahead==null)
            return head;
        ListNode running = head;
        while(ahead.next!=null){
            running=running.next;
            ahead=ahead.next;
        }
        
        ahead.next=head;
        head=running.next;
        running.next=null;
        
        return head;
	}
	
}
