/*
 * Write an algorithm to find the ‘next’ node (i.e., in-order successor) of a given node in a binary search tree where each node has a link to its parent.
 */
public class Class4_6 {

	class TreeNode{
		TreeNode left;
		TreeNode right;
		int data;
		TreeNode parent;
	}
	
	public TreeNode inorderSuccessor(TreeNode n){
		if(n==null)
			return null;
		TreeNode successor=null;
		if(n.right!=null){
			successor=n.right;
			while(successor.left!=null)
				successor=successor.left;
		}else{
			TreeNode current=n;
			while(current.parent!=null&&current.parent.left!=current)
				current=current.parent;
			successor=current.parent;
		}
		return successor;
	}
	
}
