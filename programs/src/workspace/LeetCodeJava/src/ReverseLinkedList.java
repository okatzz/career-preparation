
public class ReverseLinkedList {

	class Node{
		int value;
		Node next;
	}
	
	public Node reverseList(Node head){
		Node prev=null, cur=head;
		while(cur!=null){
			Node next=cur.next;
			cur.next=prev;
			prev=cur;
			cur=next;
		}
		return prev;
	}
	
	public Node reverseListRecursive(Node head){
		
		if(head==null)
			return null;
		if(head.next==null)
			return head;
		Node newHead=reverseListRecursive(head.next);
		head.next.next=head;
		head.next=null;
		return newHead;
	}
}
