import java.util.ArrayList;

public class class9_9{
	ArrayList<Integer[]> results = new ArrayList<Integer[]>();
	public void eightQuenes(int row, Integer[] cols){
		if(row==8){
			results.add(cols.clone());
			return;
		}else{
			for(int i=0; i<8; i++){
				cols[row]=i;
				if(checkValid(row, cols)){
					eightQuenes(row+1, cols);
				}
				cols[row]=-1;
			}
		}
	}
	
	boolean checkValid(int row, Integer[] cols){
		for(int i=0; i<row; i++){
			if(cols[i]==cols[row])
				return false;
			if((row-i)==Math.abs(cols[row]-cols[i]))
				return false;
		}
		return true;
	}
}