import java.util.ArrayList;


public class DataDisplay {

	public int width = 2500;
	public int height = 800;

	public void displayRomaniaData(ArrayList<City> cities) {

		StdDraw.enableDoubleBuffering();

		StdDraw.setCanvasSize(width / 2, height);
		StdDraw.setXscale(0, width / 2);
		StdDraw.setYscale(0, height);

		for (int i = 0; i < cities.size(); i++) {

			String name = cities.get(i).getName();
			double x = cities.get(i).getPoint().getX();
			double y = cities.get(i).getPoint().getY();

			ArrayList<Neighbor> neighbor = cities.get(i).getNeighbors();

			for (int j = 0; j < neighbor.size(); j++) {

				String n = neighbor.get(j).getCityName();
				double d = neighbor.get(j).getDistance();

				for (int k = 0; k < cities.size(); k++) {

					if (n.equals(cities.get(k).getName())) {

						double x1 = cities.get(k).getPoint().getX();
						double y1 = cities.get(k).getPoint().getY();

						StdDraw.setPenColor(0, 255, 0);
						StdDraw.setPenRadius(.01);
						StdDraw.line(x, y, x1, y1);
						StdDraw.setPenColor(0, 0, 0);
						StdDraw.text((x + x1) / 2, (y + y1) / 2, d + "");

					}

				}

			}

			StdDraw.setPenColor(255, 0, 255);
			StdDraw.filledCircle(x, y, 2.5);
			StdDraw.textLeft(x, y, " " + name);

		}

		StdDraw.show();

	}

	public void drawMapPath(Path path){

		for(int i = 0; i < path.getRoute().size()-1; i++){

			double x1 = path.getRoute().get(i).getPoint().getX();
			double y1 = path.getRoute().get(i).getPoint().getY();

			double x2 = path.getRoute().get(i+1).getPoint().getX();
			double y2 = path.getRoute().get(i+1).getPoint().getY();

			StdDraw.setPenColor(255, 0, 0);
			StdDraw.line(x1, y1, x2, y2);

			StdDraw.show();

			try {

			Thread.sleep(250);

			} catch (InterruptedException e) {

				System.err.println("Sleep interrupted: " + e.getMessage());

			}
			
		}

		for(int i = 0; i < path.getRoute().size()-1; i++){

			double x1 = path.getRoute().get(i).getPoint().getX();
			double y1 = path.getRoute().get(i).getPoint().getY();

			double x2 = path.getRoute().get(i+1).getPoint().getX();
			double y2 = path.getRoute().get(i+1).getPoint().getY();

			StdDraw.setPenColor(0, 255, 0);
			StdDraw.line(x1, y1, x2, y2);

			StdDraw.show();
			
		}

	}

	public void displayMazeData(){}

	public void displayTerrainData(){}

}

