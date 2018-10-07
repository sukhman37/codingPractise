package Graph;

import java.util.Iterator;
import java.util.LinkedList;

class Graphs {
	//Number of vertex in the graph
	int vertex;
	//Store edge in the form from to To.
	LinkedList<Integer> adj[];
	Graphs(int vertex){
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

class DFSe extends Graphs{

	DFSe(int vertex) {
		super(vertex);
	}
	
	public void DFSearch(int start){
		boolean visited[] = new boolean[vertex];
		DFSearchUtil(start, visited);
	}
	
	public void DFSearchUtil(int vertex, boolean visited[] ){
		visited[vertex] = true;
		System.out.print(vertex+" ");
		
		Iterator<Integer> iter = adj[vertex].iterator();
		while(iter.hasNext()) {
			int data = iter.next();
			if(visited[data] == false){
				DFSearchUtil(data, visited);
			}
		}
		
	}
}

public class Test {
	public static void main(String[] args) {
		DFS dfs = new DFS(1000);
		dfs.addEdge(0, 1);
		dfs.addEdge(1, 0);
		dfs.addEdge(1, 2);
		dfs.addEdge(2, 1);
		dfs.addEdge(3, 4);
		dfs.addEdge(4, 3);
		boolean visited[] = new boolean[5];
		for (int i = 0; i < 5; i++) {
			if (visited[i] == false) {
				dfs.DFSearchUtil(i, visited);
				System.out.println();
			}
		}

	}

}
