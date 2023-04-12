import java.util.ArrayList;

public class Neighbor {

	String cityName;
	double distance;

	public Neighbor(String c, double d) {

		cityName = c;
		distance = d;

	}

	public String getCityName() {

		return cityName;

	}

	public double getDistance() {

		return distance;

	}
	
	public String toString(ArrayList<Neighbor> n) {
		
		String output = "";
		
		for(int i = 0; i < n.size(); i++) {
			output += n.get(i) + " ";
		}
	
		return output;
		
	}

}
