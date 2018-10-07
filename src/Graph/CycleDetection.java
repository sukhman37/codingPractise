package Graph;

import java.util.LinkedList;

class Edges {
	int from;
	int to;
	public Edges(int from , int to ) {
		this.from = from;
		this.to = to;
	}
}

class cycleDetect {
	int node;
	//int edge;
	LinkedList<Integer> adj[] ;
	public cycleDetect(int node) {
		this.node = node;
		//this.edge = edge;
		adj = new LinkedList[node];
		for( int i =0 ;i < node;i++ ){
			adj[i] = new LinkedList<Integer>();
		}
	}
	public void addEdge( int from , int to ) {
		//Edges edges = new Edges(from, to);
		adj[from].add(to);
	}
	
	
	public void isCycleDetect(){
		boolean visited[] = new boolean[node];
		boolean beingVisited[] = new boolean[node];
		for(int i =0; i < node;i++){
			if(visited[i] == false)
				isCyclicUtil(i,visited,beingVisited);
		}
	}
	
	void isCyclicUtil( int v, boolean visited[], boolean beingVisited[] ) {
		
		beingVisited[v] = true; // make true so that current vertex is beingVisited as there all child vertex is not yet visited.
		for(int vertex : adj[v]){
			if(beingVisited[vertex]){ // If we again come to vertex which is beingVisited so that there is a cycle.
				System.out.println("There is a cycle form vertex = "+v+" to vertex = "+vertex);
				return;
			}
			if(visited[vertex] == false){
				visited[vertex] = true; // make this vertex as visited
				isCyclicUtil(vertex,visited,beingVisited);
			}
		}
		beingVisited[v] = false; //if all of child is visited so that this vertex is no longer in beingVisited.
		visited[v] = true; // make sure that current vertex is visited
	}
	
}



public class CycleDetection {
	public static void main(String[] args) {
		cycleDetect g = new cycleDetect(4);
		g.addEdge(0, 1);
	    g.addEdge(0, 2);
	    g.addEdge(1, 2);
	    g.addEdge(2, 0);
	    g.addEdge(2, 3);
	    g.addEdge(3, 3);
	    g.isCycleDetect();
	}
}
