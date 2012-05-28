import java.io.BufferedReader;
import java.io.InputStreamReader;


public class TrapRainWater {

	
    public int trap(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
        int left=0;
        int right=A.length-1;
        int water=0;
        
        while(left<right){
            
            while((left<right)&&A[left]<=A[left+1])
                left++;
                
            while((right>left)&&(A[right]<=A[right-1]))
                right--;
            
            if(left==right)
                return water;
            
            if(A[left]<A[right]){
                int base=A[left];
                left++;
                while(left<right && A[left]<base){
                    water+=base-A[left];
                    left++;
                }
            }else{
                int base=A[right];
                right--;
                while(left<right && A[right]<base){
                    water+=base-A[right];
                    right--;
                }
            }
        }
        
        return water;
    }
    
    
    public static void main(String[] args){
    	
    	TrapRainWater instance = new TrapRainWater();
    	System.out.println(instance.trap(new int[]{1, 0, 2, 3}));
    	
    }
    
}
