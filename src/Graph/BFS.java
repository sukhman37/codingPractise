package Graph;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/*
 * Used in dijkstra algorithms
 * 
 */
public class BFS extends Graph{
	
	BFS(int vertex) {
		super(vertex);
	}
	
	public void BFSearch( int start ){
		
		boolean visited[] = new boolean[vertex];
		Queue<Integer> queue = new LinkedList<Integer>();
		
		queue.add(start);
		visited[start] = true;
		
		while(!queue.isEmpty()){
			
			int data = queue.poll();
			System.out.println(data);
			
			for(int item : adj[data]){
				if(visited[item] == false){
					visited[item] = true;
					queue.add(item);
				}		
			}
			
		}
	}

	public static void main(String[] args) {
		BFS bfs = new BFS(4);
		bfs.addEdge(0, 1);
		bfs.addEdge(0, 2);
		bfs.addEdge(1, 2);
		bfs.addEdge(2, 0);
		bfs.addEdge(2, 3);
		bfs.addEdge(3, 3);
		bfs.BFSearch(2);
 
	}
}
