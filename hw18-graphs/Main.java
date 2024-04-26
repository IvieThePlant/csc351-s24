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
			
			if (
				!algorithm.equals("bfs") && 
				!algorithm.equals("dfs") &&
				!algorithm.equals("dijkstra")
			) {
				System.out.println("Algorithm must be bfs, dfs, or dijkstra.");
				return;
			}
		}

		RoadGraph graph = LoadGraph.load(filename);
		graph.display();	

		System.out.println("__________________________________");
		try {
			PathFinder.findPath(graph, point1, algorithm);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// Ask the user for a destination and use the graph to
		// display the path from source to destination and its total cost.
		// Cost is the sum of the edge weights along the path.
		
	} // end main()
} // end class Main