
public class Cube extends Shape3D{
	private double side;
	private String name;
	
	public Cube() {
		this(1);
	}
	
	public Cube(double side) {
		this.name = "cube";
		this.side = side;
	}
	
	@Override
	public double getArea() {
		return 6*side*side;
	}
	
	@Override
	public String getName() {
		return name;
	}
	
	@Override
	public double getVolume() {
		return Math.pow(side, 3);
	}

}
