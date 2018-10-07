package Graph;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;


class Node implements Comparable<Node>{
	
    int to;
    int weight;
    
    public Node(int to,int weight) {
	 this.to = to;
	 this.weight = weight;
	}

	@Override
	public int compareTo(Node o) {
		if(this.weight > o.weight)
			return 1;
		else if(this.weight < o.weight)
			return -1;
		return 0;
	}
    
}

class DijkstraGraph {
	
	ArrayList<ArrayList<Node>> list = new ArrayList<ArrayList<Node>>();
	int node;
	
    public DijkstraGraph(int node) {
        this.node = node;
        for(int i = 0 ; i< node ;i++){
        	list.add(new ArrayList<Node>());
        }
    }
    
    public void addEgdes(int from, int to, int weight) {
        list.get(from).add(new Node(to, weight));
        list.get(to).add(new Node(from, weight));
    }
     
    // Find out the min Value index which is not visited yet ( Use priority queue instead which use minHeap )
    public int minDistance(int dist[] , boolean visited[]) {
        int min = Integer.MAX_VALUE;
        int min_index = -1;
        for(int i=0; i<node; i++) {
            if(visited[i] == false && dist[i]<min){
                min = dist[i];
                min_index = i;
            }
        }
        return min_index;
    }
    
    public void Dijkstra( int src ) {
    	
        boolean visited[] = new boolean[node]; 
        int dist[] = new int[node];
        
        for(int i = 0 ; i<node ; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
       
        dist[src] = 0; //Make source value 0 so it pick first by minDistance() function
        
        for(int count=0 ; count<node-1 ; count++) {
            int u = minDistance(dist,visited);
            visited[u] = true;
            
            for(int i =0; i<list.get(u).size(); i++) {
            	
                int weight = list.get(u).get(i).weight;
                int to = list.get(u).get(i).to;
                
                if( dist[u] != Integer.MAX_VALUE && weight+dist[u] < dist[to] ) { // if distance from source is less so we update the distance from u
                	dist[to] = weight + dist[u];
                }
                
            }
        }
        
        for(int i = 0 ;i < node; i++) {
        	System.out.println("distance src = "+src+" node = "+i+" = "+dist[i]);
        }
        
    }
      
    
public void DijkstraHeap( int src ) {
    	
        int dist[] = new int[node];
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>();
        
        for(int i = 0 ; i<node ; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
       
        dist[src] = 0; //Make source value 0 so it pick first by minHeap and no need to visited array if it found again its distance is not less than actual distance
        priorityQueue.add(new Node(src,0));
        
        for(int count=0 ; count<node-1 ; count++) {
            Node node = priorityQueue.poll();
            int u = node.to;
            
            for(int i =0; i<list.get(u).size(); i++) {
                int weight = list.get(u).get(i).weight;
                int to = list.get(u).get(i).to;
                
                
                if( dist[u] != Integer.MAX_VALUE && weight+dist[u] < dist[to] ) { // if distance from source is less so we update the distance from u
                	dist[to] = weight + dist[u];
                	priorityQueue.add(new Node(to,dist[to]));
                }
                
            }
        }
        
        for(int i = 0 ;i < node; i++) {
        	System.out.println("distance src = "+src+" node = "+i+" = "+dist[i]);
        }
        
    }
    
}

public class Dijkstra {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		DijkstraGraph dg = new DijkstraGraph(n);
		int edge = sc.nextInt();
		for(int i =0; i < edge; i++) {
			dg.addEgdes(sc.nextInt(), sc.nextInt(), sc.nextInt());
		}
		
		dg.DijkstraHeap(0);
		sc.close();
	}

}
/*
 * 9
14
0 1 4
0 7 8
1 2 8
1 7 11
7 6 1
7 8 7
2 8 2
8 6 6
2 3 7
2 5 4
6 5 2
3 5 14
3 4 9
5 4 10

 * 
 * 
 * 
 * 
 */
