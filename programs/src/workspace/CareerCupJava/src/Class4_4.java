/*
 * Given a binary search tree, design an algorithm which creates a linked list of all the nodes at each depth (i.e., if you have a tree with depth D, you’ll have D linked lists).
 */

import java.util.*;

public class Class4_4 {

	class TreeNode{
		TreeNode left;
		TreeNode right;
		int value;
	}
	
	public static ArrayList<LinkedList<TreeNode>> createLevelLinkedList(TreeNode root){
		
		ArrayList<LinkedList<TreeNode>> lists = new ArrayList<LinkedList<TreeNode>>();
		createLevelLinkedList(root, lists, 0);
		
		
		return lists;
		
	}

	private static void createLevelLinkedList(TreeNode root,
			ArrayList<LinkedList<TreeNode>> lists, int depth) {
		
		if(root==null)
			return;
		
		if(depth>=lists.size()){
			LinkedList<TreeNode> list = new LinkedList<TreeNode>();
			lists.set(depth, list);
		}
		lists.get(depth).add(root);
		
		createLevelLinkedList(root.left, lists, depth+1);
		createLevelLinkedList(root.right, lists, depth+1);
	}
	
	public static ArrayList<LinkedList<TreeNode>> createLevelLinkedList2(TreeNode root){
		ArrayList<LinkedList<TreeNode>> lists = new ArrayList<LinkedList<TreeNode>>();
		
		LinkedList<TreeNode> current = new LinkedList<TreeNode>();
		if(root!=null)
			current.add(root);
		
		while(!current.isEmpty()){
			lists.add(current);
			LinkedList<TreeNode> parents = current;
			current = new LinkedList<TreeNode>();
			for (TreeNode treeNode : parents) {
				if(treeNode.left!=null)
					current.add(treeNode.left);
				if(treeNode.right!=null)
					current.add(treeNode.right);
			}
		}
		
		return lists;
	}
	
}
