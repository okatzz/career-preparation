import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;


public class ACME {
	int num;
	ArrayList<HashSet<Integer>> centers;

	public ACME(){
		num=0;
		centers = new ArrayList<HashSet<Integer>>();
	}
	
	// read in the data sets each data center has initially
	public void init() throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String line;
		line=in.readLine();
		if(line.trim().length()!=0)
			num=Integer.parseInt(line.trim());
		for(int i=0; i<num; i++){
			HashSet<Integer> datasets = new HashSet<Integer>();
			line=in.readLine();
			if(line.trim().length()!=0){
				String[] strs=line.trim().split("\\s+");
				for(String s: strs){
					if(s.trim().length()!=0){
						datasets.add(new Integer(s.trim()));
					}
				}
			}
			centers.add(datasets);
		}
		
		
		
	}
	
	// synchronize data sets and output operations
	public void Synchronize(){
		for(int i=0; i<centers.size(); i++){
			HashSet<Integer> datasets = centers.get(i);
			for(int j=0; j<centers.size(); j++){
				if(j!=i){
					HashSet<Integer> other = centers.get(j);
					for (Iterator iterator = other.iterator(); iterator
							.hasNext();) {
						Integer data = (Integer) iterator.next();
						if(!datasets.contains(data)){
							System.out.println(data + " " + (j+1) + " " + (i+1));
							datasets.add(data);
						}
					}
				}
			}
		}
		System.out.println("done");
	}
	
	
	public static void main(String[] args) throws IOException{
		ACME acme= new ACME();
		acme.init();
		acme.Synchronize();
	}
	
	
	
}
