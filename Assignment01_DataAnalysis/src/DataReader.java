import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class DataReader {

	public ArrayList<String> readFile(String path) {

		ArrayList<String> output = new ArrayList<String>();

		try {

			File file = new File(path);
			Scanner input = new Scanner(file);

			while (input.hasNext()) {

				output.add(input.nextLine());

			}

			input.close();

			return output;
		}

		catch (Exception e) {

			e.printStackTrace();

		}

		return null;

	}

	public ArrayList<MyPoint> convertTo1D(ArrayList<String> input) {

		ArrayList<MyPoint> output = new ArrayList<MyPoint>();

		for (int i = 0; i < input.size(); i++) {

			MyPoint p = new MyPoint(Double.valueOf(input.get(i)));
			output.add(p);

		}

		System.out.print(output.size());
		return output;
	}

	public ArrayList<MyPoint> convertTo2D(ArrayList<String> input) {

		ArrayList<MyPoint> output = new ArrayList<MyPoint>();

		for (int i = 0; i < input.size(); i++) {

			String dataLine[] = input.get(i).split(", ");
			MyPoint p = new MyPoint(Double.valueOf(dataLine[0]), // x
					Double.valueOf(dataLine[1]));// y
			output.add(p);

		}

		return output;

	}

	public ArrayList<MyPoint> convertTo3D(ArrayList<String> input) {

		ArrayList<MyPoint> output = new ArrayList<MyPoint>();

		for (int i = 0; i < input.size(); i++) {

			String dataLine[] = input.get(i).split(", ");
			MyPoint p = new MyPoint(Double.valueOf(dataLine[0]), // x
					Double.valueOf(dataLine[1]), // y
					Double.valueOf(dataLine[2]));// z
			output.add(p);

		}

		return output;

	}

	public ArrayList<City> convertMystery(ArrayList<String> input) {

		ArrayList<City> output = new ArrayList<City>();

		for (int i = 0; i < input.size(); i++) {

			String dataLine[] = input.get(i).split(", ");
			String name = dataLine[0];
			MyPoint point = new MyPoint(Double.valueOf(dataLine[1]), Double.valueOf(dataLine[2]));

			ArrayList<Neighbor> neighbors = new ArrayList<Neighbor>();

			for (int j = 3; j < dataLine.length; j += 2) {
				String nName = dataLine[j];
				double distance = Double.valueOf(dataLine[j + 1]);
				Neighbor neighbor = new Neighbor(nName, distance);
				neighbors.add(neighbor);
			}

			City c = new City(name, point, neighbors);

			output.add(c);

		}

		return output;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
