import java.util.ArrayList;

public class Workspace {
	
	static DataReader reader = new DataReader();
	static DataDisplay display = new DataDisplay();
	static PathFinder finder  = new PathFinder();

	public static void main(String[] args) {

		
		//String path = "romania.txt";
		//String path = "maze01-tiny.txt";
		//String path = "maze02-tiny.txt";
		//String path = "maze03-small.txt";
		//String path = "maze04-small.txt";
		//String path = "maze05-medium.txt";
		//String path = "maze06-medium.txt";
		//String path = "maze07-large.txt";
		//String path = "maze08-large.txt";
		//String path = "maze09-huge.txt";
		//String path = "maze10-huge.txt";
		//String path = "terrain01-tiny.txt";
		//String path  = "terrain10-huge.txt";
		
//		// -Romania-
//		
//		ArrayList<String> dataString = reader.readFile(path);
//		ArrayList<City> dataCities = reader.convertRomania(dataString);
//		
//		display.displayRomaniaData(dataCities);
//
//		//Path p = finder.breadthFirstSearch(dataCities, "Lugoj", "Iasi");
//		//Path p = finder.uniformCostSearch(dataCities, "Lugoj", "Iasi");
//		Path p = finder.aStarSearch(dataCities, "Lugoj", "Iasi");
//		System.out.println(p);
//		System.out.println(p.getLength());
//		// -Romania-
		
//		// -Maze-
//		
//		ArrayList<String> mapString = reader.readFile(path);
//		Map map = reader.convertMazeTerrain(mapString);
//		ArrayList<City> points = map.makeCityMaze();
//		String size = map.getSize()-1 + "";
//		Path p = finder.breadthFirstSearch(points, "(0, 0)", "(" + size + ", " + size + ")" );
//		Path p1 = finder.uniformCostSearch(points, "(0, 0)", "(" + size + ", " + size + ")" );
//		Path p2 = finder.aStarSearch(points, "(0, 0)", "(" + size + ", " + size + ")" );
//		System.out.println(p + "\n" + p1 + "\n" + p2);
//		
//		// -Maze-
		
//		// -Terrain-
//		
//		ArrayList<String> mapString = reader.readFile(path);
//		Map map = reader.convertMazeTerrain(mapString);
//		ArrayList<City> points = map.makeCityTerrain();
//		String size = map.getSize()-1 + "";
//		Path p = finder.breadthFirstSearch(points, "(0, 0)", "(" + size + ", " + size + ")" );
//		Path p1 = finder.uniformCostSearch(points, "(0, 0)", "(" + size + ", " + size + ")" );
//		Path p2 = finder.aStarSearch(points, "(0, 0)", "(" + size + ", " + size + ")" );
//		System.out.println(p + "\n" + p1 + "\n" + p2);
//		
//		// -Terrain-

	}

}
