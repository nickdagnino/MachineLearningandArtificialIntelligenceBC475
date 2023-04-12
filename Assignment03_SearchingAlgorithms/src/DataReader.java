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

	public ArrayList<City> convertRomania(ArrayList<String> input) {

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

	public Map convertMaze(ArrayList<String> input) {

		String type = input.remove(0);
		// int size = Integer.valueOf(input.remove(0).substring(0, 2));
		int size = Integer.valueOf(input.remove(0).split(" ")[0]);
		double[][] field = new double[size][size];

		for (int i = 0; i < input.size(); i++) {

			String dataLine[] = input.get(i).split(" ");
			double data[] = new double[size];

			for (int j = 0; j < dataLine.length; j++) {

				data[j] = Double.valueOf(dataLine[j]);
				field[i] = data;

			}

		}

		Map map = new Map(type, size, field);

		return map;

	}

	public Map convertMazeTerrain(ArrayList<String> input) {

		String type = input.remove(0);
		int size = Integer.valueOf(input.remove(0).split(" ")[0]);
		double[][] field = new double[size][size];

		if (type.equals("maze")) {

			for (int i = 0; i < input.size(); i++) {

				String dataLine[] = input.get(i).split(" ");
				double data[] = new double[size];

				for (int j = 0; j < dataLine.length; j++) {

					data[j] = Double.valueOf(dataLine[j]);
					field[i] = data;

				}

			}

			Map map = new Map(type, size, field);

			return map;

		}
		
		for (int i = 0; i < input.size(); i++) {

			String dataLine[] = input.get(i).split(" ");
			double data[] = new double[size+1];

			for (int j = 0; j < dataLine.length; j++) {

				data[j] = Double.valueOf(dataLine[j]);
				field[i] = data;

			}

		}

		Map map = new Map(type, size, field);

		return map;
		
	}

}
