import java.io.*;
import java.util.*;

public class Perceptron {
	public static void main(String[] args) throws Exception {
		int height = 20;
		int width = 30;
		double learning_Rate = 0.1;
		double[] weights = new double[(height * width) + 1];
		int epoch = 0;
		int training_Size = 3;
		int max_Iterations = 1;
		// BufferedReader br = new BufferedReader(new FileReader("1.txt"));
		int[][] file = new int[20][30];
		double label = 8;
		double actual_output = 0;


		while(epoch < max_Iterations)
		{
		for (int dumb = 0; dumb < 2; dumb++) {
			if (dumb == 1) {
				training_Size = 130;
				label = 3;
			}
			for (int i = 1; i < training_Size; i++) {
				String files = "data/train8/" + i + ".txt";

				if(dumb == 1) {
					files = "data/trainOthers/" + i + ".txt";
				}

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
				br.close();

				int f = 0;
				double sum = 0;
				double output = 0;
				for (int g = 0; g < 20; g++) {
					for (int j = 0; j < 30; j++) {
						weights[f] = file[g][j] * weights[f];
						sum = sum + weights[f];
						f++;
					}
				}

				if (sum > 0)
					output = 1;
				else
					output = -1;

				if (label == 8)
					actual_output = 1;
				else
					actual_output = -1;

				double err = actual_output - output;

				f = 0;
				for (int g = 0; g < 20; g++) {
					for (int j = 0; j < 30; j++) {
						weights[f] = weights[f] + (file[g][j] * learning_Rate * err);
						f++;
					}
				}

			}
		}

		epoch++;
	}//while iteration

/*
	//Evaluation

	Scanner kb = new Scanner(System.in);
	System.out.print("Enter the path to the Image: ");
	String fileName = kb.nextLine();
	BufferedReader br2 = new BufferedReader(new FileReader(fileName));


	for (int g = 0; g < 20; g++)
	{
		for (int j = 0; j < 30; j++)
		{
			file[g][j] = 0;
		}
	}

	for (int g = 0; g < 20; g++)
	{
		String line2 = br2.readLine();
		int size= line2.length();

		for (int j = 0; j < size; j++)
		{
			if(String.valueOf(line2.charAt(j)).equals("+") || String.valueOf(line2.charAt(j)).equals("#"))
			{
				file[g][j] = 1;
			}
			else
			file[g][j] = 0;
		}
	}
	br2.close();

	int f2 = 0;
	double sum2 = 0;
	double output2 = 0;
	for (int g = 0; g < 20; g++)
	{
		for (int j = 0; j < 30; j++)
		{
			weights[f2]=file[g][j] * weights[f2];
			sum2 = sum2 + weights[f2];
						f2++;
		}
	}

	if(sum2>0)
	output2=1;
	else
	output2=-1;

	System.out.println(sum2);


*/
int f2=0;
for (int g = 0; g < 20; g++)
	{
		for (int j = 0; j < 30; j++)
		{
			System.out.println(weights[f2]);
			f2++;
		}
	}


	}// End of Class
}
