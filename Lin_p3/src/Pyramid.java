
public class Pyramid extends Shape3D{
	private double h;
	private double l;
	private double w;
	private String name;
	
	
	
	public Pyramid() {
		this(1, 1, 1);
	}
	
	public Pyramid(double l, double w, double h) {
		this.name = "pyramid";
		this.h = h;
		this.l = l;
		this.w = w;
	}
	
	@Override
	public double getArea() {
		return (l*w) + (l*Math.sqrt(Math.pow(w/2, 2) + Math.pow(h, 2))) + (w * Math.sqrt(Math.pow(l/2, 2) + Math.pow(h, 2)));
	}
	
	@Override
	public String getName() {
		return name;
	}
	
	@Override
	public double getVolume() {
		return (l*w*h)/3;
	}

}
