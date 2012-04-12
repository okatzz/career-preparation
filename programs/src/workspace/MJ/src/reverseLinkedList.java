
public class reverseLinkedList {

	class Node{
		int value;
		Node next;
	}
	
	public Node reverseLinkedList(Node head){
		if(head==null)
			return null;
		Node next=head.next;
		while(next!=null){
			Node nextnext=next.next;
			next.next=head;
			head=next;
			next=nextnext;
		}
		return head;
	}

	
}
