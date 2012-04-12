/*
 * Lowest Common Ancestor
 * Given the value of two nodes in a binary search tree, find the lowest (nearest) common ancestor. You may assume that both values already exist in the tree.
 */
import java.util.ArrayList;
import java.util.List;

public class LowestCommonAncestor {

	class Node{
		Node left;
		Node right;
		int value;
	}
	
	public Node getLowestCommonAncestor(Node root, int value1, int value2){
		while(root!=null){
			if(root.value<value1 && root.value<value2)
				root=root.right;
			else if(root.value>value1 && root.value>value2)
				root=root.left;
			else
				return root;
		}
		return null;
	}
	
	public Node getLowestCommonAncestor2(Node root, int value1, int value2){
		List<Node> path1=new ArrayList<Node>();
		List<Node> path2=new ArrayList<Node>();
		
		Node temp = root;
		while(temp!=null && temp.value!=value1){
			path1.add(temp);
			if(value1<temp.value)
				temp=temp.left;
			else
				temp=temp.right;
		}
		
		temp = root;
		while(temp!=null && temp.value!=value2){
			path2.add(temp);
			if(value2<temp.value)
				temp=temp.left;
			else
				temp=temp.right;
		}
		
		int length1=path1.size();
		int length2=path2.size();
		
		int i;
		for(i=0; i<length1&&i<length2; i++){
			if(i==length1 || i==length2 || path1.get(i+1).value!=path2.get(i+1).value)
				break;
		}
		
		return path1.get(i);
	}
	
}
