
public class Triangle extends Shape2D{
	private String name;
	private double length;
	private double height;
	
	public Triangle() {
		this(1,1);
	}
	
	public Triangle(double length, double height) {
		this.length = length;
		this.height = height;
		this.name = "triangle";
	}
	
	@Override
	public double getArea() {
		return (length*height)/2.00;
	}
	
	@Override
	public String getName() {
		return name;
	}

}
