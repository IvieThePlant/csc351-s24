import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		String filename;
		String algorithm;
		Integer point1 = 0;

		if (args.length != 3) {
			System.out.print("Expecting 3 arguments ");
			System.out.println("(e.g. java Main amsterdamNY.tmg 5 bfs)");
			return;

		} else {
			filename = args[0];
			point1 = Integer.valueOf(args[1]);
			algorithm = args[2];

			if (!algorithm.equals("bfs") &&
					!algorithm.equals("dfs") &&
					!algorithm.equals("dijkstra")) {
				System.out.println("Algorithm must be bfs, dfs, or dijkstra.");
				return;
			}
		}

		RoadGraph graph = LoadGraph.load(filename);
		graph.display();

		System.out.println("__________________________________");
		try {
			PathFinder.findPath(graph, point1, algorithm);

			for (Vertex notWorking : graph.vertices) {
				System.out.println(notWorking.parent());
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		// Ask the user for a destination and use the graph to
		Scanner scanner = new Scanner(System.in);
		System.out.println(graph.vertices.size() + " Waypoints Loaded.");
		System.out.println("Destination Waypoint ID:");
		int point2 = scanner.nextInt();
		while (point2 < 0 || graph.vertices.size() <= point2) {
			System.out.println("Invalid ID. Try Again. (ID = 0:" + (graph.vertices.size() - 1) + ")");
			System.out.println("Destination Waypoints ID:");
			point2 = scanner.nextInt();
		}
		scanner.close();

		// display the path from source to destination and its total cost.
		System.out.println("\nShowing path from Waypoint " + graph.vertices.get(point1).point().toString()
				+ " to Waypoint " + graph.vertices.get(point2).point().toString() + ":");

		// Cost is the sum of the edge weights along the path.
		Vertex v1 = graph.vertices.get(point1);
		Vertex v2 = graph.vertices.get(point2);
		Vertex pointer = v2;
		String path = "" + pointer.point().ID() + " (D = " + pointer.distance() + ")";
		while (!v1.equals(pointer)) {
			pointer = pointer.parent();
			path = pointer.point().ID() + " (D = " + pointer.distance() + ") -> " + path;
		}
		System.out.println("    " + path);
		System.out.println("Cost: " + v2.distance());

	} // end main()
} // end class Main