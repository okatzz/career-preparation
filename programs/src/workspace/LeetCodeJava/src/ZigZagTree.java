import java.util.Stack;

class ZigZagTree{
	class Node{
		int data;
		Node left;
		Node right;
	}
	public void printZigZagTree(Node root){
		Stack<Node> cur=new Stack<Node>();
		Stack<Node> next=new Stack<Node>();
		boolean left2right=true;
		cur.push(root);
		while(!cur.isEmpty()){
			while(!cur.isEmpty()){
				Node temp=(Node)cur.pop();
				System.out.print(temp.data+" ");
				if(left2right){
					if(temp.left!=null)
						next.push(temp.left);
					if(temp.right!=null)
						next.push(temp.right);
				}else{
					if(temp.right!=null)
						next.push(temp.right);
					if(temp.left!=null)
						next.push(temp.left);
				}
			}
			System.out.println();
			Stack<Node> s=cur;
			cur=next;
			next=s;
			left2right=!left2right;
		}
		
	}
}