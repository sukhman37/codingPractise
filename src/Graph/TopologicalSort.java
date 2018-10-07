package Graph;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

class GraphNodes{
	
	int vertex;
	LinkedList<Integer> adj[] ;
	
	GraphNodes(int vertex){
		this.vertex = vertex;
		adj = new LinkedList[vertex];
		for( int i =0 ;i < vertex;i++ ){
			adj[i] = new LinkedList<Integer>();
		}
	}
	public void addEdge(int from, int to){
		adj[from].add(to);
	}
	
	public void topologicalSort(){
		
		Stack<Integer> stack = new Stack<Integer>();
		boolean visited[] = new boolean[vertex];
		
		for( int i=0; i< vertex; i++ ){
			if( visited[i] == false )
				topologicalSortUtil(i, visited, stack);
		}
		while(!stack.isEmpty()){
			System.out.println(stack.pop()+" ");
		}
		
	}
	
	public void topologicalSortUtil( int v, boolean visited[], Stack<Integer> stack ){
		
		visited[v] = true;
		Iterator<Integer> iter = adj[v].iterator();
		while(iter.hasNext()){
			int i = iter.next();
			if(!visited[i]){
				topologicalSortUtil(i, visited, stack);
			}
		}
		stack.push(v);
	}	
}

public class TopologicalSort {
	
	public static void main(String[] args) {
		int vertex = 6;
		GraphNodes graphNodes = new GraphNodes(vertex);
		graphNodes.addEdge(5, 2);
		graphNodes.addEdge(5, 0);
		graphNodes.addEdge(4, 1);
		graphNodes.addEdge(4, 0);
		graphNodes.addEdge(2, 3);
		graphNodes.addEdge(3, 1);
		graphNodes.topologicalSort();
	}
}
