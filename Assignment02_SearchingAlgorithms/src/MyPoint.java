
public class MyPoint {

	private double x;
	private double y;
	private double z;

	public MyPoint(double pX) {
		x = pX;
	}

	public MyPoint(double pX, double pY) {
		x = pX;
		y = pY;
	}

	public MyPoint(double pX, double pY, double pZ) {
		x = pX;
		y = pY;
		z = pZ;
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public double getZ() {
		return z;
	}

}
