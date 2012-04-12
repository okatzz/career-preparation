/*
 *Given an NxN matrix of positive and negative integers, write code to find the sub-matrix with the largest possible sum.
 */

class Class18_12{
	
	//O(N^3 solution)
	public int maxSubMatrx(int[][] matrix){
		int[][] processed=preprocess(matrix);
		int maxSum=INTEGER.MIN_VALUE;
		for(int i=0; i<matrix.length; i++)
			for(int j=i; j<matrix.length; j++)
				for(int m=0; m<matrix[0].length; m++)
					for(int n=m; n<matrix[0].length; n++){
						int runningSum=processed[j][n]-processed[j][m]-processed[i][n]+processed[i][m];
						maxSum=Math.max(maxSum, runningSum);
					}
		return maxSum;
	}
	
	public int[][] preprocess(int[][] matrix){
		int[][] process=new int[matrix.length][matrix[0].length];
		for(int i=0; i<matrix.length; i++){
			for(int j=0; j<matrix[0].length; j++){
				if(i==0&&j==0)
					process[i][j]=matrix[i][j];
				else if(i==0){
					process[i][j]=process[i][j-1];
				}else if(j==0){
					process[i][j]=process[i-1][j];
				}else{
					process[i][j]=process[i][j-1]+process[i-1][j]-process[i-1][j-1];
				}
			}
		}
		return process;
	}
	
	
}

