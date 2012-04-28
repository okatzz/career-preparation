import java.util.ArrayList;
import java.util.HashMap;


public class StrStr {

	class SuffixTree{
		SuffixTreeNode root = new SuffixTreeNode();
	}
	
	class SuffixTreeNode{
		
		char c;
		ArrayList<Integer> indice = new ArrayList<Integer>();
		HashMap<Character, SuffixTreeNode> children = new HashMap<Character, SuffixTreeNode>();
		
		public SuffixTreeNode(){
			
		}
		public SuffixTreeNode(char c, int index){
			this.c = c;
			indice.add(index);
		}
		
		public ArrayList<Integer> getIndice(){
			return indice;
		}
		
		public void insertString(String s, int index){
			char data = s.charAt(0);
			SuffixTreeNode child;
			if(children.containsKey(data)){
				child = children.get(s.charAt(0));
			}else{
				child = new SuffixTreeNode(data, index);
				children.put(data, child);
			}
			if(s.length()>1)
				child.insertString(s.substring(1), index);
		}
		
		public ArrayList<Integer> search(String s){
			char c = s.charAt(0);
			if(children.containsKey(c)){
				if(s.length()==1){
					return children.get(c).getIndice();
				}else{
					return children.get(c).search(s.substring(1));
				}
			}
			else{
				return null;
			}
		}
		
	}
	
}
