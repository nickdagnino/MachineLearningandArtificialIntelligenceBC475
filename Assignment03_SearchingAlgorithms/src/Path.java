import java.util.ArrayList;

public class Path {

	ArrayList<City> route = new ArrayList<City>();

	double length = 0;

	public Path() {

	}

	public Path(Path p, City c) {
		for (City city : p.getRoute()) {
			addCity(city);
			// route.add(city);
		}
		// System.out.println(c);
		// route.add(c);
		addCity(c);
	}

	public void addCity(City c) {
		if (route.size() == 0) {
			route.add(c);
		} else {
			City last = getLastCity();
			for (Neighbor n : last.getNeighbors()) {
				if (n.getCityName().equals(c.getName())) {
					length += n.getDistance();
					route.add(c);
				}
			}
		}
	}

	public City getLastCity() {

		return route.get(route.size() - 1);

	}

	public double getLength() {
		return length;
	}

	public ArrayList<City> getRoute() {
		return route;
	}

	public String toString() {
		String out = "Path: ";

		for (int i = 0; i < getRoute().size(); i++) {
			out += getRoute().get(i).toString();
		}

		return out;
	}

}
