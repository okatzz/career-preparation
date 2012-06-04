
public class Class18_1 {

	public String addBinary(String a, String b) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(a==null || b==null || a.isEmpty() || b.isEmpty())
            return new String("0");
        boolean hasOne=false;
        for(int i=0; i<b.length(); i++)
            if(b.charAt(i)=='1')
                hasOne=true;
        if(!hasOne){
            StringBuilder temp=new StringBuilder();
            int i=0;
            while(a.charAt(i)=='0')
                i++;
            if(i==a.length())
                temp.append('0');
            while(i<a.length()){
                temp.append(a.charAt(i));
                i++;
            }
            return temp.toString();
        }
        if(a.length()<b.length()){
            String temp=a;
            a=b;
            b=temp;
        }
        StringBuilder xor=new StringBuilder();
        int diff=(a.length()-b.length());
        for(int i=0; i<diff; i++)
            xor.append(a.charAt(i));
        for(int i=0; i<b.length(); i++)
            xor.append((a.charAt(diff+i)-'0')^(b.charAt(i)-'0'));
        StringBuilder carry=new StringBuilder();
        for(int i=0; i<b.length(); i++)
            carry.append((a.charAt(diff+i)-'0')&(b.charAt(i)-'0'));
        carry.append('0');
        return addBinary(xor.toString(), carry.toString());
    }
	
	public int addNumbers(int a, int b){
		if(b==0)
			return a;
		int sum=a^b;
		int carry=a&b;
		return addNumbers(sum, carry<<1);
	}
	
}
