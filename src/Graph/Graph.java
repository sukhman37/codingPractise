package Graph;

import java.util.LinkedList;
import java.util.List;

public class Graph {
	//Number of vertex in the graph
	int vertex;
	//Store edge in the form from to To.
	List<Integer> adj[];
	Graph(int vertex){
		this.vertex = vertex;
		adj = new LinkedList[vertex];
		for( int i =0 ;i < vertex;i++ ){
			adj[i] = new LinkedList<Integer>();
		}
	}
	public void addEdge(int from, int to){
		adj[from].add(to);
	}
	
}
