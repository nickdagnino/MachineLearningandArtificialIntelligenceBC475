import java.util.ArrayList;
import java.util.PriorityQueue;

public class PathFinder {

	/**
	 * Breadth-First Search
	 * @param cities
	 * @param s
	 * @param e
	 * @return Path from s to e or null (if goal is not reached)
	 */
	public Path breadthFirstSearch(ArrayList<City> cities, String s, String e) {
		
		long timeStart = System.currentTimeMillis();
		
		City start = getByName(cities, s);
		City end = getByName(cities, e);

		if (start.equals(end)) {

			Path p = new Path();
			System.out.println("Success in Time: " + (System.currentTimeMillis() - timeStart) + " milliseconds");
			return p;

		}

		ArrayList<City> explored = new ArrayList<City>();
		ArrayList<Path> frontier = new ArrayList<Path>();

		Path initialPath = new Path();
		initialPath.addCity(start);
		frontier.add(initialPath);

		while (!frontier.isEmpty()) {

			Path currentPath = frontier.remove(0);
			City currentCity = currentPath.getLastCity();

			explored.add(currentCity);

			for (Neighbor n : currentCity.getNeighbors()) {

				City neighbor = getByName(cities, n.getCityName());
				//double distance = n.getDistance();

				if (!explored.contains(neighbor) && !isInFrontier(frontier, neighbor)) {

					if (neighbor.equals(end)) {

						System.out.println("Success in Time: " + (System.currentTimeMillis() - timeStart) + " milliseconds");
						
						return new Path(currentPath, neighbor);

					}

					explored.add(neighbor);
					frontier.add(new Path(currentPath, neighbor));

				}

			}

		}

		System.out.println("No Path Found");
		return null;

	}

	/**
	 * Uniform Cost Search
	 * @param cities
	 * @param s
	 * @param e
	 * @return Path from s to e or null (if goal is not reached)
	 */
	public Path uniformCostSearch(ArrayList<City> cities, String s, String e) {
		
		long timeStart = System.currentTimeMillis();

		City start = getByName(cities, s);
		City end = getByName(cities, e);

		ArrayList<City> explored = new ArrayList<City>();
		PriorityQueue<Path> frontier = new PriorityQueue<>((p1, p2) -> Double.compare(p1.getLength(), p2.getLength()));

		Path initialPath = new Path();
		initialPath.addCity(start);
		frontier.add(initialPath);

		while (!frontier.isEmpty()) {

			Path currentPath = frontier.poll();
			City currentCity = currentPath.getLastCity();

			if (currentCity.equals(end)) {

				System.out.println("Success in Time: " + (System.currentTimeMillis() - timeStart) + " milliseconds");
				return currentPath;

			}

			explored.add(currentCity);

			for (Neighbor n : currentCity.getNeighbors()) {

				City neighbor = getByName(cities, n.getCityName());
				double distance = n.getDistance();
				double newPathLength = currentPath.getLength() + distance;

				if (!explored.contains(neighbor) && !isInFrontier(frontier, neighbor)) {
					
					explored.add(neighbor);
					frontier.add(new Path(currentPath, neighbor));
					
				}

				else if (isInFrontier(frontier, neighbor)) {

					Path existingPath = getPathInFrontier(frontier, neighbor);
					double existingLength = existingPath.getLength();

					if (newPathLength < existingLength) {

						frontier.remove(existingPath);
						existingPath = new Path(currentPath, neighbor);
						frontier.add(existingPath);

					}

				}

			}

		}

		System.out.println("No Path Found");
		return null;

	}

	/**
	 * A* Search
	 * @param cities
	 * @param s
	 * @param e
	 * @return Path from s to e or null (if goal is not reached)
	 */
	public Path aStarSearch(ArrayList<City> cities, String s, String e) {

		long timeStart = System.currentTimeMillis();
		
		City start = getByName(cities, s);
		City end = getByName(cities, e);

		if(start.equals(end)) {
			
			Path p = new Path();
			System.out.println("Success in Time: " + (System.currentTimeMillis() - timeStart) + " milliseconds");
			return p;
			
		}
		
		ArrayList<City> explored = new ArrayList<City>();
		PriorityQueue<Path> frontier = new PriorityQueue<>((p1, p2) ->
		Double.compare(p1.getLength() + heuristic(p1.getLastCity(), end), p2.getLength() + heuristic(p2.getLastCity(), end)));

		Path initialPath = new Path();
		initialPath.addCity(start);
		frontier.add(initialPath);
		
		while(!frontier.isEmpty()) {
			
			Path currentPath = frontier.poll();
			City currentCity = currentPath.getLastCity();
			
			if(currentCity.equals(end)) {
				
				System.out.println("Success in Time: " + (System.currentTimeMillis() - timeStart) + " milliseconds");
				return currentPath;
				
			}
			
			explored.add(currentCity);
			
			for(Neighbor n : currentCity.getNeighbors()) {
				
				City neighbor = getByName(cities, n.getCityName());
				double distance = n.getDistance();
				double newPathLength = currentPath.getLength() + distance;
				
				if(!explored.contains(neighbor) && !isInFrontier(frontier, neighbor)) {
					
					explored.add(neighbor);
					Path newPath = new Path(currentPath, neighbor);
					frontier.add(newPath);
					
				}
				
				else if(isInFrontier(frontier, neighbor)) {
					
					Path existingPath = getPathInFrontier(frontier, neighbor);
					double existingPathLength = existingPath.getLength();
					
					if(newPathLength > existingPathLength) {
						
						frontier.remove(existingPath);
						existingPath = new Path(currentPath, neighbor);
						frontier.add(existingPath);
						
					}
					
				}
				
			}
			
			
		}
		
		System.out.println("No Path Found");
		return null;

	}

	private boolean isInFrontier(ArrayList<Path> f, City c) {

		for (int i = 0; i < f.size(); i++) {

			if (f.get(i).getLastCity().equals(c)) {

				return true;

			}

		}

		return false;

	}

	private boolean isInFrontier(PriorityQueue<Path> f, City c) {

		for (Path p : f) {

			if (p.getLastCity().equals(c)) {

				return true;

			}

		}

		return false;

	}

	public City getByName(ArrayList<City> cities, String name) {
		
		City c;
		
		for (int i = 0; i < cities.size(); i++) {
			
			if (name.equals(cities.get(i).getName())) {
				
				c = cities.get(i);
				return c;
				
			}
			
		}
		
		return null;
	}

	private Path getPathInFrontier(PriorityQueue<Path> frontier, City c) {
		
		for (Path p : frontier) {
			
			if (p.getLastCity().equals(c)) {
				
				return p;
				
			}
			
		}
		
		return null;
		
	}
	
	private double heuristic(City c1, City c2) {
		
		double dx = c1.getPoint().getX() - c2.getPoint().getX();
		double dy = c1.getPoint().getY() - c2.getPoint().getY();
		
		return Math.sqrt(Math.pow(dx, 2) + Math.pow(dy, 2));
		
	}

}
