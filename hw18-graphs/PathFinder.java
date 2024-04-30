public class PathFinder {

	public static void findPath(RoadGraph graph, int point1, String algo) {

		System.out.println("Traverse the graph to find a path.");

		// Initialize our Node queue
		QueueInterface<Vertex> Q;

		// Check what search method to use
		if (algo.equals("bfs")) {
			Q = new Queue<>();
		} else if (algo.equals("dfs")) {
			Q = new Stack<>();
		} else {
			Dijkstra(graph, point1);
			return;
		}

		/*
		 * Create the queue, appropriate for the type of traversal
		 * 
		 * push the starting waypoint onto the queue
		 * while the queue is not empty
		 * pop from the queue
		 * for each adjacent waypoint of that popped vertex
		 * if adjacent not yet visited (visited will be false)
		 * push onto the queue
		 * set parent
		 * set as visited
		 */

		// Push the starting waypoint onto the queue
		Q.push(graph.vertices.get(point1));

		// While the queue is not empty
		while (!Q.isEmpty()) {
			// Pop from the queue
			Vertex current = Q.pop();

			// For each adjacent waypont of popped vertex
			for (RoadSegment edge : current.adjacent()) {
				// Find what its connected to
				Vertex other;
				if (current.equals(graph.vertices.get(edge.point1().ID()))) {
					other = graph.vertices.get(edge.point2().ID());
				} else {
					other = graph.vertices.get(edge.point1().ID());
				}

				// If adjecent not visited
				if (!other.visited()) {
					// Push onto the queue
					Q.push(other);

					// Set parent
					other.parent(current);

					// Mark as visited
					other.visited(true);
				}
			}
		}
	}

	public static void Dijkstra(RoadGraph G, int s) {
		// Initialize-Single-Source(G, s)

	}

	/**
	 * Dijkstra(G, w, s)
	 * Initialize-Single-Source(G, s)
	 * S = 0
	 * Q = G.V
	 * while Q != 0
	 * u = Extract-Min(Q)
	 * S = S union {u}
	 * for each vertex v in G.Adj[u]
	 * Relax(u, v, w)
	 * 
	 * Relax(u, v, w)
	 * if v.d > u.d + w(u, v)
	 * v.d = u.d + w(u, v)
	 * v.p = u
	 */
}