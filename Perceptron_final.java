import java.io.*;
import java.util.*;

public class Test
{
	public static void main(String[] args) throws Exception
	{
		int height = 20;
		int width = 30;
		double learning_Rate = 0.1;
		double[] weights = new double[(height * width) + 1];
		int epoch = 0;
		int training_Size = 131;
		int max_Iterations = 115;

		double[][] file = new double[20][30];
		double label = 8;
		double actual_output = 0;
		String Files="data/trainOthers/"+0+".txt";


		while(epoch < max_Iterations)
		{


			training_Size = 131;
			Files="data/trainOthers/"+0+".txt";
			for (int i = 1; i < training_Size; i++)
			{

				if(Files.contains("trainOthers"))
				{
					Files="data/trainOthers/"+i+".txt";
					label= 3;
				}
				else
				Files="data/train8/"+(i-1)+".txt";

				//System.out.println(Files+"   "+label);
				//Thread.sleep(50);

				if(i==130)
				{
					i=1;
					label = 8;
					training_Size=89;
					Files="data/train8/"+(i)+".txt";
				}

				file       = readFile(Files);
				int output = sum_of_weights(file,weights);


				if (label == 8)
					actual_output = 1;
				else
					actual_output = -1;
				double err = actual_output - output;

				update_weights(file, weights, learning_Rate, err);

			}



		epoch++;
	}//while iteration

	//Evaluation
do{

	Scanner kb = new Scanner(System.in);
	System.out.print("Enter the path to the Image: ");
	String fileName = kb.nextLine();
	double[][] file2 = new double[20][30];

	file2 		  = readFile(fileName);
	double output_Result = sum_of_weights(file2, weights);
	System.out.println(output_Result);

	}while(true);
/*
for(int ff=0;ff<=601; ff++)
{
	System.out.println(weights[ff]);
	Thread.sleep(100);
}
*/





	}// End of Class


	public static double[][] readFile(String fileName)throws Exception
	{
		double[][] file = new double[20][30];
		BufferedReader br = new BufferedReader(new FileReader(fileName));

		for (int g = 0; g < 20; g++)
		{
			for (int j = 0; j < 30; j++)
			{
				file[g][j] = 0;
			}
		}
		for (int g = 0; g < 20; g++)
		{
			String line = br.readLine();
			int size = line.length();

			for (int j = 0; j < size; j++)
			{
				if (String.valueOf(line.charAt(j)).equals("+") || String.valueOf(line.charAt(j)).equals("#"))
				{
					file[g][j] = 1;
				}
				else
					file[g][j] = 0;

			}
		}
		br.close();

		return file;
	}

	public static int sum_of_weights(double[][] file, double[] weights)
	{
		double sum = 0;
		int output = 0;
		int f = 0;
		for (int g = 0; g < 20; g++)
		{
			for (int j = 0; j < 30; j++)
			{
				double dick= file[g][j] * weights[f];
				sum = sum + dick;
				f++;
			}
		}
		if (sum > 0)
		output = 1;
		else
		output = -1;

		return output;
	}

	public static void update_weights(double[][] file, double[] weights, double learning_Rate, double err)
	{
		int f = 0;
		for (int g = 0; g < 20; g++)
		{
			for (int j = 0; j < 30; j++)
			{
				weights[f] = weights[f] + (file[g][j] * learning_Rate * err);


				f++;
			}
		}
		weights[2] = weights[2] + (learning_Rate*err);
	}


}
