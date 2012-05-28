import java.util.Arrays;


public class NextPermutation {

    public void nextPermutation(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int i;
        for(i=num.length-2; i>=0; i--){
            if(num[i]<num[i+1])
                break;
        }
        if(i>=0){
            int j;
            for(j=num.length-1; j>i; j--){
                if(num[j]>num[i])
                    break;
            }
            int temp=num[j];
            num[j]=num[i];
            num[i]=temp;
        }
        i++;
        int j=num.length-1;
        while(i<j){
            int temp=num[i];
            num[i]=num[j];
            num[j]=temp;
            i++;
            j--;
        }
        
    }

	
	public static void main(String[] args){
		int[] num=new int[]{1,3,2};
		new NextPermutation().nextPermutation(num);
		System.out.println(Arrays.toString(num));
	}
}

