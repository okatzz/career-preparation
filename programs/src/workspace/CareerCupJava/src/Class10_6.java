
public class Class10_6 {

	public Coordinate findInSortedMatrix(int[][] matrix, int value){
		Coordinate coordinate = new Coordinate(0, matrix[0].length);
		while(coordinate.x<matrix.length&&coordinate.y>=0){
			if(value==matrix[coordinate.x][coordinate.y]){
				return coordinate;
			}
			if(value<matrix[coordinate.x][coordinate.y]){
				coordinate.y--;
			}else{
				coordinate.x++;
			}
		}
		coordinate.x=-1;
		coordinate.y=-1;
		return coordinate;
	}
	
}

class Coordinate implements Cloneable{
	
	int x;
	int y;

	public Coordinate(int x, int y){
		this.x=x;
		this.y = y;
	}
	
}