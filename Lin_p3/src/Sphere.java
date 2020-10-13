
public class Sphere extends Shape3D{
	private String name;
	private double radius;
	
	
	public Sphere() {
		this(1);
	}
	
	public Sphere(double radius) {
		this.name = "sphere";
		this.radius = radius;
	}
	
	@Override
	public double getArea() {
		return 4 * Math.PI * Math.pow(radius, 2);
	}
	
	@Override
	public String getName() {
		return name;
	}
	
	@Override
	public double getVolume() {
		return (4/3.00) * Math.PI * Math.pow(radius, 3);
	}

}
