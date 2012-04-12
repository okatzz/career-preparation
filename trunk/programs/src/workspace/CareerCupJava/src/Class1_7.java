
public class Class1_7 {
	
	public static void zeroRowAndCol(int[][] matrix){
		boolean[] rows = new boolean[matrix.length];
		boolean[] cols = new boolean[matrix[0].length];
		
		for(int i=0; i<matrix.length; i++){
			for(int j=0; j<matrix[0].length; j++){
				if(matrix[i][j]==0){
					rows[i]=true;
					cols[j]=true;
				}
			}
		}
		
		for(int i=0; i<matrix.length; i++){
			for(int j=0; j<matrix[0].length; j++){
				if(rows[i] || cols[j])
					matrix[i][j]=0;
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
