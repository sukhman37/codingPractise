package Graph;

import java.util.ArrayList;
import java.util.Scanner;


class Edge {
	int from;
	int to;
	int weight;
	public Edge(int from , int to , int weight) {
		this.from = from;
		this.to = to;
		this.weight = weight;
	}
}

class BellmonGraph {
	int node;
	int edge;
	ArrayList<Edge> edges;
	public BellmonGraph(int node, int edge) {
		this.node = node;
		this.edge = edge;
		edges = new ArrayList<Edge>();
	}
	public void addEdge( int from , int to , int weight ) {
		Edge edge = new Edge(from, to, weight);
		edges.add(edge);
	}
	
	public void Bellmon ( int src ) {
		int dist[] = new int[node];
		
		for(int i =0 ;i<node ;i++) {
			dist[i] = Integer.MAX_VALUE;
		}
		dist[src] = 0;
		for(int i=1; i<=node-1 ;i++) {
			for(int j = 0 ; j < edge ; j++ ) {
				int u = edges.get(j).from;
				int to = edges.get(j).to;
				int weight = edges.get(j).weight;
				
				if(dist[u]!=Integer.MAX_VALUE && dist[u]+weight<dist[to]) {
					dist[to] = dist[u] + weight;
				}
			}
		}
		
			for(int j = 0 ; j < edge ; j++ ) {
				int u = edges.get(j).from;
				int v = edges.get(j).to;
				int weight = edges.get(j).weight;
				
				if(dist[u]!=Integer.MAX_VALUE && dist[u]+weight<dist[v]) {
					System.out.println("Negative weight cycle in graph");
					return ;
				}
			}
		for(int i =0; i<node; i++) {
			System.out.println(dist[i]);
		}
	}
}




public class BellmonFord {
		public static void main(String[] args) {
		 Scanner sc = new Scanner(System.in);
		 int node = sc.nextInt();
		 int edge = sc.nextInt();
		 BellmonGraph bellmonGraph = new BellmonGraph(node,edge);
		 for(int i =0 ;i <edge ;i++) {
			 bellmonGraph.addEdge(sc.nextInt(), sc.nextInt(), sc.nextInt());
		 }
		 bellmonGraph.Bellmon(0);
		 sc.close();
	}
}
