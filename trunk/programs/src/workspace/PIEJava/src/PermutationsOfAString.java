
public class PermutationsOfAString {
	
	public static void permutation(String str){
		boolean[] used=new boolean[str.length()];
//		StringBuilder out=new StringBuilder();
		char[] out=new char[str.length()];
		doPermute(str, used, out, 0);
	}
	
//	public static void doPermute(String str, boolean[] used, StringBuilder out, int level){
	public static void doPermute(String str, boolean[] used, char[] out, int level){

		if(level==str.length()){
//			System.out.println(out.toString());
			System.out.println(out);
			return;
		}
		for(int i=0; i<used.length; i++){
			if(!used[i]){
//				out.append(str.charAt(i));
				out[level]=str.charAt(i);
				used[i]=true;
				doPermute(str, used, out, level+1);
//				out.setLength(out.length()-1);
				used[i]=false;
			}
		}
	}
	
	public static void main(String[] args){
		permutation("abcd");
	}

}
