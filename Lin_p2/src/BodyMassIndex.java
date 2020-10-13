
public class BodyMassIndex {
	
	double bmiScore;

	public BodyMassIndex(double height, double weight) 
	{
		this.bmiScore = (703 * (weight)) / (Math.pow(height, 2));
	}	

}
