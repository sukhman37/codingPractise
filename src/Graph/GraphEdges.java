package Graph;

import java.util.ArrayList;

class GraphEdge{
	int from; 
	int to;
	GraphEdge(int from,int to){
		this.from = from;
		this.to = to;
	}
	
}

public class GraphEdges {
	int node;
	int edge;
	ArrayList<GraphEdge> edges;
	public GraphEdges(int node, int edge) {
		this.node = node;
		this.edge = edge;
		edges = new ArrayList<GraphEdge>();
	}
	
	public void addEdges(int from, int to){
		GraphEdge graphEdges =  new GraphEdge(from, to);getClass();
		edges.add(graphEdges);
	}
	

}
