import java.util.HashSet;


public class LowestCommonAncester {

	class Node{
		Node left;
		Node right;
		int val;
		Node parent;
	}
	
	Node LCA(Node root, int p, int q){
		if(root==null)
			return null;
		if(root.val==p || root.val==q)
			return root;
		Node left=LCA(root.left, p, q);
		Node right=LCA(root.right, p, q);
		if(left!=null && right!=null)
			return root;
		if(left!=null)
			return left;
		return right;
	}
	
	Node LCAByParentLink1(Node root, Node p, Node q){
		HashSet<Node> pathSet=new HashSet<Node>();
		while(p!=null){
			pathSet.add(p);
			p=p.parent;
		}
		while(q!=null){
			if(pathSet.contains(q))
				return q;
			q=q.parent;
		}
		return q;
	}
	
	Node LCAByParentLink2(Node root, Node p, Node q){
		int plength=0;
		int qlength=0;
		Node temp=p;
		while(temp!=null){
			plength++;
			temp=temp.parent;
		}
		temp=q;
		while(temp!=null){
			qlength++;
			temp=temp.parent;
		}
		int diff=plength-qlength;
		if(qlength>plength){
			diff=-diff;
			temp=p;
			p=q;
			q=temp;
		}
		for(int i=0; i<diff; i++)
			p=p.parent;
		while(p!=null && q!=null){
			if(p==q)
				return p;
			p=p.parent;
			q=q.parent;
		}
		return null;
	}
	
	Node LCAInBST1(Node root, Node p, Node q){
		if(root==null || p==null || q==null)
			return null;
		if(p.val>root.val && q.val>root.val)
			return LCAInBST1(root.right, p, q);
		if(p.val<root.val && q.val<root.val)
			return LCAInBST1(root.left, p, q);
		return root;
	}
	
	Node LCAInBST2(Node root, Node p, Node q){
		
		while (true) {
			if (root == null || p == null || q == null)
				return null;
			if (p.val > root.val && q.val > root.val)
				root = root.right;
			else if(p.val<root.val && q.val<root.val)
				root=root.left;
			else
				return root;
		}
	}
}
