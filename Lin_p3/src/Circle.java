
public class Circle extends Shape2D{
	
	private double radius;
	private String name;
	
	public Circle() {
		this(1);
	}
	
	public Circle(double radius)
	{
		this.radius = radius;
		this.name = "circle";
	}
	
	@Override
	public double getArea() {
		return Math.PI * Math.pow(radius, 2);
	}
	
	@Override
	public String getName() {
		return name;
	}

}
