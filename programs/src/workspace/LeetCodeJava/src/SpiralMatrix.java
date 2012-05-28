import java.util.*;

public class SpiralMatrix {

	    private enum Dir{TOP, RIGHT, BOTTOM, LEFT}
	    
	    public ArrayList<Integer> spiralOrder(int[][] matrix) {
	        // Start typing your Java solution below
	        // DO NOT write main() function
	        ArrayList<Integer> out=new ArrayList<Integer>();
	        spiralOrder(matrix, 0, 0, matrix.length, matrix[0].length, Dir.TOP, out);
	        return out;
	    }
	    
	    private void spiralOrder(int[][] matrix, int row, int col, int m, int n, Dir d, ArrayList<Integer> out){
	        if(m==0 || n==0)
	            return;
	            
	        switch(d){
	            case TOP:
	                for(int i=0; i<n; i++)
	                    out.add(matrix[row][col+i]);
	                spiralOrder(matrix, row+1, col, m-1, n, Dir.RIGHT, out);
	                break;
	            case RIGHT:
	                for(int i=0; i<m; i++)
	                    out.add(matrix[row+i][col+n-1]);
	                spiralOrder(matrix, row, col, m, n-1, Dir.BOTTOM, out);
	                break;
	            case BOTTOM:
	                for(int i=n-1; i>=0; i--)
	                    out.add(matrix[row+m-1][col+i]);
	                spiralOrder(matrix, row, col, m-1, n, Dir.LEFT, out);
	                break;
	            case LEFT:
	                for(int i=m-1; i>=0; i--)
	                    out.add(matrix[row+i][col]);
	                spiralOrder(matrix, row, col+1, m, n-1, Dir.TOP, out);
	        }
	    }

}
