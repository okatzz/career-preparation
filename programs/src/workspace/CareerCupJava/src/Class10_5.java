
public class Class10_5 {

	
	public int getLocation(String[] strings, String str, int first, int last){
		if(first<0 || last>strings.length || first>last)
			return -1;
		
		int mid=(first+last)/2;
		if(strings[mid].isEmpty()){
			int left=mid-1;
			int right=mid+1;
			while(true){
				if(left<first && right>last)
					return -1;
				else if(left>=first && !strings[left].isEmpty()){
					mid=left;
					break;
				}else if(right>=last && !strings[right].isEmpty()){
					mid=right;
					break;
				}
				left--;
				right++;
			}
		}
		
		if(str.compareTo(strings[mid])<0)
			return getLocation(strings, str, first, mid-1);
		if(str.compareTo(strings[mid])>0)
			return getLocation(strings, str, mid+1, last);
		return mid;
	}
	
}
