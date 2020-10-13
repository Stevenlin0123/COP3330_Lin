import java.util.ArrayList;
import java.util.Scanner;

public class App {

	public static void main(String[] args) 
	{
		ArrayList<BodyMassIndex> bmiData = new ArrayList<BodyMassIndex>();
		while (moreInput()) 
		{
			double height = getUserHeight();
			double weight = getUserWeight();
			
			BodyMassIndex bmi = new BodyMassIndex(height, weight);
			bmiData.add(bmi);
			
			displayBmiInfo(bmi);
		}

    displayBmiStatistics(bmiData);
	}
	
	
	
	
	
	public static void displayBmiStatistics(ArrayList<BodyMassIndex> bmiData) 
	{
		double average;
		double sum = 0;
		int count = 0;
		for(BodyMassIndex i : bmiData)
		{
			sum = sum + i.bmiScore;
			count++;
		}
		
		average = (sum)/(count);
		
		System.out.println("Average BMI score of the data is: " + average);
	}





	public static void displayBmiInfo(BodyMassIndex bmi) 
	{
		System.out.println("Your BMI is: ");
		
		if(bmi.bmiScore >= 30)
		{
			System.out.println(bmi.bmiScore);
			System.out.println("Obesity");
		}
		else if(bmi.bmiScore <= 29.9 && bmi.bmiScore >= 25) 
		{
			System.out.println(bmi.bmiScore);
			System.out.println("Overweight");
		}
		else if(bmi.bmiScore <= 24.9 && bmi.bmiScore >=18.5)
		{
			System.out.println(bmi.bmiScore);
			System.out.println("Normal weight");
		}
		else 
		{
			System.out.println(bmi.bmiScore);
			System.out.println("Underweight");
		}
		System.out.println("");
	}





	public static boolean moreInput() 
	{
		Scanner in = new Scanner(System.in);
		System.out.println("Do you have another input? Y or N.");
		char ans = in.next().charAt(0);
		boolean a = false;
		in.nextLine();
		
		if(ans == 'Y')
		{
			a = true;
		}
		else if(ans == 'N')
		{
			a = false;
		}
		else 
		{
			System.out.println("Unknown input. Try again.");
			moreInput();
		}
		
		
		return a;
	}



	public static double getUserHeight()
	{
		double inches;
		Scanner in = new Scanner(System.in);
		System.out.println("Enter height(in inches): ");
		inches = in.nextDouble();
		in.nextLine();
		if(inches < 0)
		{
			System.out.println("Please try a positive number.");
			inches = in.nextDouble();
		}
		
		return inches;
	}
	
	public static double getUserWeight()
	{
		double pounds;
		Scanner in = new Scanner(System.in);
		System.out.println("Enter Weight(in pounds): ");
		pounds = in.nextDouble();
		
		if(pounds < 0)
		{
			System.out.println("Please try a positive number.");
			pounds = in.nextDouble();
		}
		
		return pounds;
	}
	
	
}