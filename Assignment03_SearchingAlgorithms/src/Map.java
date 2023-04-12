import java.util.ArrayList;

public class Map {

	String type;
	int size;
	double[][] field;

	public Map(String t, int s, double[][] f) {

		type = t;
		size = s;
		field = f;

	}

	public ArrayList<City> makeCityMaze() {

		ArrayList<City> output = new ArrayList<City>();

		for (int r = 0; r < field.length; r++) {

			for (int c = 0; c < field[0].length; c++) {

				String name = "(" + r + ", " + c + ")";
				MyPoint point = new MyPoint(r, c);
				double value = field[r][c];

				ArrayList<Neighbor> neighbors = getNeighborMaze(r, c);
				City city = new City(name, point, value, neighbors);
				output.add(city);

			}
		}

		return output;
	}

	public ArrayList<City> makeCityTerrain() {

		ArrayList<City> output = new ArrayList<City>();

		for (int r = 0; r < field.length; r++) {

			for (int c = 0; c < field[0].length; c++) {

				String name = "(" + r + ", " + c + ")";
				MyPoint point = new MyPoint(r, c);
				double value = field[r][c];

				ArrayList<Neighbor> neighbors = getNeighborTerrain(r, c);
				City city = new City(name, point, value, neighbors);
				output.add(city);

			}
		}

		return output;
	}

	public ArrayList<Neighbor> getNeighborMaze(int x, int y) {

		ArrayList<Neighbor> neighbors = new ArrayList<Neighbor>();

		// Check neighbor above
		if (x > 0 && field[x - 1][y] == 1) {
			neighbors.add(new Neighbor("(" + (x - 1) + ", " + y + ")", field[x - 1][y]));
		}

		// Check neighbor below
		if (x < field.length - 1 && field[x + 1][y] == 1) {
			neighbors.add(new Neighbor("(" + (x + 1) + ", " + y + ")", field[x + 1][y]));
		}

		// Check neighbor to the left
		if (y > 0 && field[x][y - 1] == 1) {
			neighbors.add(new Neighbor("(" + x + ", " + (y - 1) + ")", field[x][y - 1]));
		}

		// Check neighbor to the right
		if (y < field[0].length - 1 && field[x][y + 1] == 1) {
			neighbors.add(new Neighbor("(" + x + ", " + (y + 1) + ")", field[x][y + 1]));
		}

		return neighbors;
	}
	
	public ArrayList<Neighbor> getNeighborTerrain(int x, int y) {

		ArrayList<Neighbor> neighbors = new ArrayList<Neighbor>();

		// Check neighbor above
		if (x > 0) {
			neighbors.add(new Neighbor("(" + (x - 1) + ", " + y + ")", field[x - 1][y]));
		}

		// Check neighbor below
		if (x < field.length - 1) {
			neighbors.add(new Neighbor("(" + (x + 1) + ", " + y + ")", field[x + 1][y]));
		}

		// Check neighbor to the left
		if (y > 0) {
			neighbors.add(new Neighbor("(" + x + ", " + (y - 1) + ")", field[x][y - 1]));
		}

		// Check neighbor to the right
		if (y < field[0].length - 1) {
			neighbors.add(new Neighbor("(" + x + ", " + (y + 1) + ")", field[x][y + 1]));
		}

		return neighbors;
	}

	public String getType() {

		return type;

	}

	public int getSize() {

		return size;

	}

	public double[][] getField() {

		return field;

	}

	public String toString() {

		String output = "";

		for (int r = 0; r < field.length; r++) {
			for (int c = 0; c < field[0].length; c++) {
				output += field[r][c] + " ";
			}
			output += "\n";
		}

		return output;

	}

}
