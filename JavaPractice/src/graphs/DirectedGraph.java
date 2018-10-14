package graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

class Edge<T> {
	public Vertex<T> source;
	public Vertex<T> destination;
	public double weight;

	Edge(Vertex<T> source, Vertex<T> destination, double weight) {
		this.source = source;
		this.destination = destination;
		this.weight = weight;
	}
}

class Vertex<T> {
	public T name;
	public List<Edge<T>> connections;

	Vertex(T name) {
		this.name = name;
		connections = new ArrayList<>();
	}

	void addEdge(Edge<T> edge) {
		connections.add(edge);
	}
}

public class DirectedGraph<T> {

	HashMap<T, Vertex<T>> vertexMap;

	int vertexCount;

	DirectedGraph() {

		vertexMap = new HashMap<>();

	}

	public void addEdge(T source, T destination, int weight) {

		Vertex<T> sourceVertex = vertexMap.get(source);
		Vertex<T> destinationVertex = vertexMap.get(destination);

		sourceVertex.addEdge(new Edge<T>(sourceVertex, destinationVertex, weight));

	}

	public void addVertex(T name) {

		vertexMap.put(name, new Vertex<T>(name));
	}

	public List<Vertex<T>> getAllVertex() {
		List<Vertex<T>> vertexList = new ArrayList<>();
		for (Entry<T, Vertex<T>> entry : vertexMap.entrySet()) {
			vertexList.add(entry.getValue());
		}
		return vertexList;
	}

	public static void main(String[] args) {
		DirectedGraph<String> graph = new DirectedGraph<String>();

		graph.addVertex("a");
		graph.addVertex("b");
		graph.addVertex("c");
		graph.addVertex("d");
		graph.addVertex("e");

		graph.addEdge("a", "b", 1);
		graph.addEdge("a", "c", 3);
		graph.addEdge("a", "d", 2);
		graph.addEdge("b", "d", 6);
		graph.addEdge("c", "e", 5);
		graph.addEdge("d", "e", 4);

		
		GraphTraversal g = new GraphTraversal();
		
		System.out.println("\n BFS :");
		g.bfs(graph);
		
		System.out.println("\n DFS :");
		g.dfs(graph);
		
		
		System.out.println("\n find node between b and c");
		List<Vertex<String>> list=g.findRoute(graph,graph.vertexMap.get("b"),graph.vertexMap.get("c"));
		
		for(Vertex<String> str:list)
			System.out.println(" "+str.name);
	}

}
