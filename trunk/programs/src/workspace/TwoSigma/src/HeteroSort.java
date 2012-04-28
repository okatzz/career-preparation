import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HeteroSort {

	public static void main(String[] args) {

		// open up standard input
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String line = "";

		// read in input list of strings
		try {
			line = in.readLine();
		} catch (IOException ioe) {
			System.out.println("IO error trying to read the input!");
			System.exit(1);
		}

		// put integers and words into two separate lists; keep track of the
		// index/location of integers in the input sequence
		ArrayList<Integer> intIndex = new ArrayList<Integer>(); // the index of
																// integers in
																// the input
																// sequence
		List<Integer> ints = new ArrayList<Integer>(); // integer list
		List<String> strings = new ArrayList<String>(); // word list
		String[] elements = line.split("\\s+");
		for (int i = 0; i < elements.length; i++) {
			int value = 0;
			boolean isValue = true;
			try {
				value = Integer.parseInt(elements[i]);
			} catch (Exception e) {
				isValue = false;
			}

			if (isValue) {
				ints.add(value);
				intIndex.add(i);
			} else {
				strings.add(elements[i]);
			}
		}

		// sort the integer list and work list
		Collections.sort(ints);
		Collections.sort(strings);

		// combine the two lists and output the sorting result
		int intI = 0;
		int stringI = 0;
		int indexI = 0;

		for (int i = 0; i < elements.length; i++) {
			if (i != 0)
				System.out.print(" ");

			if (intIndex.size() > indexI && i == intIndex.get(indexI)) {
				System.out.print(ints.get(intI));
				intI++;
				indexI++;
			} else {
				System.out.print(strings.get(stringI));
				stringI++;

			}
		}
	}

}
