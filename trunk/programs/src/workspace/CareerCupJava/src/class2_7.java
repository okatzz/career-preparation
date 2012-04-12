import java.util.LinkedList;
import java.util.Stack;

public class class2_7 {
	
	public boolean isPalindrome1(LinkedListNode list){
		
		LinkedListNode reverseList=null;
		LinkedListNode temp=list;
		
		while(temp!=null){
			reverseList=new LinkedListNode(temp.data, reverseList);
			temp=temp.next;
		}
		
		while(list!=null){
			if(list.data!=reverseList.data)
				return false;
			list=list.next;
			reverseList=reverseList.next;
		}
		return true;
	}
	
	public boolean isPalindrome2(LinkedListNode list){
		Stack<Integer> stack=new Stack<Integer>();
		LinkedListNode fast, slow;
		fast=slow=list;
		
		while(fast!=null&&fast.next!=null){
			stack.push(slow.data);
			slow=slow.next;
			fast=fast.next.next;
		}
		
		if(fast!=null)
			slow=slow.next;
		while(slow!=null){
			int e=stack.pop().intValue();
			if(e!=slow.data)
				return false;
			slow=slow.next;
		}
		
		return true;
		
	}

}

class LinkedListNode{
	int data;
	LinkedListNode next;
	LinkedListNode(int d, LinkedListNode n){
		data=d;
		next=n;
	}
}
