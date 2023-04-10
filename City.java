import java.util.ArrayList;

public class City {

	private String name;
	private MyPoint point;
	private double value;
	ArrayList<Neighbor> neighbors;

	public City(String n, MyPoint p, ArrayList<Neighbor> near) {

		name = n;
		point = p;
		neighbors = near;

	}
	
	public City(String n, MyPoint p, double v, ArrayList<Neighbor> near) {

		name = n;
		point = p;
		value = v;
		neighbors = near;

	}

	public String getName() {

		return name;

	}

	public MyPoint getPoint() {

		return point;

	}
	
	public double getValue() {
		
		return value;
		
	}

	public ArrayList<Neighbor> getNeighbors() {

		return neighbors;

	}
	
	public City getCityByName(ArrayList<City> cities, String name) {
		
        for (City city : cities) {
        	
            if (city.getName().equals(name)) {
            	
                return city;
                
            }
            
        }
        
        return null;
        
    }

	public boolean equals(City c) {
		return this.getName().equals(c.getName());
	}
	
	public String toString() {
		return getName() + " ";
	}

}
