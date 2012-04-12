/*
 * Implement a function to check if a tree is balanced. For the purposes of this question, a balanced tree is defined to be a tree such that no two leaf nodes differ in distance from the root by more than one.
 */
public class Class4_1 {
	
	class TreeNode{
		TreeNode left;
		TreeNode right;
		int value;
	}
	
	public static int checkHeight(TreeNode root){
		if(root==null)
			return 0;
		
		int leftHeight = checkHeight(root.left);
		if(leftHeight==-1)
			return -1;
		int rightHeight = checkHeight(root.right);
		if(rightHeight==-1)
			return -1;
		if(Math.abs(leftHeight-rightHeight)>1)
			return -1;
		
		return Math.max(leftHeight, rightHeight)+1;
	}
	
	public static boolean isBalanced2(TreeNode root){
		if(checkHeight(root)==-1)
			return false;
		return true;
	}
	
	
	
}
