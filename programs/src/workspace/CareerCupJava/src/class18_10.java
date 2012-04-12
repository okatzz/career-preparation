/*
 * Imagine you have a square matrix, where each cell is filled with either black or white. Design an algorithm to find the maximum subsquare such that all four borders are filled with black pixels.
 */

class 18_10{
	class Square{
		int x1;
		int y1;
		int x2;
		int y4;
		public Square(int x1, int y1, int x2, int y2){
			this.x1=x1;
			this.y1=y1;
			this.x2=x2;
			this.y2=y2;
		}
	}
	public Square maxSubsquare(boolean[][] matrix){
		for(int i=matrix.length; i>=1; i--){
			Square sq=findSquareWithSize(matrix, i);
			if(sq!=null)
				return sq;
		}
		return null;
	}
	
	public Square findSquareWithSize(boolean[][] matrix, int l){
		for(int i=0; i<=matrix.length-l; i++){
			for(int j=0; j<=matrix.length-l; j++){
				Square sq=new Square(i, j, i+l-1, j+l-1);
				if(isSquare(matrix, sq))
					return sq;
			}
		}
		return null;
	}
	
	public boolean isSquare(boolean[][] matrix, Square sq){
		for(int i=sq.x1; i<=sq.x2; i++){
			if(!matrix[i][y1]||!matrix[i][y1])
				return false;
		}
		for(int i=sq.y1; i<=sq.y2; i++){
			if(!matrix[x1][i]||!matrix[x2][i])
				return false;
		}
		return true;
	}
}

class 18_10_2{
	class Square{
		int x1;
		int y1;
		int x2;
		int y2;
		Square(int x1, int y1, int x2, int y2){
			this.x1=x1;
			this.y1=y1;
			this.x2=x2;
			this.y2=y2;
		}
	}
	
	class SquareCell{
		int rightZeros;
		int downZeros;
		SquareCell(int right, int down){
			rightZeros=right;
			downZeros=down;
		}
	}
	
	public SquareCell[][] preprocess(int[][] matrix){
		SquareCell[][] processed=new SquareCell[matrix.length][matrix.length];
		for(int i=0; i<matrix.length; i++)
			processed[i]=new SquareCell[matrix.length];
		for(int i=matrix.length-1; i>=0; i--){
			for(int j=matrix.length-1; j>=0; j--){
				if(matrix[i][j]==1){
					processed[i][j].rightZeros=0;
					processed[i][j].downZeros=0;
				}else{
					if(j==matrix.length-1)
						processed[i][j].rightZeros=1;
					else
						processed[i][j].rightZeros=processed[i][j+1].rightZeros+1;
					if(i==matrix.length-1)
						processed[i][j].downZeros=1;
					else
						processed[i+1][j].downZeros=processed[i+1][j].downZeros+1;
				}
			}
		}
		return processed;
	}
	
	public Square findMaxSquare(int[][] matrix){
		SquareCell[][] processed=preprocess(matrix);
		for(int i=matrix.length; i>=1; i--){
			Square sq=findSquareWithSize(processed, i);
			if(sq!=null)
				return sq;
		}
		return null;
	}
	
	public Square findSquareWithSize(SquareCell[][] processed, int size){
		for(int i=0; i<=processed.length-size+1; i++){
			for(int j=0; j<=processed.length-size+1; j++){
				Square sq=new Square(i, j, i+size-1, j+size-1);
				if(isSquare(processed, sq))
					return sq;
			}
		}
		return null;
	}
	
	boolean isSquare(SquareCell[][] processed, Square sq){
		int length=sq.x2-sq.x1+1;
		if(processed[sq.x1][sq.y1].rightZeros>=length&&processed[sq.x2][sq.y1].rightZeros>=length&&processed[sq.x1][sq.y2].downZeros>=length&&processed[sq.x2][sq.y2].downZeros>=length)
			return true;
		return false;
	}
	
}