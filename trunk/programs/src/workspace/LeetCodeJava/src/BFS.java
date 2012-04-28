import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;

class BFS{
	class Node{
		int value;
		Node left;
		Node right;
	}
	
	public void printNodesInLevels(Node root){
		if(root==null)
			return;
		LinkedList queue=new LinkedList<Node>();
		Node dummy=new Node();
		queue.add(root);
		queue.add(dummy);
		while(!queue.isEmpty()){
			Node temp=(Node) queue.remove();
			if(temp==dummy){
				System.out.println();
				if(queue.isEmpty())
					break;
				queue.add(temp);
			}else{
				System.out.print(temp.value);
				if(temp.left!=null)
					queue.add(temp.left);
				if(temp.right!=null)
					queue.add(temp.right);
			}
		}
	}
}
