import java.util.HashMap;



class buildTreeFromInorderPreorder{
	
	class TreeNode{
		TreeNode left;
		TreeNode right;
		int value;
	}
	
	HashMap<Integer, Integer> value2Index = new HashMap<Integer, Integer>();
	
	public void value2IndexMap(int[] inorder){
		for(int i=0; i<inorder.length; i++){
			value2Index.put(i, inorder[i]);
		}
	}
	
	public TreeNode buildTreeFromInoderPreorder(int[] inorder, int[] preorder, int length, int instart, int prestart){
		
		if(length==0)
			return null;
		
		TreeNode root=new TreeNode();
		root.value=preorder[prestart];
		int inIdx=value2Index.get(root.value);
		root.left=buildTreeFromInoderPreorder(inorder, preorder, inIdx-instart, instart, prestart+1);
		root.right=buildTreeFromInoderPreorder(inorder, preorder, length-inIdx+instart-1, inIdx+1, prestart+inIdx-instart);
		
		return root;
		
	}
}