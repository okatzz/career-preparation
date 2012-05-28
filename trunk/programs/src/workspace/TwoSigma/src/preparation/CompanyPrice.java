package preparation;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class CompanyPrice {

	void getEarliestPrice() throws IOException{
		HashMap<String, ArrayList<Record>> table = new HashMap<String, ArrayList<Record>>();
		BufferedReader in = new BufferedReader(new FileReader("test.txt"));
		String line;
		while((line=in.readLine())!=null){
			line=line.trim();
			if(!line.isEmpty()){
				String[] strs=line.split(",\\s");
				ArrayList<Record> list = table.get(strs[0]);
				
			}
		}
	}
	
}

class Record{
	Date time;
	int price;
	Record(String t, int p) throws ParseException{
		DateFormat formatter = new SimpleDateFormat("HH:mm");
		time = formatter.parse(t);
		price = p;
	}
}