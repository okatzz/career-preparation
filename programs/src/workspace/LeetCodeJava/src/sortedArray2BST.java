class sortedArray2BST{
	class Node{
		int data;
		Node left;
		Node right;
		public Node(int d){
			data=d;
		}
	}
	
	public Node sortedArray2BalancedBST(int[] a){
		return sortedArray2BalancedBST(a, 0, a.length-1);
	}
	public Node sortedArray2BalancedBST(int[] a, int start, int end){
		if(start>end)
			return null;
		int mid=(start+end)/2;
		Node root=new Node(a[mid]);
		root.left=sortedArray2BalancedBST(a, start, mid-1);
		root.right=sortedArray2BalancedBST(a, mid+1, end);
		return root;
	}
}