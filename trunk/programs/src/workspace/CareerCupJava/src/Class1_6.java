
public class Class1_6 {
	
	public static void rotateMatrix(double[][] matrix){
		int N = matrix.length;
		for (int i=0; i<N; i++){
			for(int j=i; j<N-i; j++){
				double tmp1 = matrix[i][j];
				double tmp2 = matrix[j][N-i];
				double tmp3 = matrix[N-i][N-j];
				double tmp4 = matrix[N-j][i];
				
				matrix[j][N-i]=tmp1;
				matrix[N-i][N-j]=tmp2;
				matrix[N-j][i]=tmp3;
				matrix[i][j]=tmp1;
			}
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
