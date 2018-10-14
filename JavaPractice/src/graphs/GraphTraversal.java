package graphs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class GraphTraversal {

	public void bfs(DirectedGraph<String> graph) {

		List<Vertex<String>> vertexList = graph.getAllVertex();
		Set<String> visited = new HashSet<>();

		Queue<Vertex<String>> queue = new LinkedList<>();

		queue.add(vertexList.get(0));

		while (!queue.isEmpty()) {
			Vertex<String> v = queue.peek();
			queue.remove();

			if (!visited.contains(v.name)) {
				System.out.print(" " + v.name);
				visited.add(v.name);
			}

			for (Edge<String> e : v.connections) {
				if (!visited.contains(e.destination)) {
					queue.add(e.destination);
				}
			}
		}

	}

	public void dfs(DirectedGraph<String> graph) {

		List<Vertex<String>> vertexList = graph.getAllVertex();
		Set<String> visited = new HashSet<>();

		Stack<Vertex<String>> stack = new Stack<>();

		stack.add(vertexList.get(0));
		visited.add(vertexList.get(0).name);
		System.out.print(" " + vertexList.get(0).name);

		while (!stack.isEmpty()) {

			Vertex<String> v = getAdjacent(stack.peek(), visited);

			if (v == null)
				stack.pop();
			else {
				System.out.print(" " + v.name);
				visited.add(v.name);
				stack.push(v);
			}

		}

	}

	private Vertex<String> getAdjacent(Vertex<String> v, Set<String> visited) {

		for (Edge<String> e : v.connections)
			if (!visited.contains(e.destination.name))
				return e.destination;
		return null;

	}

	public List<Vertex<String>> findRoute(DirectedGraph<String> graph, Vertex<String> source,
			Vertex<String> destination) {

		Set<String> visited = new HashSet<>();
		List<Vertex<String>> result = new ArrayList<Vertex<String>>();
		Queue<Vertex<String>> queue = new LinkedList<>();

		queue.add(source);

		while (!queue.isEmpty()) {
			Vertex<String> v = queue.peek();
			queue.remove();

			if (!visited.contains(v.name)) {
				result.add(v);
				visited.add(v.name);
				if (v.name == destination.name)
					return result;
			}

			for (Edge<String> e : v.connections) {
				if (!visited.contains(e.destination)) {
					queue.add(e.destination);
				}
			}
		}
		return null;

	}

}
