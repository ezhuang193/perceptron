package convert;

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		int height = 20;
		int width = 30;
		double learning_Rate = 0.1;
		double[] weights = new double[(height * width) + 1];
		int epoch = 0;
		int training_Size = 88;
		int max_Iterations = 100;
		//BufferedReader br = new BufferedReader(new FileReader("train8/1.txt"));
		int[][] file = new int[20][30];

		/*
		 * // prints the file after being modified for (int i = 0; i < 20; i++)
		 * { for (int j = 0; j < 30; j++) { System.out.print(file[i][j]); }
		 * System.out.println(); }
		 */

		
			for (int i = 1; i < training_Size; i++) {
				String files = "train8/" + i + ".txt";
				BufferedReader br = new BufferedReader(new FileReader(files));

				// Reads File and saves in aray
				for (int g = 0; g < 20; g++) {
					for (int j = 0; j < 30; j++) {
						file[g][j] = 0;
					}
				}

				for (int g = 0; g < 20; g++) {
					String line = br.readLine();
					int size = line.length();

					for (int j = 0; j < size; j++) {
						if (String.valueOf(line.charAt(j)).equals("+") || String.valueOf(line.charAt(j)).equals("#")) {
							file[g][j] = 1;
						} else
							file[g][j] = 0;
					}
				}

				
				
				
			} // End of for
			epoch++;
		
	}
}