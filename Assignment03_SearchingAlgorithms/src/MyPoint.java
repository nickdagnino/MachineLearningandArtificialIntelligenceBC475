import java.util.ArrayList;

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

	public double findMinX(ArrayList<MyPoint> p) {

		double min = (double) p.get(0).getX();

		int currentPos = 1;

		while (currentPos < p.size()) {

			double value = (double) p.get(currentPos).getX();

			if (value < min) {

				min = value;
				currentPos++;

			}

			currentPos++;

		}

		return min;

	}

	public double findMaxX(ArrayList<MyPoint> p) {

		double max = (double) p.get(0).getX();

		int currentPos = 1;

		while (currentPos < p.size()) {

			double value = (double) p.get(currentPos).getX();

			if (value > max) {

				max = value;
				currentPos++;

			}

			currentPos++;

		}

		return max;
	}

	public double findMinY(ArrayList<MyPoint> p) {

		double min = (double) p.get(0).getY();

		int currentPos = 1;

		while (currentPos < p.size()) {

			double value = (double) p.get(currentPos).getY();

			if (value < min) {

				min = value;
				currentPos++;

			}

			currentPos++;

		}

		return min;
	}

	public double findMaxY(ArrayList<MyPoint> p) {

		double max = (double) p.get(0).getX();

		int currentPos = 1;

		while (currentPos < p.size()) {

			double value = (double) p.get(currentPos).getX();

			if (value > max) {

				max = value;
				currentPos++;

			}

			currentPos++;

		}

		return max;

	}

}
