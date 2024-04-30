import java.util.ArrayList;
import java.util.PriorityQueue;

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

	private static void Dijkstra(RoadGraph G, int s) {
		// Initialize-Single-Source(G, s)
		for (Vertex v : G.vertices) {
			v.distance(Double.POSITIVE_INFINITY);
			v.parent(null);
		}

		G.vertices.get(s).distance(0.0);

		// Initialize solution array
		ArrayList<Vertex> S = new ArrayList<>();

		// Initalize queue
		PriorityQueue<Vertex> Q = new PriorityQueue<>();

		// Push all vertices to queue
		for (Vertex x : G.vertices) {
			Q.add(x);
		}

		// Process the queue
		while (!Q.isEmpty()) {
			Vertex u = Q.poll();
			System.out.println("*u.d = " + u.distance());
			S.add(u);

			// Process each adjacent vertex
			for (RoadSegment edge : u.adjacent()) {
				// Find other point
				Vertex v;
				if (u.point().equals(edge.point1())) {
					v = G.vertices.get(edge.point2().ID());
				} else {
					v = G.vertices.get(edge.point1().ID());
				}
				System.out.println("v.d = " + v.distance());
				System.out.println("(" + edge.point1().ID() + ", " + edge.point2().ID() + ")");
				Relax(u, v, edge, Q);

			}
		}
	}

	// Relax the distance of v if edge is shorter
	private static void Relax(Vertex u, Vertex v, RoadSegment edge, PriorityQueue<Vertex> Q) {
		System.out.println("edge.d = " + edge.distance());
		if (v.distance() > u.distance() + edge.distance()) {
			v.distance(u.distance() + edge.distance());
			v.parent(u);
			System.out.println("v.d = " + v.distance());
			System.out.println("v.p = " + v.parent().distance());
			Q.remove(v);
			Q.add(v);
		}
	}
}