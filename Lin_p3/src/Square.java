
public class Square extends Shape2D{
	
	private String name;
	private double side;
	
	
	public Square() {
		this(1);
	}

	public Square(double length) {
		this.side = length;
		this.name = "square";
		
	}
	
	@Override
	public double getArea()
	{
		return side*side;
	}
	
	@Override
	public String getName()
	{
		return name;
	}
}
