import java.util.ArrayList;

public class City {

	private String name;
	private MyPoint point;
	ArrayList<Neighbor> neighbors;

	public City(String n, MyPoint p, ArrayList<Neighbor> near) {

		name = n;
		point = p;
		neighbors = near;

	}

	public String getName() {

		return name;

	}

	public MyPoint getPoint() {

		return point;

	}

	public ArrayList<Neighbor> getNeighbors() {

		return neighbors;

	}

}
