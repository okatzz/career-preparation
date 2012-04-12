/*
 * Implement a function to check if a binary tree is a binary search tree
 */
import java.util.*;

public class Class4_5 {

	class TreeNode{
		TreeNode left;
		TreeNode right;
		int data;
	}
	
	public static boolean checkBST(TreeNode root){
		
		ArrayList<Integer> array = new ArrayList<Integer>();
		copyBST(root, array);
		
		for(int i=0; i<array.size()-1; i++)
			if(array.get(i)>array.get(i+1))
				return false;
		return true;
	}
	
	public static void copyBST(TreeNode root, ArrayList<Integer> array){
		if(root==null)
			return;
		copyBST(root.left, array);
		array.add(root.data);
		copyBST(root.right, array);
	}
	
	
	private static int last_visited=Integer.MIN_VALUE;
	public static boolean checkBST2(TreeNode n){
		
		if(n==null)
			return true;
		
		if(!checkBST(n.left))
			return false;
		if(last_visited>n.data)
			return false;
		last_visited=n.data;
		if(!checkBST2(n.right))
			return false;
		
		return true;
	}
	
	public static boolean checkBST3(TreeNode n){
		return checkBST(n, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	private static boolean checkBST(TreeNode n, int minValue, int maxValue) {
		
		if(n==null)
			return true;
		
		if(n.data<minValue || n.data>maxValue)
			return false;
		
		if(!checkBST(n.left, minValue, n.data) || !checkBST(n.right, n.data, maxValue))
			return false;
		
		return true;
	}
	
}
