/*
 * BST to doubly linked list
 */

public class class17_13{
	class Node{
		Node last;
		Node next;
	}
	public Node bstToCircularDoublyLinkedList(Node root){
		if(root==null)
			return null;
		
		Node leftHead=bstToCircularDoublyLinkedList(root.last);
		Node rightHead=bstToCircularDoublyLinkedList(root.next);
		
		if(leftHead==null&&rightHead==null){
			root.last=root;
			root.next=root;
			return root;
		}else if(leftHead==null&&rightHead!=null){
			Node rightTail=rightHead.last;
			root.next=rightHead;
			rightHead.last=root;
			root.last=rightTail;
			rightTail.next=root;
			return root;
		}else if(leftHead!=null&&rightHead==null){
			Node leftTail=leftHead.last;
			leftTail.next=root;
			root.last=leftTail;
			root.next=leftHead;
			leftHead.last=root;
			return leftHead;
		}else{
			Node leftTail=leftHead.last;
			Node rightTail=rightHead.last;
			leftTail.next=root;
			root.last=leftTail;
			root.next=rightHead;
			rightHead.last=root;
			rightTail.next=leftHead;
			leftHead.last=rightTail;
			return leftHead;
		}
		

	}
}