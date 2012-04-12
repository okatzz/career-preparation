import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;;

/*
 * Write a method to sort an array of strings so that all the anagrams are next to each other.
 */
public class Class10_2 {

	public void sort1(String[] strings){
		Arrays.sort(strings, new AnagramComparator());
	}
	
	public void sort2(String[] strings){
		HashMap<String, LinkedList<String>> map=new HashMap<String, LinkedList<String>>();
		for(String str: strings){
			LinkedList<String> list=map.get(AnagramComparator.sortChar(str));
			if(list==null){
				list=new LinkedList<String>();
				map.put(AnagramComparator.sortChar(str), list);
			}
			list.add(str);
		}
		int index=0;
		for(LinkedList<String> list:map.values()){
			for(String str:list){
				strings[index++]=str;
			}
		}
	}
	
	public static void main(String[] args){
		
	}
	
}

class AnagramComparator implements Comparator<String>{

	public static String sortChar(String str){
		char[] chars=str.toCharArray();
		Arrays.sort(chars);
		return new String(chars);
	}
	
	@Override
	public int compare(String s1, String s2){
		return sortChar(s1).compareTo(sortChar(s2));
	}
	
}
