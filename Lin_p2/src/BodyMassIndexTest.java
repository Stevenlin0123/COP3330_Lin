import java.util.ArrayList;


public class BodyMassIndexTest{

	public static void main(String[] args) 
	{
		Double[] height = new Double[] {68.9, 75.0, 65.4, 66.7};
		
		Double[] weight = new Double[] {150.0, 232.1, 110.4, 330.7};
		
		for(int i=0; i<4;i++)
		{
			double a = height[i];
			
			BodyMassIndex bmi = new BodyMassIndex(height[i], weight[i]);
			
			displayBmiInfo(bmi);
		}

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

}