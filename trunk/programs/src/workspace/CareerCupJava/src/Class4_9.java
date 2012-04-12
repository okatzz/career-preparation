/*
 * You are given a binary tree in which each node contains a value. Design an algorithm to print all paths which sum up to that value. Note that it can be any path in the tree - it does not have to start at the root.
 */


public class Class4_9 {

	class TreeNode{
		TreeNode left;
		TreeNode right;
		int data;
	}
	
	public static void findSum(TreeNode root, int sum){
		int height = height(root);
		int[] path = new int[height];
		
		findSum(root, path, sum, 0);
	}
	
	private static void findSum(TreeNode n, int[] path, int sum, int level){
		if(n==null)
			return;
		
		path[level]=n.data;
		
		int t=0;
		for(int i=level; i>=0; i--){
			t+=path[i];
			if(t==sum)
				printPath(path, i, level);
		}
		
		findSum(n.left, path, sum, level+1);
		findSum(n.right, path, sum, level+1);
		
		path[level]=Integer.MIN_VALUE;
	}
	
	private static void printPath(int[] path, int start, int end){
		for(int i=start; i<=end; i++)
			System.out.print(path[i]+" ");
		System.out.println();
	}
	
	private static int height(TreeNode n){ //Not exactly the height; is the max no. of nodes on the path
		if(n==null)
			return 0;
		return 1+Math.max(height(n.left), height(n.right));
	}
	
}
