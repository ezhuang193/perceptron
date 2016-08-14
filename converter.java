package convert;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Converter {

	public static void main(String[] args) throws IOException {

		for(int z = 1; z < 88; z++) {
		String file = "train8/" + z + ".txt";

		@SuppressWarnings("resource")
		BufferedReader br = new BufferedReader(new FileReader(file));
		String line = null;
		List<List<String>> currentTrain8 = new ArrayList<List<String>>();

		while ((line = br.readLine()) != null) {
			List<String> temp = new ArrayList<String>();
			for (int i = 0; i < line.length(); i++) {
				if(line.charAt(i) == ' ') {
					temp.add("0");
					System.out.print('0');
				}
				else {
					System.out.print('1');
					temp.add("1");
				}
			}
			currentTrain8.add(temp);
			System.out.println();
		}
		System.out.println("Done now work your magic");
		//currentTrain8 holds the current training file array

		magic(currentTrain8);

	 }
 }

	private static void magic(List<List<String>> currentTrain8) {
		// TODO Auto-generated method stub

	}
}
